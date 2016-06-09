public class Solution {
    // 2的数量充足，统计所有因子中5这个因子的数量即可
    // 递归
    public int trailingZeroes(int n) {
        return n == 0 ? 0 : n / 5 + trailingZeroes(n / 5);
    }

    // 非递归
    public int trailingZeroes1(int n) {
        int res = 0;
        for (int i = n; i > 0; i /= 5)
            res += i / 5;
        return res;
    }
}