package array;

import java.util.Arrays;

public class ArrayReverse {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(reverse(new int[]{1, 2, 3, 4, 5, 6, 7})));
    }

    public static int[] reverse(int[] array) {
        int buffer;
        int half = array.length / 2;
        for (int i = 0; i < half; i++) {
            buffer = array[i];
            array[i] = array[array.length - 1 - i];
            array[array.length - 1 - i] = buffer;
        }
        return array;
    }
}
