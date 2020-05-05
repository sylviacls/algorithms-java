/* - Divide and conquer algorithm that uses recursion
* -  Not in-place: uses temporary array O(n) space complecity - its proporcional to the number of the elements
* - Stable algorithm 
* - O(nlogn) worst-case
* - Phases: splitting (logical to faster sorting during merging) and merging
* -  Spliting: slipt the array in 2 parts unsorted (left and right)
*              keep splitting until the arrays have one element each (they are sorted)
* - Merging: merge every left/right pair of siblings arrays into a sorted array
            keep returning and merging all the arrays back until you have one sorted array 
*/

public class MergeSort {

    public static int[] mergeSort(int[] array) {

        int length = array.length;
        if(length == 1) {
            return array;
        }

        int[] left = new int[length/2];
        for (int i = 0; i < left.length; i++) {
            left[i] =  array[i];
        }

        int[] right = new int[(length - (length/2))];
        for (int j = 0; j < right.length; j++) {
            right[j] = array[(length/2)+j];
        }

        left = mergeSort(left);
        right = mergeSort(right);

        return merge(left, right);

    }

    public static int[] merge(int[] arr1, int[]arr2) {
        int[] merged = new int[arr1.length + arr2.length];
        int mergedIndex = 0;
       
        int i = 0;
        int j = 0;

        while (i < arr1.length && j < arr2.length) {
            if(arr1[i] <= arr2[j]) { //preserving the relative ordering
                merged[mergedIndex] = arr1[i];
                i++;
            } else {
                merged[mergedIndex] = arr2[j];
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
        while (i < arr1.length) {
            merged[mergedIndex] = arr1[i];
            i++;
            mergedIndex++;
        }
        while (j < arr2.length) {
            merged[mergedIndex] = arr2[j];
            j++;
            mergedIndex++;
        }
        return merged;
    }

      // { 20, 35, -15, 7, 55, 1, -22 }
    /*  public static void mergeSort2(int[] input, int start, int end) {

        if (end - start < 2) {
            return;
        }

        int mid = (start + end) / 2;
        mergeSort2(input, start, mid);
        mergeSort2(input, mid, end);
        merge2(input, start, mid, end);
    }
    // { 20, 35, -15, 7, 55, 1, -22 }
    public static void merge2(int[] input, int start, int mid, int end) {

        if (input[mid - 1] <= input[mid]) {
            return;
        }

        int i = start;
        int j = mid;
        int tempIndex = 0;

        int[] temp = new int[end - start];
        while (i < mid && j < end) {
            temp[tempIndex++] = input[i] <= input[j] ? input[i++] : input[j++];
        }

        System.arraycopy(input, i, input, start + tempIndex, mid - i);
        System.arraycopy(temp, 0, input, start, tempIndex);


    } */

    public static void main(String[] args) {

     //   int[] array = {2,6,9,1,0,8,5};
        int[] list = {20,35,-15,7, 55,1,-22};

        list = MergeSort.mergeSort(list);

        for (int i : list) {
            System.out.println(i);
        }

    }

}