class Solution {
    public boolean checkInclusion(String s1, String s2) {
        final int HASH_S1 = computeHash(s1);
        final int WINDOW_LENGTH = s1.length();
        for (int left = 0; left + WINDOW_LENGTH <= s2.length(); left++) {
            int hashS2 = computeHash(s2.substring(left, left + WINDOW_LENGTH));
            if (HASH_S1 == hashS2) {
                return true;
            }
        }
        return false;
    }

    private int computeHash(String s) {
        char[] chars = s.toCharArray();
        Arrays.sort(chars);
        return Arrays.hashCode(chars);
    }
}
