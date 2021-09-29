package insertionsort;

import java.util.ArrayList;
import java.util.Arrays;

import static util.SortingUtil.exchange;

public class InsertionSort {
    public static void main(String[] args) {
        Integer[] integers = new Integer[]{2, 10, 8, 15, 11, 19, 13, 17, 7, 18};
        sort(integers);

        System.out.println(new ArrayList<>(Arrays.asList(integers)));
    }

    public static final void sort(Integer[] a) {
        int N = a.length;

        for (int i = 1; i < N; i++) {
            for (int j = i; j > 0 && a[j - 1] > a[j]; j--) {
                exchange(a, j - 1, j);
            }
        }
    }
}
