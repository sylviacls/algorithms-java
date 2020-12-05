import org.junit.Assert;
import org.junit.Test;

/**
 * The input list is divided into two sub-lists by an element called pivot; one sub-list with elements
 * less than the pivot and another one with elements greater than the pivot. This process repeats for
 * each sub-list.
 * 
 * Time Complexity: O(n logn) - average case (better than merge sort) - it depends on pivot selection
 *                  O(n²) - worst case
 * In-place, unstable
 *  * Most libraries implement the quicksort for their Sortings methods
 * 
 *  Steps: 
 *   1) We choose an element from the list, called the pivot. We'll use it to divide the list into
 *      two sub-lists.
 *   2) We reorder all the elements around the pivot – the ones with smaller value are placed before it,
 *      and all the elements greater than the pivot after it. After this step, the pivot is in its final
 *      position. This is the important partition step.
 *   3) We apply the above steps recursively to both sub-lists on the left and right of the pivot.
 * 
 * Merge sort is more efficient and works faster than quick sort in case of larger array size or datasets.
 * Quick sort is more efficient and works faster than merge sort in case of smaller array size or datasets.
 */
public class QuickSort {

    public static void quickSort(int[] list) {
        quickSort(list, 0, list.length-1);
    }

    public static void quickSort(int[] list, int start, int end) {
        if (start >= end) {
            return;
        }
        int index = partition(list, start, end);
        quickSort(list, start, index-1);
        quickSort(list, index+1, end);
    }

   
    //{20,35,-15,7, 55,1,-22};
    public static int partition(int[] list, int start, int end) {
        int pivot = list[start];
        int i = start+1;
        int j = end;
        
        while (i <= j ) {
            while(i <= end && list[i] < pivot ) {
                i++;
            } 
            while(j >= start && list[j]> pivot) {
                j--;
            }
            if (i <= j) {
                swap(list, i, j);
                i++;
                j--;
            }
        }
        swap(list, start, j);
        return j;
    }

    public static void swap(int[] list, int i, int j) {
        int temp = list[i];
        list[i] = list[j];
        list[j] = temp;
    }

    @Test
    public void validate() {
        int[] list = {20,35,-15,7, 55,1,-22};
        int[] list2 = {1,10, -3, 0, 45, 13, 4};
        QuickSort.quickSort(list);
        QuickSort.quickSort(list2);

        Assert.assertArrayEquals(new int[]{-22,-15,1,7,20,35,55}, list);
        Assert.assertArrayEquals(new int[]{-3,0,1,4,10,13,45}, list2);
    }


}