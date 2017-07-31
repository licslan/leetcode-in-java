public class Solution {
    public boolean isPalindrome(int x) {
        if (x < 0)
            return false;
        int y = 0, x1 = 1;
        while (x / x1 != 0) {
            y = y * 10 + x % 10;
            x /= 10;
            x1 *= 10;
        }
        return y < 10 * x ? y == x : y / 10 == x;
    }


    // 一种更好理解的方法
    public boolean isPalindrome1(int x) {
        // 不除掉末尾带0的，{回文数字}0...0 这种数字会被判为回文的
        if (x < 0 || (x != 0 && x % 10 == 0))
            return false;

        int y = 0;  // y表示从个位开始数，x表示从高位开始数
        while (x > y) {
            y = 10 * y + x % 10;
            x /= 10;
        }
        return (x == y) || (x == y / 10);
    }
}
