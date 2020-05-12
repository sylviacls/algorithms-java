import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Uses Hashing
 * Makes assumptions about the data, so can perform O(n)
 * Performs best when there aren't many collistions
 * Not in-place
 * Phases:
 *    - Scattering: distributes the items into buckets according on their hashed values
 *    - Sort the item in each bucket
 *    - Gathering: merge the buckets, concatenating them
 *  Works as a generalization of counting sort
 *  Requeriment: Values in Bucket X -1 < Values in Bucket X  <Values in Bucket X + 1
 * The hash function must meet this requirement in order of mantening the soring
 * The stability depends on sort algorithm used (insertion sort is normally used)
 * O(n) only when the buckets have only one time
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
          //Collections.sort(bucket);
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


    public static void main(String[] args) {
	    int[] intArray = { 54, 46, 83, 66, 95, 92, 43 };
        bucketSort(intArray);

        for (int i = 0; i < intArray.length; i++) {
            System.out.println(intArray[i]);
        }
    }
}