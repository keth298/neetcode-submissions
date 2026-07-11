class LRUCache {
    public Map<Integer, Integer> cache;
    public LinkedHashSet<Integer> leastRecentlyUsed;
    public int max;

    public LRUCache(int capacity) {
        cache = new HashMap<>();
        leastRecentlyUsed = new LinkedHashSet<>();
        max = capacity;
    }
    
    public int get(int key) {
        if(cache.containsKey(key)) {
            leastRecentlyUsed.remove(key);
            leastRecentlyUsed.add(key);
            return cache.get(key);
        }
        else return -1;
    }
    
    public void put(int key, int value) {
        if(cache.containsKey(key)) {
            leastRecentlyUsed.remove(key);
        } else if(cache.size() == max) {
            int oldest = leastRecentlyUsed.iterator().next();
            leastRecentlyUsed.remove(oldest);
            cache.remove(oldest);
        }
        cache.put(key, value);
        leastRecentlyUsed.add(key);
    }
}
