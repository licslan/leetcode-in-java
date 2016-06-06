public class Solution {
    // binary search
    public int findMin(int[] nums) {
        int start = 0, end = nums.length - 1;
        while (start < end) {
            int mid = (start + end) / 2;
            if (nums[mid] > nums[end])// min在右边
                start = mid + 1;
            else if (nums[mid] < nums[end])// min在左边
                end = mid;
            else {// nums[mid]==nums[end]
                if (nums[mid] == nums[start]) {
                    start++;
                    end--;
                } else
                    end = mid;
            }
        }
        return nums[end];
    }
}