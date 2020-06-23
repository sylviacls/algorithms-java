import org.junit.*;

/**
 * It works left to right, examining each element and compare it to items on its left 
 * and INSERT it in correct position (swapping them)
 * We set a marker for the sortedPartition after the first element
 * Select the new unsorted element (sortedPartition + 1)
 * 
 * It works making "insertion" of the newElement in the sortedPartition (looping)
 * swapping the elements in the sortedPartition to the right until find the right position for the new Element
 * sortedPartitionIndex starts at 0 index, it grows left to right, 
 * 
 * Time complexity: O(n²)
 * If the list is nearly ordered it will be O(n) cause only few shifting would be necessary
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
      if(n <= 1 ) {
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
    }
    
    @Test
    public void validate() {
        int[] list1 = {20,35,-15,7, 55,1,-22};
        int[] list2 = {0,10,-15,4, 30, 1,-2};
        insertionSort(list1);
        insertionSortRecursive(list2, list2.length);
        Assert.assertArrayEquals(new int[] {-22, -15, 1, 7, 20, 35, 55}, list1);
        Assert.assertArrayEquals(new int[] {-15, -2, 0, 1, 4, 10, 30}, list2);
    }

}