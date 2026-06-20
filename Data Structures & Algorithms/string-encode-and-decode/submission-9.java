class Solution {

    public String encode(List<String> strs) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < strs.size(); i++) {
            String s = strs.get(i);
            sb.append(s.length() + "ă");
            sb.append(s);
        }
        return sb.toString();
    }

    public List<String> decode(String str) {
        List<String> strs = new ArrayList<>();
        if (str.length() == 0) {
            return strs;
        }
        int i = 0;
        while (i < str.length()) {
            int j = i;
            while (str.charAt(j) != 'ă') {
                j++;
            }
            int length = Integer.parseInt(str.substring(i, j));
            String s = str.substring(j + 1, j + 1 + length);
            strs.add(s);
            i = j + 1 + length;
        }
        return strs;
    }
}
