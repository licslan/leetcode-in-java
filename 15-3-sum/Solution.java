public class Solution {
	public List<List<Integer>> threeSum(int[] nums) {
		Arrays.sort(nums);//先对数组进行排序
		List<List<Integer>> list = new ArrayList<List<Integer>>();
		for (int i = 0; i < nums.length - 2; i++) {
			if (i > 0 && nums[i] == nums[i - 1])// 防止重复元素
				continue;
			for (int j = i + 1, k = nums.length - 1; j < k;) {
				if (nums[i] + nums[j] + nums[k] == 0) {
					list.add(Arrays.asList(nums[i], nums[j], nums[k]));
					j++;
					k--;
					while (j < k && nums[j] == nums[j - 1])
						j++;// 防止重复元素
					while (j < k && nums[k] == nums[k + 1])
						k--;// 防止重复元素
				} else if (nums[i] + nums[j] + nums[k] > 0) {
					k--;
				} else {
					j++;
				}
			}
		}
		return list;
	}
}
