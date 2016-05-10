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
    // 递归方法
    public int minDepth1(TreeNode root) {
        if (root == null)
            return 0;
        int left = minDepth1(root.left);
        int right = minDepth1(root.right);
        // 左子树或右子树为空时，直接在不为空的子树上+1，否则就选较小的子树+1
        return left == 0 || right == 0 ? left + right + 1 : Math.min(left, right) + 1;
    }

    // 非递归方法，借助队列，层序遍历，类似于BFS
    public int minDepth(TreeNode root) {
        if (root == null)
            return 0;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int depth = 1;
        // 一次循环遍历树的一层
        while (!queue.isEmpty()) {
            int size = queue.size();// determine the loop size，这里一定要注意
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                // 找到第一个叶子结点（叶子结点没有左孩子和右孩子）并返回结果
                if (node.left == null && node.right == null)
                    return depth;
                if (node.left != null)
                    queue.add(node.left);
                if (node.right != null)
                    queue.add(node.right);
            }
            depth++;
        }
        return depth;
    }
}