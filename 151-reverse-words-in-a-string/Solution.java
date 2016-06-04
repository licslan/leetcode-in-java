public class Solution {
    public String reverseWords(String s) {
        String[] str = s.trim().split("\\s+");// 匹配任意多个空白字符
        StringBuilder sb = new StringBuilder();
        for (int i = str.length - 1; i > 0; i--)
            sb.append(str[i] + " ");
        sb.append(str[0]);
        return sb.toString();
    }
}