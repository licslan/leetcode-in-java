public class Solution {
    public String reverseVowels(String s) {
        char[] str = s.toCharArray();
        for (int i = 0, j = str.length - 1; i < j;) {
            // 用indexOf判断是否为元音
            while ("AEIOUaeiou".indexOf(str[i]) == -1 && i < str.length - 1)
                i++;
            while ("AEIOUaeiou".indexOf(str[j]) == -1 && j > 0)
                j--;
            if (i < j) {
                char temp = str[i];
                str[i] = str[j];
                str[j] = temp;
                i++;
                j--;
            }
        }
        // 字符数组转字符串只能通过循环
        StringBuilder sb = new StringBuilder();
        for (char c : str)
            sb.append(c);
        return sb.toString();
    }

    // 直接通过StringBuilder构建新的字符串
    public static String reverseVowels1(String s) {
        char[] str = s.toCharArray();
        StringBuilder sb = new StringBuilder();
        int j = str.length - 1;
        for (int i = 0; i < str.length; i++) {
            // 如果为元音
            if ("AEIOUaeiou".indexOf(str[i]) != -1) {
                while (j >= 0 && "AEIOUaeiou".indexOf(str[j]) == -1)
                    j--;
                sb.append(str[j]);
                j--;
            } else
                sb.append(str[i]);
        }
        return sb.toString();
    }
}