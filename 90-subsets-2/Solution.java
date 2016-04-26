public class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        List<Integer> each = new ArrayList<Integer>();
        helper(res, each, 0, nums);
        return res;
    }

    public static void helper(List<List<Integer>> res, List<Integer> each, int pos, int[] nums) {
        if (pos <= nums.length)
            res.add(each);
        for (int i = pos; i < nums.length;) {
            each.add(nums[i]);
            helper(res, new ArrayList<Integer>(each), i + 1, nums);// 这里必须写成new
                                                                   // ArrayList<Integer>(each)，不能写成each
            each.remove(each.size() - 1);
            i++;
            while (i < nums.length && nums[i] == nums[i - 1])
                i++;
        }
    }
}
