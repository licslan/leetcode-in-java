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
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        help(root, res);
        return res;
    }

    public void help(TreeNode root, List<Integer> list) {
        if (root == null) return;
        help(root.left, list);
        help(root.right, list);
        list.add(root.val);
    }

    // iteration
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) return res;
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            res.add(0, node.val);// 这样使根结点在左子树和右子树后面
            // 这里因为后加入res的结点在前面，所以要将左子树先压栈
            if (node.left != null) stack.push(node.left);// 注意这里是node，不要写成root
            if (node.right != null) stack.push(node.right);
        }
        return res;
    }
}