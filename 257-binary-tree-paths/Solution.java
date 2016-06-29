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
    // DFS
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> res = new ArrayList<>();
        if (root != null)
            searchBT(root, "", res);
        return res;
    }

    private void searchBT(TreeNode root, String path, List<String> res) {
        if (root.left == null && root.right == null)// 叶子结点
            res.add(path + root.val);
        if (root.left != null)// 如果左子树不为空，搜索左子树
            searchBT(root.left, path + root.val + "->", res);
        if (root.right != null)
            searchBT(root.right, path + root.val + "->", res);
    }
}