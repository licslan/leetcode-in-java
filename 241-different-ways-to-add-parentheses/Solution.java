public class Solution {
    public List<Integer> diffWaysToCompute(String input) {
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);
            if (c == '+' || c == '-' || c == '*') {
                String input1 = input.substring(0, i);
                String input2 = input.substring(i + 1);
                List<Integer> res1 = diffWaysToCompute(input1);
                List<Integer> res2 = diffWaysToCompute(input2);
                for (Integer p : res1) {
                    for (Integer q : res2) {
                        int r = 0;
                        if (c == '+')
                            r = p + q;
                        else if (c == '-')
                            r = p - q;
                        else if (c == '*')
                            r = p * q;
                        res.add(r);
                    }
                }
            }
        }

        // 基界条件
        if (res.size() == 0)
            res.add(Integer.valueOf(input));
        return res;
    }
}