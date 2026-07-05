class TimeMap {
    public record Pair<K, V>(K key, V value) {};

    private Map<String, List<Pair<Integer, String>>> timeKvStore;

    public TimeMap() {
        timeKvStore = new HashMap();
    }
    
    public void set(String key, String value, int timestamp) {
        timeKvStore.putIfAbsent(key, new ArrayList<>());
        timeKvStore.get(key).add(new Pair<>(timestamp, value));
    }
    
    public String get(String key, int timestamp) {
        List<Pair<Integer, String>> timeSeries = timeKvStore.get(key);
        
        if (timeSeries == null || timeSeries.isEmpty()) {
            return "";
        }
        Pair<Integer, String> floorEntry = null;
        // Binary search for our timestamp, but keep the floor entry stored somewhere
        int left = 0;
        int right = timeSeries.size() - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            Pair<Integer, String> selected = timeSeries.get(mid);
            if (selected.key() == timestamp) {
                return selected.value();
            }
            else if (selected.key() < timestamp) {
                floorEntry = selected;
                left = mid + 1;
            }
            else {
                right = mid - 1;
            }
        }
        if (floorEntry == null) {
            return "";
        }
        return floorEntry.value();
    }
}
