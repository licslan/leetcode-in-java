public class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        helper(res, "", 0, 0, n);
        return res;
    }

    private void helper(List<String> res, String s, int open, int close, int n) {
        // 递归基界：匹配到了n对括号，将此时拼凑的String添加到res中
        if (s.length() == 2 * n) {
            res.add(s);
            return;
        }

        // 当左括号没有添加到n个时，添加左括号
        if (open < n)
            helper(res, s + "(", open + 1, close, n);
        // 因为是从左往右添加，拼凑字符串过程中，右括号的数目始终要小于等于左括号的数目，否则就不符合规范
        if (close < open)
            helper(res, s + ")", open, close + 1, n);
    }
}