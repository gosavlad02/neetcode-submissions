class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if (s1.length() > s2.length()) {
            return false;
        }

        int[] s1Count = new int[26];
        int[] windowCount = new int[26];

        for (int i = 0; i < s1.length(); i++) {
            s1Count[s1.charAt(i) - 'a']++;
            windowCount[s2.charAt(i) - 'a']++;
        }

        for (int i = s1.length(); i < s2.length(); i++) {
            if (Arrays.equals(s1Count, windowCount)) {
                return true;
            }

            char newChar = s2.charAt(i); // adding the rightmost char
            char oldChar = s2.charAt(i - s1.length()); //removing the leftmost char

            windowCount[newChar - 'a']++;
            windowCount[oldChar - 'a']--;
        }

        return Arrays.equals(s1Count, windowCount);
    }
}
