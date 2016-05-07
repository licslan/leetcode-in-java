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
    // 递归
    public boolean isSameTree(TreeNode p, TreeNode q) {
        return p == null || q == null ? p == q : p.val == q.val && isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }

    // 非递归
    public boolean isSameTree1(TreeNode p, TreeNode q) {
        Stack<TreeNode> sp = new Stack<TreeNode>();
        Stack<TreeNode> sq = new Stack<TreeNode>();
        if(p!=null) sp.push(p);
        if(q!=null) sq.push(q);
        while(!sp.isEmpty()&&!sq.isEmpty()){
            TreeNode pn = sp.pop();
            TreeNode qn = sq.pop();
            if(pn.val!=qn.val) return false;
            if(pn.right!=null) sp.push(pn.right);
            if(qn.right!=null) sq.push(qn.right);
            if(sp.size()!=sq.size()) return false;
            if(pn.left!=null) sp.push(pn.left);
            if(qn.left!=null) sq.push(qn.left);
            if(sp.size()!=sq.size()) return false;
        }
        return sp.size()==sq.size();
    }
}