class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> anagramBins = new HashMap<>();
        
        for (String s : strs) {
            String freqKey = getCharFrequency(s);
            
            // If the key is missing, put a new ArrayList. Then, add the string.
            anagramBins.computeIfAbsent(freqKey, k -> new ArrayList<>()).add(s);
        }
        
        // Pass the map's values directly into the ArrayList constructor
        return new ArrayList<>(anagramBins.values());
    }

    private String getCharFrequency(String s) {
        // A char[] initializes with 0s automatically. 
        // We use it as a primitive number array to count frequencies.
        char[] count = new char[26];
        
        // s.toCharArray() is highly optimized in Java
        for (char c : s.toCharArray()) {
            count[c - 'a']++; 
        }
        
        // Convert the frequency counts directly into a String key
        return new String(count);
    }
}