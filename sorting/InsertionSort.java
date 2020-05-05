/*
- Work left to right, examine each element and compare it to items on its left 
- and INSERT it in correct position (swapping them)
- Set a marker for the sortedPartition after the first element
- Select the new unsorted element (sortedPartition + 1)
- It works making "insertion" of the newElement in the sortedPartition (looping)
- swapping the elements in the sortedPartition to the right until find the right position for the new Element
- sortedPartitionIndex starts at 0 index, it grows left to right, 
- O(n²)
- If the list is nearly ordered O(n) cause only few shifting will be necessary
*/

public class InsertionSort {

    public static void insertionSort(int[] list) {
      /* [20,35,-15,7, 55,1,-22] 
      * take each new element in unsortedPartion
      * go towards sortedPartion making space (to the right) through elements until
      * reach the beggining of sortedPartion or the correct position for new element
      */ 
      for(int i = 1; i < list.length; i++) {

        int newElement = list[i];
        int j = i;
        while(j > 0 && newElement < list[j-1]) {
          list[j] = list[j-1]; //making space
          j--;
        }
        list[j] = newElement; // putting new element at its right position

      }
    }

    public static void insertionSortRecursive(int[] list, int n) {
      /* [20,35,-15,7, 55,1,-22] 
      * take each new element in unsortedPartion
      * go towards sortedPartion making space (to the right) through elements until
      * reach the beggining of sortedPartion or the correct position for new element
      */ 
      if(n < 2 ) {
        return;
      }

      insertionSortRecursive(list, n-1);

      int newElement = list[n-1];
      int i = n-1; 
      while (i > 0 && newElement < list[i-1]) {
        list[i] = list[i-1]; //making space
        i--;
      }
      list[i] = newElement; //putting new element at its right place
      System.out.println("");
      System.out.println("Result when n is " + n);
      for (int number : list) {
        System.out.print(number +", ");
      }
      System.out.println("");
    }
    
    public static void main(String[] args) {

        int[] list = {20,35,-15,7, 55,1,-22};
         insertionSortRecursive(list, list.length);
     //   insertionSort(list);
        for (int i : list) {
          System.out.println(i);
        }

    }

}