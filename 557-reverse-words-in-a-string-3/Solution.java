public class Solution {
    public String reverseWords(String s) {
        char[] ca = s.toCharArray();

        for (int i = 0; i < ca.length; i++) {
            if (ca[i] != ' ') {
                int j = i;
                // ca[j]不是空格，ca[j+1]是空格
                while (j + 1 < ca.length && ca[j + 1] != ' ')
                    j++;
                reverseWord(ca, i, j);
                i = j;
            }

            // 当字符为空格时，直接i++跳过
        }
        return new String(ca);  // 用new String()将字符数组转化成String
    }

    private void reverseWord(char[] ca, int i, int j) {
        for (; i < j; i++, j--) {
            char temp = ca[i];
            ca[i] = ca[j];
            ca[j] = temp;
        }
    }
}