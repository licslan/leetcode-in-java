public class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        return combinationSum(candidates, target, 0);
    }

    public List<List<Integer>> combinationSum(int[] candidates, int target, int start) {

        List<List<Integer>> res = new LinkedList<List<Integer>>();
        List<Integer> lst = new ArrayList<>();

        for (int i = start; i < candidates.length; i++) {
            if (candidates[i] < target) {
                for (List<Integer> ar : combinationSum(candidates, target - candidates[i], i)) {
                    ar.add(0, candidates[i]);
                    res.add(ar);
                }
            } else if (candidates[i] == target) {
                lst.add(candidates[i]);
                res.add(lst);
            } else
                break;
        }
        return res;
    }
}
