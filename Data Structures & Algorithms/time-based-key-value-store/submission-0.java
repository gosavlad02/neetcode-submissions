class TimeMap {
    private Map<String, TreeMap<Integer, String>> timeKvStore;

    public TimeMap() {
        timeKvStore = new HashMap();
    }
    
    public void set(String key, String value, int timestamp) {
        timeKvStore.putIfAbsent(key, new TreeMap<>());
        TreeMap<Integer, String> timeSeries = timeKvStore.get(key);

        timeSeries.put(timestamp, value);
    }
    
    public String get(String key, int timestamp) {
        TreeMap<Integer, String> timeSeries = timeKvStore.get(key);
        
        if (timeSeries == null) {
            return "";
        }

        Map.Entry<Integer, String> entry = timeSeries.floorEntry(timestamp);
        
        if (entry == null) {
            return "";
        }

        return entry.getValue();
    }
}
