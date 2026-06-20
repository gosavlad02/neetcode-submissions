class Solution {

    public String encode(List<String> strs) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < strs.size(); i++) {
            String s = strs.get(i);
            if (s == "") {
                s = "î";
            }
            sb.append(s);
            if (i != strs.size() - 1) {
                sb.append("ă");
            }
        }
        return sb.toString();
    }

    public List<String> decode(String str) {
        List<String> strs = new ArrayList<>();
        if (str.length() == 0) {
            return strs;
        }
        for (String s : str.split("ă")) {
            if (s.equals("î")) {
                strs.add("");
            } else {
                strs.add(s);
            }
        }
        return strs;
    }
}
