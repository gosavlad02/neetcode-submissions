class Solution {
    public boolean isValid(String s) {
        Deque<Character> openStack = new ArrayDeque<>();
        Map<Character, Character> pairs = new HashMap();
        pairs.put(')', '(');
        pairs.put(']', '[');
        pairs.put('}', '{');
        
        for (char c : s.toCharArray()) {
            if (pairs.containsKey(c)) {
                if (!openStack.isEmpty() && openStack.peek() == pairs.get(c)) {
                    openStack.pop();
                } else {
                    return false;
                }
            } else {
                openStack.push(c);
            }
        }
        return openStack.isEmpty();
    }
}
 