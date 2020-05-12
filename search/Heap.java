/**
 * - Heapsort:
 * - In a Heap We know the root has the largest value
 * - So, we swap root with last element in array
 * - And then Heapify the tree, excluding the last node
 * - After heapify, the second larger element is at the root
 * - So, again we swap root with the last element (using lastHeapIndex)
 * - O(n log n): the loop takes O(n) and for each iteration we'll have O(log n) for heapify
 * - After sorting we will no longer have a heap
 */

public class Heap {
    
    private int[] heap;
    private int size; //it will point to the next available position

    public Heap(int capacity) {
        heap = new int[capacity];
    }
    /**
     * Insert a value into the Heap
     * @param value
     */
    public void insert(int value) {
        if (isFull()) {
            throw new IndexOutOfBoundsException("Heap is full");
        }

        heap[size] = value;
        //After a insertion we have to fix the Heap in a bottom-up approach
        fixHeapAbove(size);
        size++;
    }

    /**
     * Peek the root of the heap
     * @return the root
     */
    public int peek() {
        if (isEmpty()) {
            throw new IndexOutOfBoundsException("Heap is empty");
        }

        return heap[0];
    }

    /**
     * Delete the node indicated by the index
     *  For the replacement node: the rightmost value, so the tree remais "complete"
     * @param index of the node
     * @return the value of the deleted node
     */
    public int delete(int index) {
        if (isEmpty()) {
            throw new IndexOutOfBoundsException("Heap is empty");
        }

        int parent = getParent(index);
        int deletedValue = heap[index];

        //replacement node = the rightmost node
        heap[index] = heap[size - 1];

        //check to see what kind of fixing is needed
        if (index == 0 || heap[index] < heap[parent]) {
            fixHeapBelow(index, size - 1);
        }
        else {
            fixHeapAbove(index);
        }

        size--;

        return deletedValue;

    }

    /**
     * Fix the Heap bottom-up
     * @param index index of the desired node
     */
    private void fixHeapAbove(int index) {
        int newValue = heap[index];
        while (index > 0 && newValue > heap[getParent(index)]) {
            heap[index] = heap[getParent(index)];
            index = getParent(index);
        }

        heap[index] = newValue;
    }

    /**
     * Fix the Heap top-down
     * @param index index of the desired node
     * @param lastHeapIndex
     */
    private void fixHeapBelow(int index, int lastHeapIndex) {
        int childToSwap;

        while (index <= lastHeapIndex) {
            int leftChild = getChild(index, true);
            int rightChild = getChild(index, false);
            if (leftChild <= lastHeapIndex) {
                if (rightChild > lastHeapIndex) {
                    childToSwap = leftChild;
                }
                else {
                    childToSwap = (heap[leftChild] > heap[rightChild] ? leftChild : rightChild);
                }

                if (heap[index] < heap[childToSwap]) {
                    int tmp = heap[index];
                    heap[index] = heap[childToSwap];
                    heap[childToSwap] = tmp;
                }
                else {
                    break;
                }

                index = childToSwap;
            }
            else {
                break;
            }
        }
    }

    public void printHeap() {
        for (int i = 0; i < size; i++) {
            System.out.print(heap[i]);
            System.out.print(", ");
        }
        System.out.println();
    }

    public boolean isFull() {
        return size == heap.length;
    }
    /**
     * Return the index of node's parent using the formula: 
     * iParent = (iNode - 1) / 2
     * @param index index of the node
     */
    public int getParent(int index) {
        return (index - 1) / 2;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * Return the index of node's child using the formula: 
     * iChildLeft = 2* iNode + 1
     * iChildRight = 2* iNode + 2
     * @param index index of the node
     * @param left true for the left child, false for the right child 
     * @return the index of the child
     */
    public int getChild(int index, boolean left) {
        return 2 * index + (left ? 1 : 2);
    }

    public static void main(String[] args) {
        Heap heap = new Heap(10);

        heap.insert(80);
        heap.insert(75);
        heap.insert(60);
        heap.insert(68);
        heap.insert(55);
        heap.insert(40);
        heap.insert(52);
        heap.insert(67);

        heap.printHeap();

        System.out.println(heap.peek());

        heap.delete(0);
        heap.printHeap();

        System.out.println(heap.peek());

    }
}