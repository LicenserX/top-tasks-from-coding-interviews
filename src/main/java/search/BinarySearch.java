package search;

import java.util.Arrays;

public class BinarySearch {
    public static void main(String[] args) {
        System.out.println(binarySearch(new int[]{1, 2, 3, 4, 6, 7}, 5));
    }

    public static int binarySearch(int[] sortedArray, int find) {
        int lo = 0;
        int hi = sortedArray.length - 1;
        return _binarySearch(lo, hi, sortedArray, find);
    }

    public static int _binarySearch(int lo, int hi, int[] sortedArray, int find) {
        System.out.println(lo + " " + hi);
        if (lo > hi) {
            return -1;
        }
        int mid = (hi + lo) / 2;
        if (sortedArray[mid] == find) {
            return mid;
        } else if (sortedArray[mid] > find) {
            return _binarySearch(lo, mid - 1, sortedArray, find);
        } else {
            return _binarySearch(mid + 1, hi, sortedArray, find);
        }
    }
}

//0 1 2 3 4 5
//1 2 3 4 5 6
//
//0 5