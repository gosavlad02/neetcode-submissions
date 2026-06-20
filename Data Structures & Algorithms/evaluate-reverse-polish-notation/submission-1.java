class Solution {
    public int evalRPN(String[] tokens) {
        Deque<Integer> stack = new ArrayDeque<>();

        for (String c : tokens) {
            if (c.equals("+") || c.equals("-") || c.equals("*")|| c.equals("/")) {
                int a = stack.pop();
                int b = stack.pop();
                int result = switch (c) {
                    case "+" -> b + a;
                    case "-" -> b - a;
                    case "*" -> b * a;
                    case "/" -> b / a;
                    default -> 0;
                };
                stack.push(result);
            } else {
                stack.push(Integer.valueOf(c));
            }
        }
        return stack.pop();
    }
}
