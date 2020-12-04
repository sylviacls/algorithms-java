import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

/**
 * In the Bucket Sorting technique, the data items are distributed in a set of buckets.
 * Each bucket can hold a similar type of data. After distributing, each bucket is sorted using 
 * another sorting algorithm. After that, all elements are gathered on the main list to get the 
 * sorted form.
 * 
 * It uses Hashing
 * It Makes assumptions about the data (length/digi), so it can perform O(n)
 * It performs best when there aren't many collistions
 * Not in-place
 * Phases:
 *    - Scattering: distributes the items into buckets according on their hashed values
 *    - Sort the item in each bucket
 *    - Gathering: merge the buckets, concatenating them
 *  Works as a generalization of counting sort
 *  Requeriment: Values in Bucket X -1 < Values in Bucket X  <Values in Bucket X + 1
 * The hash function must meet this requirement in order of mantening the soring
 * The stability depends on sort algorithm used (insertion sort is normally used)
 * 
 * Time Complexity: O(N), average-case: it occurs when the elements are distributed randomly in the array
 *                  O(N^2) worst-case: When there are elements of close range in the array, they are 
 *                  likely to be placed in the same bucket. This may result in some buckets having more
 *                  number of elements than others. It makes the complexity depend on the sorting algorithm used 
 *                  to sort the elements of the bucket
 * Space Complexity: O(N+K)
 */

public class BucketSort {
    
    public static void bucketSort(int[] input) {
        @SuppressWarnings("unchecked")
        List<Integer>[] buckets = new List[10];

        //initialize the buckets with empties ArrayList
        for (int i = 0; i < buckets.length; i++) {
            buckets[i] = new ArrayList<Integer>();
        }
        //Scattering phase: 
        //Put the elements from the input into the buckets using the hash function
        for (int i = 0; i < input.length; i++) {
            int hashedValue = hash(input[i]);
            buckets[hashedValue].add(input[i]);
        }   
        //Sort each bucket
        //We can use comparator or Collection.sort
        Comparator<Integer> comparator = Comparator.naturalOrder();
        for (List<Integer> bucket : buckets) {
            // Collections.sort(bucket);
            bucket.sort(comparator);
        }
        //Gathering phase
        int indexInput = 0;
        for (int i = 0; i < buckets.length; i++) {
            for (int value: buckets[i]) {
                input[indexInput] = value;
                indexInput++;
            }
        }
    }

    private static int hash(int i) {
        return firstDigit(i);
    }
    
    /**
     * Remove last digit from number till only one digit is left
     * @param n the number
     * @return its first digit
     */
    public static int firstDigit(int n) { 
        while (n >= 10)  {
            n = n/ 10; 
        }
        return n; 
    }

    /**
     * Find last digit from number 
     * @param n the number
     * @return its last digit
     */
    public static int lastDigit(int n) { 
        return n%10; 
    }

    @Test
    public void validate() {
	    int[] list1 = { 54, 46, 83, 66, 95, 92, 43 };
        int[] list2 = {457,980,300,110,287,800};
        int[] list3 = {10,13,14,18,19,12,11,20,18};

        bucketSort(list1);
        bucketSort(list2);
        bucketSort(list3);

        Assert.assertArrayEquals(new int[]{43,46,54,66,83,92,95}, list1);
        Assert.assertArrayEquals(new int[]{110,287,300,457,800,980}, list2);
        Assert.assertArrayEquals(new int[]{10,11,12,13,14,18,18,19,20}, list3);
    }
}