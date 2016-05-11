/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

// 此题有一个陷阱，新的树是原来树的先序遍历
public class Solution {
    // 递归方法
    public void flatten(TreeNode root) {
        if (root == null)
            return;
        flatten(root.left);
        flatten(root.right);
        TreeNode right = root.right;// 记录下原右子树的根结点
        root.right = root.left;// 将根结点的右子树替换为原左子树
        root.left = null;// 将根结点的左子树置为空

        // 找到新的右子树先序遍历的最后一个结点
        while (root.right != null)
            root = root.right;
        root.right = right;// 将这个结点的右孩子指向原来的右子树
    }

    // 非递归方法1，借助栈实现
    public void flatten1(TreeNode root) {
        if (root == null)
            return;
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode curr = stack.pop();
            if (curr.right != null)
                stack.push(curr.right);
            if (curr.left != null)
                stack.push(curr.left);
            if (!stack.isEmpty())
                curr.right = stack.peek();// peek没有把栈顶元素移除
            curr.left = null;// 一定要有！否则会TLE
        }
    }

    // 非递归方法2
    public void flatten2(TreeNode root) {
        TreeNode curr = root;// root要一直引用根结点，不能改变
        while (curr != null) {
            if (curr.left != null) {
                TreeNode pre = curr.left;
                while (pre.right != null)
                    pre = pre.right;
                // 找到左子树上先序遍历最后的结点（最右的结点），并将其指向右子树的根结点
                pre.right = curr.right;

                // 将根结点的右子树替换为左子树，左子树置为空
                curr.right = curr.left;
                curr.left = null;
            }
            curr = curr.right;
        }
    }
}