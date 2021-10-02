package util;

public final class SortingUtil {
    private SortingUtil() {
    }

    public static final void exchange(Object[] a, int i, int j) {
        Object iValue = a[i];
        a[i] = a[j];
        a[j] = iValue;
    }
}
