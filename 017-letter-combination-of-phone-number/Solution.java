public class Solution {
    String[][] refer = {{}, {}, {"a", "b", "c"}, {"d", "e", "f"},
            {"g", "h", "i"}, {"j", "k", "l"}, {"m", "n", "o"},
            {"p", "q", "r", "s"}, {"t", "u", "v"}, {"w", "x", "y", "z"}};

    public List<String> letterCombinations(String digits) {
        List<String> res = new ArrayList<>();

        // 当digits为""时，res应该为[]，而不是[""]
        if (digits == null || digits.length() == 0)
            return res;

        helper(res, digits, "");
        return res;
    }

    private void helper(List<String> list, String digits, String s) {
        if (digits.length() == 0) {
            list.add(s);
            return;
        }

        int idx = Integer.parseInt(digits.substring(0, 1));
        for (String e : refer[idx]) {
            helper(list, digits.substring(1, digits.length()), s + e);
        }
    }
}
