public class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> res = new ArrayList<>();

        Arrays.sort(nums);

        if (nums.length < 4)
            return res;

        for (int i = 0; i < nums.length - 3; ++i) {
            if (nums[i] + nums[i + 1] + nums[i + 2] + nums[i + 3] > target)
                break;
            if (nums[i] + nums[nums.length - 3] + nums[nums.length - 2] + nums[nums.length - 1] < target)
                continue;

            // 这个地方是if，不是while
            if (i > 0 && nums[i] == nums[i - 1])
                continue;

            for (int j = i + 1; j < nums.length - 2; ++j) {
                if (nums[i] + nums[j] + nums[j + 1] + nums[j + 2] > target)
                    break;
                if (nums[i] + nums[j] + nums[nums.length - 2] + nums[nums.length - 1] < target)
                    continue;

                if (j > i + 1 && nums[j] == nums[j - 1])
                    continue;

                int low = j + 1, high = nums.length - 1;
                while (low < high) {
                    int sum = nums[i] + nums[j] + nums[low] + nums[high];

                    if (sum == target) {
                        res.add(Arrays.asList(nums[i], nums[j], nums[low], nums[high]));
                        ++low;
                        --high;
                        while (low < high && nums[low] == nums[low - 1])
                            ++low;
                        while (low < high && nums[high] == nums[high + 1])
                            --high;
                    } else if (sum > target)
                        --high;
                    else
                        ++low;
                }
            }
        }

        return res;
    }
}