package lruchache;

public class Main {
    public static void main(String[] args) {
        LruCache<Integer, Integer> lruCache = new LruCache<>(4);
        lruCache.putValue(1, 1);
        lruCache.putValue(2, 1);
        lruCache.putValue(3, 1);
        lruCache.putValue(1, 2);
        lruCache.putValue(4, 1);

        lruCache.getValue(2);

        lruCache.putValue(5, 1);
        lruCache.putValue(6, 1);
        lruCache.putValue(7, 1);


        System.out.println(lruCache.getValue(1));
        System.out.println(lruCache.getValue(2));
        System.out.println(lruCache.getValue(3));
    }
}
