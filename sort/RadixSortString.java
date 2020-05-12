
public class RadixSortString {

    public static void radixSortString(String[] input, int radix, int width) {
        for(int i = width-1; i >= 0; i--) {
            radixSortStringSingle(input,i,radix);
        }
    }

    //radix = 23 caracteres
	private static void radixSortStringSingle(String[] input, int position, int radix) {

        int[] countArray = new int[radix]; 
        for (String word : input) {
            int index = getIndex(word, position);
            countArray[index] += 1;
        }

        for(int i = 1; i < countArray.length;i++) {
            countArray[i] = countArray[i] + countArray[i-1];
        }

        String[] tempArray = new String[input.length];
        for(int j = input.length -1; j >= 0; j--) {
            int index = getIndex(input[j], position);
            tempArray[--countArray[index]] = input[j];
        }

        System.arraycopy(tempArray, 0, input, 0, input.length);
	}

    public static int getIndex(String value, int position) {
        //translating to a numeric value to countArray
        return value.charAt(position) - 'a';
    }

    public static void main(String[] args) {
        String[] stringsArray = { "bcdef", "dbaqc", "abcde", "omadd", "bbbbb"};

        // do radix sort
        radixSortString(stringsArray, 26, 5);

        for (String string : stringsArray) {
            System.out.println(string);
        }
    }
}