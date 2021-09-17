package duplicates;


import java.util.Arrays;

public class Duplicates {
    public static void main(String[] args) {
        Integer[] integers = {1, 1, 1, 2, 3, 1, 2, 5};
        removeDuplicates(integers);
        System.out.println(Arrays.toString(integers));
    }

    public static void removeDuplicates(Integer[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            if (array[i] == null){
                continue;
            }
            for (int j = i + 1; j < array.length; j++) {
                if (array[i].equals(array[j])) {
                    array[j] = null;
                }
            }
        }
    }
}

