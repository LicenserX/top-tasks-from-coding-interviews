package util;

public final class SortingUtil {
    private SortingUtil() {
    }

    public static final void exchange(Integer[] a, int i, int j) {
        Integer iValue = a[i];
        a[i] = a[j];
        a[j] = iValue;
    }
}
