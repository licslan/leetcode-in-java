public class Solution {
    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0)
            return "";

        String pre = strs[0];

        // 从第二个String开始比
        for (int i = 1; i < strs.length; ++i) {
            // String的indexOf这个方法，返回指定字符串第一次出现的位置；如果没出现，返回-1
            while (strs[i].indexOf(pre) != 0)
                // substring(m,n)方法截取[m,n)个字符
                pre = pre.substring(0, pre.length() - 1);

        }
        return pre;
    }
}
