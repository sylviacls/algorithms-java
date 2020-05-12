/**
 * Data must be sorted.
 * Chooses the element from the middle and compares it against the search value
 * - if element is equal to the value, it's done
 * - if element is > the value, search the left half
 * - if element is < the value, serach the right left
 * Can be implemented recursively
 * O(n logn) - keeps dividing the array in half
 */
public class BinarySearch {

    public static int binarySearch(int[] input, int target, int start, int end) {
    
        if(start > end)  {
            return -1;
        }

        int midPoint = (start + end)/2;

        if(target == input[midPoint]) {
            return midPoint;

        } else if(input[midPoint] > target) { //search in the left half
            return binarySearch(input, target, start, midPoint-1);
 
        } else { ////search in the right left
            return binarySearch(input, target, midPoint+1, end);
        }  

    }
    
    public static int iterativeBinarySearch(int[] input,int target) {
        int start = 0;
        int end = input.length-1;

        while (start <= end) {
            int midPoint = (start + end)/2;
            if(input[midPoint] == target) {
                return midPoint;
            } else if (input[midPoint] > target) {
                end = midPoint-1;
            } else {
                start = midPoint+1;
            }
        }
        return -1;
    }


    public static void main(String[] args) {
        int[] list = {-22,-15,1,7,20,35,55};
        System.out.println(iterativeBinarySearch(list, 7));
        System.out.println(binarySearch(list,55, 0, list.length-1));
    }
}