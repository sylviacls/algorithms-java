/**
 * Makes assumptions about the data
 * Data must have same Radix and Width
 * Data must be integers and strings
 * Sort based on each individual digit/letter position
 * Start at the righmost position (least significant digit to the most)
 * Must use a stable sort algorithm at each stage
 * Counting sort is often used as the sort algorith for Radix Sort (must be a stable counting sort)
 * O(n) can be achieved, because we're making assumptions
 * But, if oftens runs slow than O(n logn) because of the overhead involved (isolating each individual digit)
 * In-place depends on wich sorting algorithm we're gonna use
 * Stable algorithm (it must be! otherwise it won't work properly)
 */
public class RadixSort {

    //{ 4725, 4586, 1330, 8792, 1594, 5729 };
    public static void radixSort(int[] input, int radix, int width) {
        //perform the radixSort for each digit
        for(int i = 0; i < width; i++) {
            radixSingleSort(input,i,radix);
        }
    }

    //Perform a stable counting sort
    private static void radixSingleSort(int[] input, int position, int radix) {
    //{ 4725, 4586, 1330, 8792, 1594, 5729 };
        int[] countArray = new int[radix];

        for(int i = 0; i< input.length; i++) {
            int digit = getDigit(input[i], position, radix);
            countArray[digit] += 1;
        }
        //make a adjustment in countArray
        for (int j = 1; j < radix; j++) { // starts at 1 to prevent arrayindexoutofbounds
            countArray[j] += countArray[j-1];
        }

        int[] tempArray = new int[input.length];
        for(int i = input.length - 1; i >= 0; i--) {
            int digit = getDigit(input[i], position, radix);
            //we have to decrement countArray[digit] fist cause we have to place it in a 0-based index
            // So, if we have count 2 for some digit, it means we have 2 numbers, and their position
            //should be for example, 0 and 1 index.
            tempArray[--countArray[digit]] = input[i];

        }

        System.arraycopy(tempArray, 0, input, 0, input.length);

    }

    private static int getDigit(int value, int position, int radix) {
        int digit = ( value /(int)Math.pow(radix, position) )% radix;
        return digit;
    }

    public static void main(String[] args) {
       // System.out.println(getDigit(4725,1,10));
       int[] list = {4725, 4586, 1330, 8792, 1594, 5729};
       RadixSort.radixSort(list, 10, 4);
       for (int i : list) {
           System.out.println(i);
       }
    }
}