public class Solution {
	public List<List<Integer>> threeSum(int[] nums) {
		Arrays.sort(nums);// 先对数组进行排序
		List<List<Integer>> list = new ArrayList<List<Integer>>();
		for (int i = 0; i < nums.length - 2; i++) {
			if (i > 0 && nums[i] == nums[i - 1])// 防止重复元素
				continue;
			int start = i + 1, end = nums.length - 1;
			while (start < end) {
				if (nums[i] + nums[start] + nums[end] == 0) {
					list.add(Arrays.asList(nums[i], nums[start], nums[end]));
					start++;
					end--;
					while (start < end && nums[start] == nums[start - 1])
						start++;// 防止重复元素
					while (start < end && nums[end] == nums[end + 1])
						end--;// 防止重复元素
				} else if (nums[i] + nums[start] + nums[end] > 0) {
					end--;
				} else {
					start++;
				}
			}
		}
		return list;
	}
}
