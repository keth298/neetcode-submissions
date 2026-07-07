class TimeMap {
    private Map<String, List<int[]>> timestamps;
    public Map<String, List<String>> values;

    public TimeMap() {
        timestamps = new HashMap<>();
        values = new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        timestamps.computeIfAbsent(key, k -> new ArrayList<>()).add(new int[]{timestamp});
        values.computeIfAbsent(key, k -> new ArrayList<>()).add(value);
    }
    
    public String get(String key, int timestamp) {
        if (!timestamps.containsKey(key)) return "";
        List<int[]> times = timestamps.get(key);
        List<String> vals = values.get(key);
        int lo = 0, hi = times.size() - 1, result = -1;
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            if (times.get(mid)[0] <= timestamp) {
                result = mid;
                lo = mid + 1;
            } else {
                hi = mid - 1;
            }
        }
        return result == -1 ? "" : vals.get(result);
    }
}
