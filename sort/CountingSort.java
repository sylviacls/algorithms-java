import org.junit.Assert;
import org.junit.Test;

/**
 *  !! See the implementation with liked list for the stable option !!
 * 
 * Restricted inputs: Counting sort only works when the range of potential items in the input is 
 *                    known ahead of time.
 * It doesn't use comparisons
 * It counts the number of occurrences of each value
 * Two phases:
 * 1 - Transverse the input array and fill the count array with the occurrences of each value
 * 2 - Transverse the count array and write the values back in the input array
 * Not in-place! we have to creat a count array
 * 
 * Time Complexity: O(N) just because we're making assumptions about the input. 
 *                  The range of values should not be large.
 * Space Complexity: O(>N), extra space for the counting array. If the range of potential values is big, 
 *                   then counting sort requires a lot of space (perhaps more than O(n)).
 */
public class CountingSort {
   
       
    //Unstable CountingSort
    public static void countingSort(int[] input, int min, int max) {
    // {1,4,9,12,5,3,1,8,10};
        int[] countArray = new int[(max-min)+1];

        // place the count in its relative position
        for(int i = 0; i < input.length; i++) {
            int relativePosition = input[i]-min;
            countArray[relativePosition] += 1;
        }

        int indexInput = 0;
        //Transverse the count array and write the values back in the input array
        for (int i = 0; i< countArray.length; i++){
            if(countArray[i]>0) {
                for (int j = 1; j <= countArray[i]; j++ ) {
                    input[indexInput] = i+min;
                    indexInput++;
                }
            }
        }
    }

    @Test
    public void validate() {
        int[] list1 = {2,1,7,2,4,9,12,5,3,2,1,7,8,23,10};
        int[] list2 = {10,13,14,18,19,12,11,20,18};
        CountingSort.countingSort(list1, 1,23);
        CountingSort.countingSort(list2, 10,20);
        Assert.assertArrayEquals(new int[]{1,1,2,2,2,3,4,5,7,7,8,9,10,12,23}, list1);
        Assert.assertArrayEquals(new int[]{10,11,12,13,14,18,18,19,20}, list2);
    }
}