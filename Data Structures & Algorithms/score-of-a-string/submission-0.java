class Solution {
    public int scoreOfString(String s) {
        // for i in [0, n - 1):
        // sum += Math.abs(s[i + 1] - s[i]);
        // return sum

        int sum = 0;
        for (int i = 0; i < s.length() - 1; i++) {
            sum += Math.abs(s.charAt(i + 1) - s.charAt(i));
        }
        return sum;
    }
}