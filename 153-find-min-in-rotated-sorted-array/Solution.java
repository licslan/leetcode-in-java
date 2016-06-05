// 数组中没有重复元素
public class Solution {
    // binary search
    public int findMin(int[] nums) {
        int start = 0, end = nums.length - 1;
        while (start < end) {
            if (nums[start] < nums[end])
                return nums[start];

            int mid = (start + end) / 2;
            if (nums[mid] >= nums[start])// 这里是>=，不是>
                start = mid + 1;
            else
                end = mid;
        }
        return nums[start];
    }
}