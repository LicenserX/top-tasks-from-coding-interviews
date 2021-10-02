package lruchache;


import java.util.LinkedHashMap;
import java.util.Map;

public final class LruCache<K, V> extends LinkedHashMap<K, V> {

    private int maxCacheSize;

    public LruCache(int cacheSize) {
        maxCacheSize = cacheSize;
    }

    @Override
    protected boolean removeEldestEntry(Map.Entry<K, V> eldest) {
        return size() > maxCacheSize;
    }

    public V getValue(K key) {

        if (super.get(key) == null) {
            return null;
        }

        V value = super.remove(key);
        put(key, value);

        return value;
    }

    public V putValue(K key, V value) {

        if (super.get(key) == null) {
            put(key, value);
        }

        super.remove(key);
        put(key, value);

        return value;
    }
}




