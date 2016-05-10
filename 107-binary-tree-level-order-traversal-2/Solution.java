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
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        buildList(root, 0, res);
        Collections.reverse(res);
        return res;
    }

    // 先序遍历
    public void buildList(TreeNode root, int depth, List<List<Integer>> res) {
        if (root == null)
            return;
        if (res.size() == depth)
            res.add(new ArrayList<Integer>());
        res.get(depth).add(root.val);
        buildList(root.left, depth + 1, res);
        buildList(root.right, depth + 1, res);
    }
}