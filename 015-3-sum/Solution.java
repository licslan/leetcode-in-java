public class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);

        List<List<Integer>> res = new ArrayList<>();

        for (int i = 0; i < nums.length - 2; ++i) {
            // 一定要有，去除掉重复的元组
            if (i > 0 && nums[i] == nums[i - 1])
                continue;

            int low = i + 1, high = nums.length - 1;
            while (low < high) {
                if (nums[i] + nums[low] + nums[high] == 0) {
                    res.add(Arrays.asList(nums[i], nums[low], nums[high]));

                    ++low;
                    --high;
                    // 去除掉重复的元组
                    while (low < high && nums[low] == nums[low - 1])
                        ++low;
                    while (low < high && nums[high] == nums[high + 1])
                        --high;
                } else if (nums[i] + nums[low] + nums[high] > 0)
                    --high;
                else
                    ++low;
            }
        }
        return res;
    }
}