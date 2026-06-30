class Solution {
    public int lengthOfLongestSubstring(String s) {
        if (s.length() == 0) {
            return 0;
        }

        Set<Character> window = new HashSet<>();
        int longestSubstringLength = 0;
        int left = 0;
        for (int right = 0; right < s.length(); right++) {
            while (window.contains(s.charAt(right))) {
                window.remove(s.charAt(left));
                left++;
            }
            window.add(s.charAt(right));
            longestSubstringLength = Math.max(longestSubstringLength, window.size());
        }
        return longestSubstringLength;
    }
}
