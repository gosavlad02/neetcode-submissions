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

class Solution {
    public boolean isBalanced(TreeNode root) {
        if (root == null) {
            return true;
        }
        Map<TreeNode, Integer> heightMap = new HashMap<>();
        heightMap.put(null, 0);

        Deque<TreeNode> stack = new ArrayDeque<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode node = stack.peekFirst();

            if (node.left != null && !heightMap.containsKey(node.left)) {
                stack.push(node.left);
            }
            else if (node.right != null && !heightMap.containsKey(node.right)) {
                stack.push(node.right);
            }
            else {
                node = stack.pop();

                int heightLeft = heightMap.get(node.left);
                int heightRight = heightMap.get(node.right);

                if (Math.abs(heightLeft - heightRight) > 1) return false;

                int height = Math.max(heightLeft, heightRight) + 1;
                heightMap.put(node, height);
            }
        }
        return true;
    }
}
