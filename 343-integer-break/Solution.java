// 本题最少要拆成2个数
// 如果将2拆开，1+1，结果为1
// 将3拆开，2+1，结果为2
// 将4拆开，2+2，结果为4
// 大于4时，拆开乘积的最大结果比这个数要大。所以大于4就拆开。
// 对6来说，2+2+2和3+3，8<9，所以要尽量按3来拆

public class Solution {
    public int integerBreak(int n) {
        if (n == 2) return 1;
        if (n == 3) return 2;
        int product = 1;
        while (n > 4) {
            product *= 3;
            n -= 3;
        }
        return product * n;
    }
}