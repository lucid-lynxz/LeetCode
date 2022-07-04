import java.util.LinkedHashMap;

/**
 * 146. LRU 缓存
 * https://leetcode.cn/problems/lru-cache/
 */
public class LRUCache {

    private final LinkedHashMap<Integer, Integer> cache;
    private final int capacity;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        cache = new LinkedHashMap<>(capacity, 0.75f, true);
    }

    public int get(int key) {
        return cache.getOrDefault(key, -1);
    }

    public void put(int key, int value) {
        int size = cache.size();
        if (size >= capacity) {

        }
        cache.put(key, value);
    }
}