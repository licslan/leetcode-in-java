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
    public TreeNode invertTree(TreeNode root) {
        if (root == null)
            return null;
        TreeNode l = root.left, r = root.right;
        root.left = invertTree(r);
        root.right = invertTree(l);
        return root;
    }

    // 非递归，借助栈实现
    public TreeNode invertTree1(TreeNode root) {
        if (root == null)
            return null;
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            TreeNode left = node.left;
            node.left = node.right;
            node.right = left;

            // 哪个先入栈都一样
            if (node.left != null) {
                stack.push(node.left);
            }
            if (node.right != null) {
                stack.push(node.right);
            }
        }
        return root;
    }

    // 非递归，借助队列，有点像层序遍历
    public TreeNode invertTree2(TreeNode root) {
        if (root == null)
            return null;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            TreeNode left = node.left;
            node.left = node.right;
            node.right = left;

            // 哪个先入栈都一样
            if (node.left != null) {
                queue.add(node.left);
            }
            if (node.right != null) {
                queue.add(node.right);
            }
        }
        return root;
    }
}