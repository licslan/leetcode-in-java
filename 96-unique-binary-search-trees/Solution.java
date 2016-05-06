// DP solution
// dp[k] represents the number of BST trees built from 1....k
public class Solution {
    public int numTrees(int n) {
        int[] dp = new int[n + 1];
        dp[0] = 1;// dp[0] represents null node
        dp[1] = 1;
        for (int level = 2; level <= n; level++)
            for (int root = 1; root <= level; root++)
                dp[level] += dp[root - 1] * dp[level - root];// 左子树的情况数乘右子树的情况数
        return dp[n];
    }
}