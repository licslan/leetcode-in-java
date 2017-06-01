public class Solution {
    public int[][] matrixReshape(int[][] nums, int r, int c) {
        // n 这个矩阵有多少行，二维数组的第一个下标
        // m 这个矩阵有多少列（一行有多少个元素），二维数组的第二个下标
        int n = nums.length, m = nums[0].length;

        // 很显然，不合法的条件就是变形后矩阵元素的个数和原矩阵不一样
        if (r * c != m * n)
            return nums;

        // 有点像把二维数组转化成一维数组
        int[][] res = new int[r][c];
        for (int i = 0; i < r * c; i++)
            res[i / c][i % c] = nums[i / m][i % m];
        return res;
    }
}