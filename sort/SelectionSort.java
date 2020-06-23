import org.junit.*;

/**
 * The name "Selection" is because this algorithm works "selecting" the smallest element
 * while transversing the array.
 * 
 * In-place Algorithm
 * Time complexity: O(n²) 
 * 
 * Doesn't require as much swapping as Bubble Sort
 * Alternativelly it could be thinked by selecting the maximum value and placing it at the end
 */

public class SelectionSort {
  
    //looking for the smallest
    // [20,35,-15,7, 55,1,-22] 
    public static void selectionSort(int[] list) {
        for (int i = 0; i < list.length; i++) {
          int indexSmallest = i;
          for (int j = i+1; j < list.length; j++){
            if(list[j] < list[indexSmallest]) {
              indexSmallest = j;
            }
          }
          if(list[indexSmallest] != list[i]) {
            swap(list, i, indexSmallest);
          }
        }
      }
      
    public static void swap(int[] list, int i, int j) {
      int temp = list[j];
      list[j]= list[i];
      list[i] = temp;
  }
    @Test
    public void validate() {

      int[] list = {20,35,-15,7, 55,1,-22};
      int[] list2 = {1,10, -3, 0, 45, 13, 4};
      SelectionSort.selectionSort(list);
      SelectionSort.selectionSort(list2);

      Assert.assertArrayEquals(new int[]{-22,-15,1,7,20,35,55}, list);
      Assert.assertArrayEquals(new int[]{-3,0,1,4,10,13,45}, list2);

    }


}