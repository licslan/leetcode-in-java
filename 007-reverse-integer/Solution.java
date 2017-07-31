public class Solution {
    public int reverse(int x) {
        long res = 0;

        // 在Java中，-9999%10=-9，所以负数也可以这样除
        for (; x != 0; x /= 10)
            res = 10 * res + x % 10;

        // 题目要求中说，当溢出int范围时，返回0
        if (res > Integer.MAX_VALUE || res < Integer.MIN_VALUE)
            return 0;

        // 这里返回类型是int，需要将long类型强转成int
        return (int) res;
    }
}
