package quicksort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static util.SortingUtil.exchange;

public class QuickSort {
    public static void main(String[] args) {
        Integer[] integers = new Integer[]{2, 10, 8, 15, 11, 19, 13, 17, 7, 18};
        System.out.println(new ArrayList<>(Arrays.asList(sort(integers))));
    }

    public static final Integer[] sort(Integer[] integers) {
        List<Integer> list = Arrays.asList(integers);
        Collections.shuffle(list);

        Integer[] a = new Integer[list.size()];
        list.toArray(a);

        int lo = 0;
        int hi = a.length - 1;

        sort(a, lo, hi);
        return a;
    }

    public static final void sort(Integer[] a, int lo, int hi) {
        if (lo >= hi) {
            return;
        }
        int j = partition(a, lo, hi);
        sort(a, lo, j - 1);
        sort(a, lo + 1, hi);
    }

    public static final int partition(Integer[] a, int lo, int hi) {
        int i = lo;
        int j = hi + 1;
        Integer v = a[lo];

        while (true) {
            while (v > a[++i]) {
                if (i == hi) {
                    break;
                }
            }
            while (v < a[--j]) {
                if (j == lo) {
                    break;
                }
            }

            if (i >= j) {
                break;
            }
            exchange(a, i, j);
        }
        exchange(a, lo, j);
        return j;
    }
}