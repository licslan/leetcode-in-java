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
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        pathSum(root, sum, res, list);
        return res;
    }

    public void pathSum(TreeNode root, int sum, List<List<Integer>> res, List<Integer> list) {
        if (root == null)
            return;
        list.add(root.val);
        if (root.left == null && root.right == null && root.val == sum) {
            res.add(new ArrayList<>(list));// 不能用res.add(list);
        } else {
            pathSum(root.left, sum - root.val, res, list);
            pathSum(root.right, sum - root.val, res, list);
        }
        // 程序运行到这里，说明在左右子树都找不到解，path的集合中一定不包括这个结点
        // 所以一定要移除这最后一个元素
        // 因为要remove最后一个，所以用数组比链表更好
        list.remove(list.size() - 1);
    }
}