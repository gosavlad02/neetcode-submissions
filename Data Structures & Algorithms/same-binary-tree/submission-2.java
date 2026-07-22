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

record Pair(TreeNode p, TreeNode q) {}

class Solution {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        Deque<Pair> pairStack = new ArrayDeque<>();
        pairStack.push(new Pair(p, q));

        while (!pairStack.isEmpty()) {
            Pair nodePair = pairStack.pop();
            p = nodePair.p;
            q = nodePair.q;
            if (p == null && q == null) {
                continue;
            }
            if (p == null || q == null || p.val != q.val) {
                return false;
            }
            
            pairStack.push(new Pair(p.left, q.left));
            pairStack.push(new Pair(p.right, q.right));
        }
        return true;
    }
}
