public class Solution {
    // 这题假定nums最少有3个元素
    public int threeSumClosest(int[] nums, int target) {
        // 首先一定要对nums排序，否则否则后面的操作都是没有意义的
        Arrays.sort(nums);

        int res = nums[0] + nums[1] + nums[nums.length - 1];
        for (int i = 0; i < nums.length - 2; ++i) {
            int low = i + 1, high = nums.length - 1;
            while (low < high) {
                int sum = nums[i] + nums[low] + nums[high];
                if (sum == target)
                    return target;
                else if (sum > target)
                    --high;
                else
                    ++low;
                if (Math.abs(sum - target) < Math.abs(res - target))
                    res = sum;
            }
        }
        return res;
    }
}