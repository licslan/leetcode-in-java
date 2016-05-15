public class Solution {
    // 一定要注意边界
    public static boolean isPalindrome(String s) {
        char[] c = s.toLowerCase().toCharArray();
        for (int i = 0, j = c.length - 1; i < j; i++, j--) {
            while (i <= c.length - 1 && !(c[i] >= 'a' && c[i] <= 'z' || c[i] >= '0' && c[i] <= '9'))
                i++;
            while (j >= 0 && !(c[j] >= 'a' && c[j] <= 'z' || c[j] >= '0' && c[j] <= '9'))
                j--;
            if (i < j && c[i] != c[j])
                return false;
        }
        return true;
    }
}