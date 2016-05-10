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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        Map<Integer, Integer> inMap = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            inMap.put(inorder[i], i);
        }
        return buildTree(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1, inMap);
    }

    // 一棵树先序遍历的第一个结点是根结点
    // 每次递归根据子树的前序和中序求出这个子树的根结点，并划分出其左右子树
    // start和end分别为这个子树第一个和最后一个结点在各种遍历中的索引
    // 当start=end，子树只有一个结点；当start>end，子树为空
    public TreeNode buildTree(int[] preorder, int preStart, int preEnd, int[] inorder, int inStart, int inEnd,
            Map<Integer, Integer> inMap) {
        if (preStart > preEnd || inStart > inEnd)
            return null;
        TreeNode root = new TreeNode(preorder[preStart]);
        // 求出此次根结点在中序遍历中的位置
        int inRoot = inMap.get(root.val);
        // 从而可以得知左右子树的大小
        int numLeft = inRoot - inStart;
        root.left = buildTree(preorder, preStart + 1, preStart + numLeft, inorder, inStart, inRoot - 1, inMap);
        root.right = buildTree(preorder, preStart + numLeft + 1, preEnd, inorder, inRoot + 1, inEnd, inMap);
        return root;
    }

    // TODO:非递归方法
}