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
    // recursion
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        help(root, res);
        return res;
    }

    public void help(TreeNode root, List<Integer> list) {
        if (root == null) return;
        list.add(root.val);
        help(root.left, list);
        help(root.right, list);
    }

    // iteration,using stack
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) return res;
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            res.add(node.val);
            if (node.right != null) stack.push(node.right);// 右子树在左子树后面遍历，根据栈先进后出的性质，先将右子树根结点压栈
            if (node.left != null) stack.push(node.left);
        }
        return res;
    }
}