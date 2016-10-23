public class Solution {
    // 一个完全平方数一定为1+3+5+...
    // 这样算时间复杂度O(n^0.5)
    public boolean isPerfectSquare1(int num) {
        int i = 1;
        while (num > 0) {
            num -= i;
            i += 2;
        }
        return num == 0;
    }

    // binary search, O(logn)
    public boolean isPerfectSquare2(int num) {
        int low = 1, high = num;
        while (low <= high) {
            long mid = (low + high) >> 1;// 这里必须用long定义mid来避免mid*mid溢出导致判断错误!!!
            if (mid * mid == num)
                return true;
            else if (mid * mid > num)
                high = (int) mid - 1;
            else
                low = (int) mid + 1;
        }
        return false;
    }

    // 牛顿方法，我没怎么看懂...
    public boolean isPerfectSquare3(int num) {
        long x = num;
        while (x * x > num) {
            x = (x + num / x) >> 1;
        }
        return x * x == num;
    }
}