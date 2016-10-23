public class Solution {
    // 思想：把小的全换到最前面去，把大的全换到最后面去
    public void sortColors(int[] nums) {
        if (nums == null || nums.length < 2)
            return;
        int low = 0;
        int high = nums.length - 1;
        for (int i = low; i <= high;) {
            if (nums[i] == 0) {
                // swap A[i] and A[low] and i,low both ++
                int temp = nums[i];
                nums[i] = nums[low];
                nums[low] = temp;
                i++;
                low++;
            } else if (nums[i] == 2) {
                // swap A[i] and A[high] and high--;
                int temp = nums[i];
                nums[i] = nums[high];
                nums[high] = temp;
                high--;
            } else
                i++;
        }
    }
}
