/*
 * 例如
1  2  3             
4  5  6
7  8  9
先将其以对角线对称，swap(matrix[i][j], matrix[j][i])，得到如下：
1  4  7
2  5  8
3  6  9
再以垂直线对称，(swap(matrix[i][j], matrix[i][matrix.length-1-j])，得到最终结果
7  4  1
8  5  2
9  6  3
 */
public class Solution {
    public void rotate(int[][] matrix) {
        // 纵坐标
        for (int i = 0; i < matrix.length; i++) {
            // 横坐标
            for (int j = i + 1; j < matrix[0].length; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
        // 纵坐标
        for (int i = 0; i < matrix.length; i++) {
            // 横坐标
            for (int j = 0; j < matrix.length / 2; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[i][matrix.length - 1 - j];
                matrix[i][matrix.length - 1 - j] = temp;
            }
        }
    }
}
