/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
 
// 中序遍历一棵二叉树
public class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<Integer>();
        // inorderTraversalRecursive(root, result);
        inorderTraversalIterative(root, result);
        return result;
    }

    private void inorderTraversalIterative(TreeNode root, List<Integer> result) {
        LinkedList<TreeNode> stack = new LinkedList<TreeNode>();
        TreeNode curr = root;
        // 当前结点不为空或者栈不为空时
        while (curr != null || !stack.isEmpty()) {
            if (curr != null) {
                stack.offerLast(curr);// push
                curr = curr.left;
            } else {
                result.add(stack.getLast().val);
                curr = stack.getLast().right;
                stack.pollLast();// pop
            }
        }
    }

    private void inorderTraversalRecursive(TreeNode root, List<Integer> result) {
        if (root == null) {
            return;
        }
        inorderTraversalRecursive(root.left, result);
        result.add(root.val);
        inorderTraversalRecursive(root.right, result);
    }
}