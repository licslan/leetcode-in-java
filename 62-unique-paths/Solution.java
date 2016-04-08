public class Solution {
//  此题用递归会超时
// 	public int uniquePaths(int m, int n) {
// 		if (m == 1 || n == 1)
// 			return 1;
// 		return uniquePaths(m - 1, n) + uniquePaths(m, n - 1);
// 	}
	
	// 总共要走m+n-2步，其中m-1步向右走，n-1步向下走，实际就是一个组合问题
// 	public int uniquePaths(int m, int n) {
// 		int small = m > n ? n - 1 : m - 1;
// 		int totalSteps = m + n - 2;
// 		long result = 1;//结果有可能溢出
// 		for (int counter = 1; counter <= small; counter++) {
// 			result *= totalSteps--;
// 			result /= counter;
// 		}
// 		return (int)result;
// 	}

    public static int uniquePaths(int m, int n) {
		int[][] steps = new int[m+1][n+1];// steps[m][n]表示mxn时的步数
		for (int i = 1; i <= m; i++)
			steps[i][1] = 1;
		for (int i = 1; i <= n; i++)
			steps[1][i] = 1;
		// 从第二行开始更新数组值
		for (int i = 2; i <= m; i++) {
			for (int j = 2; j <= n; j++) {
				steps[i][j] = steps[i - 1][j] + steps[i][j - 1];
			}
		}
		return steps[m][n];
	}
}
