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
    // 节点a与节点b的公共祖先c一定满足：a与b分别出现在c的左右子树上（如果a或者b本身不是祖先的话）
    // 从下向上计算
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root == p || root == q)
            return root;
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        if (left != null && right != null)// 如果a、b分别出现在root的左右子树上
            return root;

        // 两个结点只出现在root的一边子树上
        return left != null ? left : right;
    }

    // 非递归？
}