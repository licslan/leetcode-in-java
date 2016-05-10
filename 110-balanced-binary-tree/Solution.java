/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    // 按照平衡二叉树的定义：左右子树高度之差不大于1，且左右子树又都是平衡二叉树
    // top down approach
    // 要遍历所有结点，所有结点的高度都要计算
    public boolean isBalanced(TreeNode root) {
        if (root == null)
            return true;
        int left = depth(root.left);
        int right = depth(root.right);
        return Math.abs(left - right) <= 1 && isBalanced(root.left) && isBalanced(root.right);
    }

    public int depth(TreeNode root) {
        return root == null ? 0 : 1 + Math.max(depth(root.left), depth(root.right));
    }

    // 基于DFS
    // bottom up approach
    // 如果有某个结点return -1接下来就不用算了，因此比前一种好
    public boolean isBalanced1(TreeNode root) {
        return dfsDepth(root) != -1;
    }

    public int dfsDepth(TreeNode root) {
        if (root == null)
            return 0;
        int left = dfsDepth(root.left);
        if (left == -1)
            return -1;
        int right = dfsDepth(root.right);
        if (right == -1)
            return -1;
        if (Math.abs(left - right) > 1)
            return -1;
        return Math.max(left, right) + 1;
    }
}