/**
 *  !! See the implementation with liked list for the stable  option !!
 * 
 * Makes assumptions about the data. only works with non-negative discrete values.
 * Values must be within a specific range.
 * Doesn't use comparisons
 * Counts the number of occurrences of each value
 * Two phases:
 * 1 - Transverse the input array and fill the count array with the occurrences of each value
 * 2 - Transverse the count array and write the values back in the input array
 * Not in-place! we have to creat a count array
 * O(n) just because we're making assumptions about the input. The range of values should not be larges
 */
public class CountingSort {
   
       
    //Unstable CountingSort
    public static void countingSortU(int[] input, int min, int max) {
    // {1,4,9,12,5,3,1,8,10};
        int[] countArray = new int[(max-min)+1];

        // place the count in its relative position
        for(int i = 0; i < input.length; i++) {
            int relativePosition = input[i]-min;
            countArray[relativePosition] += 1;
        }

        int indexInput = 0;
        for (int i = 0; i< countArray.length; i++){
            if(countArray[i]>0) {
                for (int j = 1; j <= countArray[i]; j++ ) {
                    input[indexInput] = i+min;
                    indexInput++;
                }
            }
        }

    }

    /**
     * Stable counting sort
     *  We use a temp array to store the right position of the duplicate elements
     * It works cause we transverse the inpout from right to left and we write the duplicate values
     * into the temp array from right to left
     * It makes an adjustment in the count array
     */
    public static void countingSortS(int[] input, int min, int max)   {

    }
    public static void main(String[] args) {
      //  int[] list1 = {2,1,7,2,4,9,12,5,3,2,1,7,8,23,10};
        int[] list2 = {10,13,14,18,19,12,11,20,18};
        CountingSort.countingSortU(list2, 10,20);
        for (int i : list2) {
         System.out.println(i);
        }
    }

}