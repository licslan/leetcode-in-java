public class Solution {
    public int myAtoi(String str) {
        // String有可能为 ""，即s.length()为0
        if (str == null || str.length() == 0)
            return 0;

        char[] c = str.toCharArray();
        int sign = 1;
        int res = 0;
        int i = 0;
        // 除掉前面的空格字符
        while (i < c.length && c[i] == ' ')
            ++i;

        // 判断是否符号
        if (i < c.length && c[i] == '+' || c[i] == '-')
            sign = (c[i++] == '+') ? 1 : -1;

        // 判断后面的字符是否是数字
        while (i < c.length && c[i] >= '0' && c[i] <= '9') {
            int digit = c[i] - '0';
            // 判断是否溢出
            if (res > Integer.MAX_VALUE / 10 || (res == Integer.MAX_VALUE / 10 && digit > Integer.MAX_VALUE % 10)) {
                if (sign == 1)
                    return Integer.MAX_VALUE;
                else
                    return Integer.MIN_VALUE;
            }
            res = res * 10 + digit;
            ++i;
        }
        return sign * res;
    }
}