class Solution {
    public int characterReplacement(String s, int k) {
        Map<Character, Integer> charMap = new HashMap<>();
        int maxLength = 0;
        int maxCharCount = 0;

        int left = 0;
        for (int right = 0; right < s.length(); right++) {
            // get the most common character and see how many other chars we have, compare with k
            charMap.merge(s.charAt(right), 1, Integer::sum);
            maxCharCount = Math.max(maxCharCount, charMap.get(s.charAt(right)));
            while(right - left + 1 - maxCharCount > k) {
                charMap.merge(s.charAt(left), -1, Integer::sum);
                left++;
            }
            maxLength = Math.max(maxLength, right - left + 1);
        }

        return maxLength;
    }
}
