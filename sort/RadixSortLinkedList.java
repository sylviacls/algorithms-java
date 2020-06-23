import java.util.Arrays;
import java.util.LinkedList;

import org.junit.Assert;
import org.junit.Test;

public class RadixSortLinkedList {

    private LinkedList<Integer>[] buckets;

    @SuppressWarnings("unchecked")
    public RadixSortLinkedList() {
        buckets = new LinkedList[10];
        for (int i = 0; i < 10; i++) {
            buckets[i] = new LinkedList<Integer>();
        }
    }


    public void radixSort(int[] input, int radix) {
        int maxNumber = getMax(input);
        int numberOfDigits = calculateNumberOfDigitsIn(maxNumber);
        //perform the radixSort for each digit
        int placeValue = 1;
        for(int i = 1; i <= numberOfDigits; i++) {
            radixSingleSort(input,placeValue,radix);
            placeValue *= 10;
        }
    }

    private void radixSingleSort(int[] input, int placeValue, int radix) {
        // Add values to buckets according to n-th digit
        for (int i : input) {
            int digit = (i/placeValue) % radix;
            buckets[digit].add(i);
        }
        // Collect elements of the buckets and put them back into the array
        int inputSorted = 0;
        for (int i = 0; i < buckets.length; i++) {
            while(!buckets[i].isEmpty()) {
                input[inputSorted] = buckets[i].removeFirst();
                inputSorted++;
            }
        }
    }

    /**
     * A utility function to get maximum value in arr[]
     * 
     * @param arr
     * @return the max number of a given array
     */
    private int getMax(int[] input) { 
        return Arrays.stream(input).max().getAsInt(); 
  } 

  /**
   * A utility function to calculte the number of digits of a given number
   * @param maxNumber
   * @return number of digits of a given number
   */
  private int calculateNumberOfDigitsIn(int number) {
      int numDigits = 0;
      while(number > 0) {
          number /= 10;
          numDigits++;
      }
      return numDigits;
  }

  private void clearBuckets() {
      for (LinkedList<Integer> linkedList : buckets) {
          linkedList.clear();
      }
  }

  @Test
  public void validate() {

     RadixSortLinkedList radixSort = new RadixSortLinkedList();

     int[] list = {4725, 4586, 2225, 1330, 8792, 1594, 5729};
     int[] numbersSorted = new int[]{1330,1594,2225, 4586,4725,5729,8792};
     radixSort.radixSort(list, 10);
     Assert.assertArrayEquals(numbersSorted, list);

     radixSort.clearBuckets();

     int[] list2 = {387, 468, 134, 123, 68, 221, 769, 37, 7};
     int[] numbersSorted2 = {7, 37, 68, 123, 134, 221, 387, 468, 769};
     RadixSort.radixSort(list2,10);
     Assert.assertArrayEquals(numbersSorted2, list2);  
  }
}
    