        
// [0, 7, 9, 2, 15, 12]
public class SelectionSort {

    public static int[] selectionSort(int[] list) {

        for(int lastUnsortedIndex = list.length-1; lastUnsortedIndex > 0; lastUnsortedIndex--) {
            int largestIndex = 0;
            for (int i = 1; i <= lastUnsortedIndex; i++ ) {
                if(list[i]> list[largestIndex]) {
                    largestIndex = i;
                 }
            }
            
           swap(list, largestIndex, lastUnsortedIndex);    
        }


        return list;
    }

    public static void swap(int[] list, int largestIndex, int lastUnsortedIndex) {

        int temp = list[lastUnsortedIndex];
        list[lastUnsortedIndex]= list[largestIndex];
        list[largestIndex] = temp;

    }

    
    //looking for the smallest
    // [20,35,-15,7, 55,1,-22] 
    public static void selectionSort2(int[] list) {
        for (int i = 0; i < list.length; i++) {
          int indexSmallest = i;
          for (int j = i+1; j < list.length; j++){
            if(list[j] < list[indexSmallest]) {
              indexSmallest = j;
            }
          }
          if(list[indexSmallest] != list[i]) {
            int temp = list[i];
            list[i] = list[indexSmallest];
            list[indexSmallest] = temp;
  
          }
        }
      }

    public static void main(String[] args) {

        int[] list = {20, 35, -15, 7, 55, 1, -22};
        list = SelectionSort.selectionSort(list);

        for (int i : list) {
            System.out.println(i);
        }

    }


}