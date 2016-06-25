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
    // 递归
    public int kthSmallest(TreeNode root, int k) {
        int lcount = countNode(root.left);
        if (k <= lcount)
            return kthSmallest(root.left, k);
        else if (k > lcount + 1)
            return kthSmallest(root.right, k - lcount - 1);
        return root.val;
    }

    private int countNode(TreeNode node) {
        if (node == null)
            return 0;
        return 1 + countNode(node.left) + countNode(node.right);
    }

    // 遍历
    public int kthSmallest1(TreeNode root, int k) {
        Stack<TreeNode> stack = new Stack<>();

        while (root != null) {
            stack.push(root);
            root = root.left;
        }

        while (k > 0) {
            TreeNode node = stack.pop();
            k--;
            if (k == 0)
                return node.val;

            node = node.right;
            while (node != null) {
                stack.push(node);
                node = node.left;
            }
        }
        return -1;
    }
}