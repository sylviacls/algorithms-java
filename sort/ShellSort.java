import org.junit.*;

/**
 * "Similar" to InsertionSort but use a larger gap value (insertion use gap of 1)
 *  to reduce the amount of shiffting
 * It makes a pre-ordering before performe a pure Insertion
 * It compares the elements that are in a distance apart rather than adjacent
 * 
 * We calculte the "gap" for each pass (kenuth sequence (3^k - 1/2) or floor (n/2)) until is 1
 * When gap is 1 it will be performance the inserion sort but with list partially ordered
 * 
 * Time complexity: Worst case O(n²), but it can perform much better than that
 * It's an unstable algorith (InserionSort is stable)
 */


public class ShellSort {

    public static void shellSort(int[] list) {

        for(int gap = list.length/2; gap > 0; gap = gap/2) {          
            // it will be used to go right-hand the gap
            for (int i = gap; i < list.length; i++) {
                int newElement = list[i];
                int j = i; // we have to keep it separated cause we dont wanna change "i" while transversing

                while (j >= gap &&  newElement < list[j-gap]) {
                  list[j] = list[j-gap];
                  j = j - gap;
                }
                list[j] = newElement;
            } 
        }

    }

    @Test
    public void validate() {
      int[] list1 = {20,35,-15,7, 55,1,-22};
      int[] expected1 = new int[] {-22, -15, 1, 7, 20, 35, 55};

      int[] list2 = {0,10,-15,4, 30, 1,-2};
      int[] expected2 = new int[] {-15, -2, 0, 1, 4, 10, 30};

      ShellSort.shellSort(list1);
      ShellSort.shellSort(list2);

      Assert.assertArrayEquals(expected1, list1);
      Assert.assertArrayEquals(expected2, list2);
  }


}

