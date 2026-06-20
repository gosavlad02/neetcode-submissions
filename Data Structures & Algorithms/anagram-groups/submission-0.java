class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        // Group the anagrams using a character frequency list as key
        Map<List<Integer>, List<String>> anagramBins = new HashMap<>();
        
        for (String s : strs) {
            List<Integer> freqArray = getCharFrequency(s);
            if (anagramBins.containsKey(freqArray)) {
                anagramBins.get(freqArray).add(s);
            } else {
                List<String> bin = new ArrayList<>();
                bin.add(s);
                anagramBins.put(freqArray, bin);
            }
        }
        List<List<String>> res = new ArrayList<>();
        for (var val : anagramBins.values()) {
            res.add(val);
        }
        return res;
    }

    private List<Integer> getCharFrequency(String s) {
        Integer[] frequencyArr = new Integer[26];
        Arrays.fill(frequencyArr, 0);
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            int idx = c - 'a';
            frequencyArr[idx] += 1;
        }
        return Arrays.asList(frequencyArr);
    }
}
