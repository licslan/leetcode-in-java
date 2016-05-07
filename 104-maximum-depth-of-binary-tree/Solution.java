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
    // 递归方法，DFS
    public int maxDepth(TreeNode root) {
        return root == null ? 0 : 1 + Math.max(maxDepth(root.left), maxDepth(root.right));
    }

    // 非递归方法，BFS，层序遍历
    public int maxDepth1(TreeNode root) {
        if (root == null) return 0;
        Queue<TreeNode> q = new LinkedList<>();
        int depth = 0;
        q.add(root);
        // 一次循环遍历一层
        while (!q.isEmpty()) {
            // 这里已定要用n = q.size()记录队列这次循环开始的大小，因为在下面循环中是会变化的
            for (int i = 0, n = q.size(); i < n; i++) {
                TreeNode node = q.poll();
                if (node.left != null) q.add(node.left);
                if (node.right != null) q.add(node.right);
            }
            depth++;
        }
        return depth;
    }
}