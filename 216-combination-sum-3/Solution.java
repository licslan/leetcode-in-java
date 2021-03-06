public class Solution {
    // backtracking
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> res = new ArrayList<>();
        combination(res, new ArrayList<>(), k, 1, n);
        return res;
    }

    private void combination(List<List<Integer>> res, List<Integer> comb, int k, int start, int n) {
        if (comb.size() == k && n == 0) {
            List<Integer> list = new ArrayList<>(comb);
            res.add(list);
            return;
        }

        for (int i = start; i <= 9; i++) {
            comb.add(i);
            combination(res, comb, k, i + 1, n - i);
            comb.remove(comb.size() - 1);
        }
    }
}