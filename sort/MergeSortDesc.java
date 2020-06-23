
public class MergeSortDesc {

    public static int[] mergeSortDesc(int[] array) {

        int length = array.length;
        if(length == 1) {
            return array;
        }

        int[] left = new int[length/2];
        for (int i = 0; i < left.length; i++) {
            left[i] =  array[i];
        }

        int[] right = new int[(length - (length/2))];
        for (int j = 0; j < right.length; j++) {
            right[j] = array[(length/2)+j];
        }

        left = mergeSortDesc(left);
        right = mergeSortDesc(right);

        return merge(left, right);

    }

    public static int[] merge(int[] arr1, int[]arr2) {
        int[] merged = new int[arr1.length + arr2.length];
        int mergedIndex = 0;
       
        int i = 0;
        int j = 0;

        while (i < arr1.length && j < arr2.length) {
            if(arr1[i] >= arr2[j]) {
                merged[mergedIndex] = arr1[i];
                i++;
            } else {
                merged[mergedIndex] = arr2[j];
                j++;
            }
            mergedIndex++;
        }
        /*
         while (i < arr1.length && j < arr2.length) {
            merged[tempIndex++] = arr1[i] <= arr2[j] ? arr1[i++] : arr2[j++];
        }
        */
        
        //Handling the left-overs
        while (i < arr1.length) {
            merged[mergedIndex] = arr1[i];
            i++;
            mergedIndex++;
        }
        while (j < arr2.length) {
            merged[mergedIndex] = arr2[j];
            j++;
            mergedIndex++;
        }
        return merged;
    }


    public static void main(String[] args) {

     //   int[] array = {2,6,9,1,0,8,5};
        int[] list = {20,35,-15,7, 55,1,-22};

        list = MergeSortDesc.mergeSortDesc(list);

        for (int i : list) {
            System.out.println(i);
        }

    }

}