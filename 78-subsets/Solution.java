public class Solution {
	public List<List<Integer>> subsets(int[] nums) {
		List<List<Integer>> res = new ArrayList<List<Integer>>();
		if (nums.length == 0)
			return res;
		Arrays.sort(nums);
		dfs(nums, res, new ArrayList<Integer>(), 0);
		return res;
	}

	public static void dfs(int[] nums, List<List<Integer>> res, List<Integer> list, int index) {
		res.add(new ArrayList<Integer>(list));

		for (int i = index; i < nums.length; i++) {
			list.add(nums[i]);
			dfs(nums, res, list, i + 1);
			list.remove(list.size() - 1);
		}
	}
}
