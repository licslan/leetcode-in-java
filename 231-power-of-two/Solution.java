public class Solution {
    // 位运算
    public boolean isPowerOfTwo1(int n) {
        if (n <= 0) return false;
        return (n & (n - 1)) == 0;
    }

    public boolean isPowerOfTwo2(int n) {
        if (n <= 0) return false;
        while (n % 2 == 0)
            n /= 2;
        return n == 1;
    }

    // 递归
    public boolean isPowerOfTwo(int n) {
        if (n <= 0) return false;
        return (n == 1) || (n % 2 == 0 && isPowerOfTwo(n / 2));
    }
}