public class Solution {
    public int numDecodings(String s) {
        // 空字符串和以0开头的没有decode方法
        if (s.length() == 0 || s.charAt(0) == '0')
            return 0;
        // r1、r2表示前一个字符串和前前一个字符串的方法数
        int r1 = 1, r2 = 1;
        for (int i = 1; i < s.length(); i++) {
            // 如果最后一个数字为0，则前一个字符串的方法数为0
            if (s.charAt(i) == '0')
                r1 = 0;
            // 这种情况可以以最后一位数为一个字符解码，也可以以最后两位数为一个字符解码，所以是这两种情况数目的和
            if (s.charAt(i - 1) == '1' || (s.charAt(i - 1) == '2' && s.charAt(i) <= '6')) {
                r1 = r1 + r2;
                r2 = r1 - r2;
            }
            // 只有以最后一位数为一个字符解码
            else {
                r2 = r1;
            }
        }
        return r1;
    }
}