import org.junit.*;

/**
 * Its a divide and conquer algorithm that uses recursion 
 * Not in-place: uses emporary array 
 * 
 * Stable algorithm 
 * Time complexity: O(N logN) worst-case
 * Space complexity: O(n) - its proporcional to the number of the elements 
 * 
 * Phases: splitting (logical, to faster sorting during merging) and merging
 * 
 * Spliting: slipt the array in 2 parts unsorted (left and right) keep splitting
 * until the arrays have one element each (they are sorted) 
 * 
 * Merging: merge every left/right pair of siblings arrays into a sorted array 
 * keep returning and merging all the arrays back until you have one sorted array
 */
 
public class MergeSort {

    public static void mergeSort(int[] array) {

        int length = array.length;
        if(length < 2) {
            return;
        }

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
        /*
         while (i < arr1.length && j < arr2.length) {
            merged[tempIndex++] = arr1[i] <= arr2[j] ? arr1[i++] : arr2[j++];
        }
        */     
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