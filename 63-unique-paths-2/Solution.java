public class Solution {
    public static int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        int[][] steps = new int[m + 1][n + 1];// steps[m][n]表示mxn时的步数
        for (int i = 1; i <= m; i++) {
            if (obstacleGrid[i - 1][0] == 0) {
                steps[i][1] = 1;
            } else {
                break;
            }
        }
        for (int i = 1; i <= n; i++) {
            if (obstacleGrid[0][i - 1] == 0) {
                steps[1][i] = 1;
            } else {
                break;
            }
        }
        // 从第二行开始更新数组值
        for (int i = 2; i <= m; i++) {
            for (int j = 2; j <= n; j++) {
                if (obstacleGrid[i - 1][j - 1] == 1)
                    steps[i][j] = 0;
                else
                    steps[i][j] = steps[i - 1][j] + steps[i][j - 1];
            }
        }
        return steps[m][n];
    }
}
