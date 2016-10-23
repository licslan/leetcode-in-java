public class Solution {
    public int firstMissingPositive(int[] nums) {
        // nums[i] -> i+1
        int next;
        for (int i = 0; i < nums.length; i++) {
            int curr = nums[i];
            if (curr > 0 && curr != i + 1 && curr <= nums.length) {
                do {
                    next = nums[curr - 1];
                    nums[curr - 1] = curr;
                    curr = next;
                } while (curr > 0 && curr <= nums.length && nums[curr - 1] != curr);
            }
        }
        int j = 0;
        for (; j < nums.length; j++) {
            if (nums[j] != j + 1)
                break;
        }
        return j + 1;
    }
}
