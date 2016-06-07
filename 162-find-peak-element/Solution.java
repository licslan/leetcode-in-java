public class Solution {
    // O(n)
    public int findPeakElement(int[] nums) {
        for (int i = 1; i < nums.length; i++)
            if (nums[i] < nums[i - 1])
                return i - 1;
        return nums.length - 1;
    }

    // binary
    public int findPeakElement1(int[] nums) {
        int low = 0, high = nums.length - 1;
        while (low < high) {
            int mid1 = (low + high) / 2;
            int mid2 = mid1 + 1;
            if (nums[mid1] < nums[mid2])
                low = mid2;
            else
                high = mid1;
        }
        return low;
    }

    // binary recursion
    public int findPeakElement2(int[] nums) {
        int low = 0, high = nums.length - 1;
        return helper(nums, low, high);
    }

    public int helper(int[] nums, int low, int high) {
        if (low == high)
            return low;
        int mid1 = (low + high) / 2;
        int mid2 = mid1 + 1;
        if (nums[mid1] < nums[mid2])
            return helper(nums, mid2, high);
        else
            return helper(nums, low, mid1);

    }
}