public class Solution {
    public int removeDuplicates(int[] nums) {
        int count = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == nums[i - 1])
                count++;
            else
                nums[i - count] = nums[i];
        }
        return nums.length - count;
    }

    public int removeDuplicates1(int[] nums) {
        if (nums.length < 2)
            return nums.length;

        int i = 0;
        for (int j = 1; j < nums.length; ++j) {
            if (nums[j] != nums[i]) {
                ++i;
                nums[i] = nums[j];
            }
        }

        return i + 1;
    }
}
