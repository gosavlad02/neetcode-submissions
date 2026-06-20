class Solution {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        Map<Character, Integer> sChars = new HashMap<>();
        Map<Character, Integer> tChars = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            sChars.merge(s.charAt(i), 1, (oldVal, newVal) -> oldVal + newVal);
            tChars.merge(t.charAt(i), 1, (oldVal, newVal) -> oldVal + newVal);
        }
        
        if (sChars.keySet().size() != tChars.keySet().size()) {
            return false;
        }
        for (var entry : sChars.entrySet()) {
            char character = entry.getKey();
            int tCount = tChars.getOrDefault(character, 0);
            if (entry.getValue() != tCount) {
                return false;
            }
        }
        return true;

    }
}