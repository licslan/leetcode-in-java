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
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        helper(root, res, 0);
        return res;
    }

    private void helper(TreeNode node, List<Integer> res, int depth) {
        if (node == null)
            return;
        if (depth == res.size())// 每层只加一个结点，由下面递归可知一定是加的最右边的结点
            res.add(node.val);
        helper(node.right, res, depth + 1);
        helper(node.left, res, depth + 1);
    }

    // 非递归，仿层序遍历，但是这里是从右向左层序遍历
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        if (root == null)
            return res;

        queue.offer(root);// this method is better than add
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {// 一次遍历就是一层结点
                TreeNode node = queue.poll();
                if (i == 0)// 第一个结点即本层最右边的结点
                    res.add(node.val);
                if (node.right != null)
                    queue.offer(node.right);
                if (node.left != null)
                    queue.offer(node.left);
            }
        }
        return res;
    }
}