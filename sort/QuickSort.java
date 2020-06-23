import org.junit.Assert;
import org.junit.Test;

/**
 * O(n logn) - average case (better than merge sort) - it depends on pivot selection
 * O(n²) - worst case
 * In-place, unstable
 * Most libraries implement the quicksort for their Sortings methods
 * We choose the "pivot" and re-arrange the list (Logical Partition)
 *  logically partitions the array in two halves.
 *  elements lessers tha pivot to its left, and greater to its right
 * So, when the partition is finished, the pivot will be at its right position
 * And then the process is repetead for the left and right array
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