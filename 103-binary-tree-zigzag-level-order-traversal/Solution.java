public class Solution {
    // 递归方法
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        buildList(root, 0, res);
        return res;
    }

    // 先序遍历
    public void buildList(TreeNode root, int depth, List<List<Integer>> res) {
        if (root == null)
            return;
        if (res.size() == depth)
            res.add(new ArrayList<Integer>());
        
        // 偶数层正向，奇数层反向
        if (depth % 2 == 0)
            res.get(depth).add(root.val);
        else
            res.get(depth).add(0, root.val);
        
        buildList(root.left, depth + 1, res);
        buildList(root.right, depth + 1, res);
    }

    // 非递归方法
    public List<List<Integer>> zigzagLevelOrder1(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        List<TreeNode> level = new ArrayList<>();
        level.add(root);
        int depth = 0;
        // 一次循环遍历完一层
        while (true) {
            // level.isEmpty()说明下一层已经没有任何结点了
            // level.get(0) == null是为了防止root结点为空
            if (level.isEmpty() || level.get(0) == null)
                break;
            List<TreeNode> nextLevel = new ArrayList<>();
            List<Integer> currentLevel = new ArrayList<>();

            for (TreeNode node : level) {
                if (depth % 2 == 0)
                    currentLevel.add(node.val);
                else
                    currentLevel.add(0, node.val);
                if (node.left != null)
                    nextLevel.add(node.left);
                if (node.right != null)
                    nextLevel.add(node.right);
            }
            res.add(currentLevel);
            level = nextLevel;
            depth++;
        }
        return res;
    }
}