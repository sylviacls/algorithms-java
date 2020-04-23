/*
 - "Similar" to InsertionSort but use a larger gap value (insertion use gap of 1) 
    to reduce the amount of shiffting
 - It makes a pre-ordering before performe a pure Insertion
 - Compare elements that are in a distance apart rather than adjacent
 - We calculte the "gap" for each pass (kenuth sequence (3^k - 1/2) or floor (n/2)) until is 1
 - When gap is 1 it will be performance the inserion sort but with list partially ordered

 - Worst case O(n²), but it can perform much better than that
- It's an unstable algorith (InserionSort is stable)
*/

public class ShellSort {

    public static void shellSort(int[] list) {

        for(int gap = list.length/2; gap > 0; gap = gap/2) {
            
            // i will be used to go right-hand the gap
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

      public static void main(String[] args) {

        int[] list = {20,35,-15,7, 55,1,-22};
        shellSort(list);
        for (int i : list) {
          System.out.println(i);
        }


      }

}

