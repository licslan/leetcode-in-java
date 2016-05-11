public class Solution {
    // 递归
    public String reverseString(String s) {
        if (s.length() <= 1)
            return s;
        int mid = s.length() / 2;
        String left = s.substring(0, mid);
        String right = s.substring(mid, s.length());
        return reverseString(right) + reverseString(left);
    }

    // 转成char数组，然后调换
    public String reverseString1(String s) {
        char[] c = s.toCharArray();
        for (int i = 0, j = c.length - 1; i < j; i++, j--) {
            char temp = c[i];
            c[i] = c[j];
            c[j] = temp;
        }
        return new String(c);
    }

    // 利用StringBuilder的reverse
    public String reverseString2(String s) {
        return new StringBuilder(s).reverse().toString();
    }
}