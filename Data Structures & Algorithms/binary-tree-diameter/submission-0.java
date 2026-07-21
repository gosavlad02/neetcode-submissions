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
    public int diameterOfBinaryTree(TreeNode root) {
        int[] res = new int[1];
        dfs(root, res);
        return res[0];
    }

    public int dfs(TreeNode root, int[] res) {
        if (root == null) {
            return 0;
        }
        int heightLeft = dfs(root.left, res);
        int heightRight = dfs(root.right, res);

        res[0] = Math.max(res[0], heightLeft + heightRight);
        return 1 + Math.max(heightLeft, heightRight);
    }
}
