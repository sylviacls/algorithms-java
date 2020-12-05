import org.junit.*;

/**
 * The algorithm can be described as the following 2 step process: 
 *    Divide: In this step, we divide the input array into 2 halves, the pivot being the midpoint
 *        of the array. This step is carried out recursively for all the half arrays until there are no
 *        more half arrays to divide.
 *   Conquer: In this step, we sort and merge the divided arrays from bottom to top and get the sorted
 *        array.
 * 
 * Not in-place: uses emporary array 
 * Stable algorithm 
 * 
 * Time complexity: O(N logN) worst-case, the recursion tree will have logN level, in each level we will
 *                  perform N operations.
 * Space complexity: O(n) - its proporcional to the number of the elements 
 * 
 * Merge sort is more efficient and works faster than quick sort in case of larger array size or datasets.
 * Quick sort is more efficient and works faster than merge sort in case of smaller array size or datasets.
 */
 
public class MergeSort {

    public static void mergeSort(int[] array) {

        int length = array.length;
        if(length < 2) {
            return;
        }

        // Spliting: slipt the array in 2 parts unsorted (left and right) keep splitting
        // until the arrays have one element each (they are sorted) 
        // O (log N) : whenever we divide a number into half in every step, it can be represented 
        //using a logarithmic function, which is log n and the number of steps can be represented 
        //by log n + 1(at most)
        int mid = length/2;
        int[] left = new int[mid];
        int[] right = new int[length-mid];

        for (int i = 0; i < left.length; i++) {
            left[i] =  array[i];
        }

        for (int j = 0; j < right.length; j++) {
            right[j] = array[mid+j];
        }

        mergeSort(left);
        mergeSort(right);

        // Merging: merge every left/right pair of siblings arrays into a sorted array 
        // keep returning and merging all the arrays back until you have one sorted array
        // O(N) to merge the subarrays, made by dividing the original array of n elements, 
        //a running time of O(n) will be required.
        merge(array, left, right);

    }

    public static void merge(int[] array, int[] left, int[]right) {
        int mergedIndex = 0; 
        int i = 0;
        int j = 0;

        while (i < left.length && j < right.length) {
            if(left[i] <= right[j]) { //preserving the relative ordering
                array[mergedIndex] = left[i];
                i++;
            } else {
                array[mergedIndex] = right[j];
                j++;
            }
            mergedIndex++;
        }

        //Handling the left-overs
        while (i < left.length) {
            array[mergedIndex] = left[i];
            i++;
            mergedIndex++;
        }
        while (j < right.length) {
            array[mergedIndex] = right[j];
            j++;
            mergedIndex++;
        }
    }

    @Test
    public void positiveTest() {
        int[] actual = { 5, 1, 6, 2, 3, 4 };
        int[] expected = { 1, 2, 3, 4, 5, 6 };
        MergeSort.mergeSort(actual);
        Assert.assertArrayEquals(expected, actual);

        int[] actual2 =  {20,35,-15,7, 55,1,-22};
        int[] expected2 = {-22,-15,1,7,20,35,55};
        MergeSort.mergeSort(actual2);
        Assert.assertArrayEquals(expected2, actual2);
    }

}