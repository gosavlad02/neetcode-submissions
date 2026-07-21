/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

record Pair(TreeNode node, int depth) {}

class Solution {
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }

        Deque<Pair> stack = new ArrayDeque<>();
        stack.push(new Pair(root, 1));
        int res = 0;

        while (!stack.isEmpty()) {
            Pair current = stack.pop();
            TreeNode node = current.node;
            int depth = current.depth;

            if (node != null) {
                res = Math.max(res, depth);
                stack.push(new Pair(node.left, depth + 1));
                stack.push(new Pair(node.right, depth + 1));
            }
        }

        return res;


    }
}
