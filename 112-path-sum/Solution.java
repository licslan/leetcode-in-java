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
    public boolean hasPathSum(TreeNode root, int sum) {
        // 此题算的是结点上的值，空结点的sum不为0
        if (root == null)
            return false;
        if (root.left == null && root.right == null && root.val == sum)
            return true;
        return hasPathSum(root.left, sum - root.val) || hasPathSum(root.right, sum - root.val);
    }

    // 非递归
    public boolean hasPathSum(TreeNode root, int sum) {
        Stack<TreeNode> stack = new Stack<TreeNode>();
        Stack<Integer> sums = new Stack<Integer>();

        stack.push(root);
        sums.push(sum);
        while (!stack.isEmpty() && (root != null)) {
            int value = sums.pop();
            TreeNode node = stack.pop();

            if (node.left == null && node.right == null && node.val == value) {
                return true;
            }
            if (node.left != null) {
                stack.push(node.left);
                sums.push(value - node.val);
            }
            if (node.right != null) {
                stack.push(node.right);
                sums.push(value - node.val);
            }
        }
        return false;
    }
}