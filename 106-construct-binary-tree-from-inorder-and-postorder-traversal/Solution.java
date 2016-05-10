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
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        Map<Integer, Integer> inMap = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            inMap.put(inorder[i], i);
        }
        return buildTree(inorder, 0, inorder.length - 1, postorder, 0, postorder.length - 1, inMap);
    }

    public TreeNode buildTree(int[] inorder, int inStart, int inEnd, int[] postorder, int postStart, int postEnd,
            Map<Integer, Integer> inMap) {
        if (inStart > inEnd || postStart > postEnd)
            return null;
        TreeNode root = new TreeNode(postorder[postEnd]);
        int inRoot = inMap.get(root.val);
        int leftNum = inRoot - inStart;
        root.left = buildTree(inorder, inStart, inRoot - 1, postorder, postStart, postStart + leftNum - 1, inMap);
        root.right = buildTree(inorder, inRoot + 1, inEnd, postorder, postStart + leftNum, postEnd - 1, inMap);
        return root;
    }
}