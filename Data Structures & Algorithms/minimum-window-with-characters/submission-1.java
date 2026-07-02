class Solution {
    public String minWindow(String s, String t) {
        if (s.length() < t.length()) {
            return "";
        }
        Map<Character, Integer> tFrequencies = new HashMap<>();
        Map<Character, Integer> windowFrequencies = new HashMap<>();

        for (char c : t.toCharArray()) {
            tFrequencies.merge(c, 1, Integer::sum);
        }
        System.out.println(tFrequencies);

        String substring = s + "1";

        int left = 0;
        for (int right = 0; right < s.length(); right++) {
            windowFrequencies.merge(s.charAt(right), 1, Integer::sum);
            while (isValidSubset(tFrequencies, windowFrequencies)) {
                System.out.println(windowFrequencies);
                String window = s.substring(left, right + 1);
                System.out.printf("Left %d, Right %d and window %s \n", left, right, window);
                if (window.length() < substring.length()) {
                    substring = window;
                }
                windowFrequencies.merge(s.charAt(left), -1, Integer::sum);
                left++;
            }
        }
        if (substring.length() > s.length()) {
            return "";
        }
        return substring;
    }

    private boolean isValidSubset(Map<Character, Integer> tFrequencies, Map<Character, Integer> windowFrequencies) {
        for (char c : tFrequencies.keySet()) {
            if (windowFrequencies.getOrDefault(c, 0) < tFrequencies.get(c)) {
                return false;
            }
        }
        return true;
    }
}
