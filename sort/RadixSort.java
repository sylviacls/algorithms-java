import java.util.Arrays;

import org.junit.Assert;
import org.junit.Test;

/**
 * Makes assumptions about the data: Data must have same Radix and Width Data
 * must be integers and strings
 * 
 * Sorting is based on each individual digit/letter position Start at the
 * righmost position (least significant digit to the most)
 * 
 * It must use a stable sort algorithm at each stage Counting sort is often used
 * as the sort algorith for Radix Sort (must be a stable counting sort)
 * 
 * Time complexity: O(n) can be achieved, because we're making assumptions But,
 * if oftens runs slow than O(n logn) because of the overhead involved
 * (isolating each individual digit)
 *
 * In-place depends on wich sorting algorithm we're gonna use Stable algorithm
 * (it must be! otherwise it won't work properly)
 * 
 * Counting Sort x Radix Sort Counting Sort is quite efficient when the length
 * of the array is not much smaller than the maximum value in the array whereas
 * Radix Sort allows for larger values in the array.
 */
public class RadixSort {

    public static void radixSort(int[] input, int radix) {
        int maxNumber = getMax(input);
        int numberOfDigits = calculateNumberOfDigitsIn(maxNumber);
        //perform the radixSort for each digit
        int placeValue = 1;
        for(int i = 1; i <= numberOfDigits; i++) {
            radixSingleSort(input,placeValue,radix);
            placeValue *= 10;
        }
    }

    private static void radixSingleSort(int[] input, int placeValue, int radix) {
        int[] countArray = new int[radix];

        for(int i = 0; i< input.length; i++) {
            int digit = (input[i]/placeValue) % radix;
            countArray[digit] += 1;
        }
        //make a adjustment in countArray. we wanna store how many values have a specifig digit or less
        //this is necessary for the next step, where we will use this adjusted count to write out
        //the values in correct order and preserve the relative position of values that have
        //duplicate values at some position
        for (int j = 1; j < radix; j++) { // starts at 1 to prevent arrayindexoutofbounds
            countArray[j] += countArray[j-1];
        }

        int[] sortedValues = new int[input.length];
        //we tranverse from right to left because this is going to make us write the rightmost
        //value before the leftmost value to ensure estability
        /**
         * 4725, 4586, 2225, 1330, 8792, 1594, 5729 
         * 0 1 2 3 4 5 6 7 8 9 (index)
         * 1 0 1 0 1 2 1 0 0 1 count array
         * 1 1 2 2 3 5 6 6 6 7 adjusted array
         */
        for(int i = input.length - 1; i >= 0; i--) {
            int digit = (input[i]/placeValue) % radix;
            //we have to decrement countArray[digit] fist cause we have to place it in a 0-based index
            // So, if we have count 2 for some digit, it means we have 2 numbers, and their position
            //should be for example, 0 and 1 index.
            sortedValues[countArray[digit]-1] = input[i];
            countArray[digit]--;
        }
        System.arraycopy(sortedValues, 0, input, 0, input.length);
    }

    /**
     * A utility function to get maximum value in arr[] 
     * @param arr
     * @return the max number of a given array
     */
    private static int getMax(int[] input) { 
          return Arrays.stream(input).max().getAsInt(); 
    } 

    /**
     * A utility function to calculte the number of digits of a given number
     * @param maxNumber
     * @return number of digits of a given number
     */
    private static int calculateNumberOfDigitsIn(int number) {
        int numDigits = 0;
        while(number > 0) {
            number /= 10;
            numDigits++;
        }
        return numDigits;
    }


    @Test
    public void validate() {
       int[] list = {4725, 4586, 2225, 1330, 8792, 1594, 5729};
       RadixSort.radixSort(list, 10);
       int[] numbersSorted = new int[]{1330,1594,2225, 4586,4725,5729,8792};
       Assert.assertArrayEquals(numbersSorted, list);

       int[] list2 = {387, 468, 134, 123, 68, 221, 769, 37, 7};
       RadixSort.radixSort(list2,10);
       int[] numbersSorted2 = {7, 37, 68, 123, 134, 221, 387, 468, 769};
       Assert.assertArrayEquals(numbersSorted2, list2); 
    }
}