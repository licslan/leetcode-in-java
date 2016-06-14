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
    // 递归，beats 40%
    public int countNodes(TreeNode root) {
        int h = height(root);
        return h < 0 ? 0
                : height(root.right) == h - 1 ? (1 << h) + countNodes(root.right)
                        : (1 << (h - 1)) + countNodes(root.left);
    }

    // 求完全二叉树的结点的高度
    private int height(TreeNode root) {
        return root == null ? -1 : 1 + height(root.left);
    }

    // 递归另一个，计算结点高度不用递归，beats 90%
    public int countNodes1(TreeNode root) {
        TreeNode node = root;
        int height = -1;
        while (node != null) {
            height++;
            node = node.left;
        }
        return count(root, height);
    }

    private int count(TreeNode node, int depth) {
        if (node == null)
            return 0;
        TreeNode temp = node.right;
        int rightHeight = -1;
        while (temp != null) {
            rightHeight++;
            temp = temp.left;
        }
        if (rightHeight == depth - 1)
            return (1 << depth) + count(node.right, rightHeight);
        else
            return (1 << (depth - 1)) + count(node.left, depth - 1);
    }
}