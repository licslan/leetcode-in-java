public class Solution {
    public int sumNumbers(TreeNode root) {
        return sum(root, 0);
    }

    // 递归，自顶向下计算每个叶子结点到跟结点的path sum
    public int sum(TreeNode root, int sum) {
        if (root == null)
            return 0;
        if (root.left == null && root.right == null)
            return 10 * sum + root.val;
        return sum(root.left, 10 * sum + root.val) + sum(root.right, 10 * sum + root.val);
    }
}