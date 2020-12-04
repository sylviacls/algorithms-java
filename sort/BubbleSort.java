import org.junit.Assert;
import org.junit.Test;

/***
 * Bubble sort is a simple algorithm that repeatedly steps through the list, compares adjacent elements 
 * and swaps them if they are in the wrong order. The pass through the list is repeated until the list
 * is sorted. 
 * 
 * The whole array is setted as unsortedPartition (index = leght- 1) 
 * Transverse left to right until the unsortedPartition
 * "Bubbles" the largest values to the top
 * Repeatedly steps through the list and compare adjacents elements and swap them if 
 * they are in wrong order.
 * 
 * In-place Algorithm (Memory complexity): Its made a logical partition between Sorted and Unsorted. 
 * Only local variables are used and that doesn't depende on the size of number you're sorting 
 * We don't have to create another array.
 * 
 * O(n²) time-complexity
 * It's a stable algorith
 * We can make a pre-ordering (like shell sorting) and then performer the bubble sort
 */

public class BubbleSort {

    // [4, 2, 7, 10, 1, 3]
    public static void bubbleSort(int[] list) {

        for(int unsortedPartitionIndex = list.length - 1; unsortedPartitionIndex > 0;
           unsortedPartitionIndex-- ) {
            for (int i = 0; i< unsortedPartitionIndex; i++) {
                if(list[i] > list[i+1]) {
                    swap(list, i, i+1);
                }
            }
        }
    }

    public static void swap(int[] list, int i, int j) {
        int temp = list[i];
        list[i] = list[i+1];
        list[i+1] = temp;
    }

    @Test
    public void validate(){
        int[] list = {4, 32, 32, 700, -7, 0, 10, 13, 3, 1};
        int[] list2 = {20,35,-15,7, 55,1,-22};
        int[] list3 = {1,10, -3, 0, 45, 13, 4};
        BubbleSort.bubbleSort(list);
        BubbleSort.bubbleSort(list2);
        BubbleSort.bubbleSort(list3);        
        Assert.assertArrayEquals(new int[]{-7,0,1,3,4,10,13,32,32,700}, list);
        Assert.assertArrayEquals(new int[]{-22,-15,1,7,20,35,55}, list2);
        Assert.assertArrayEquals(new int[]{-3,0,1,4,10,13,45}, list3);
    }

}