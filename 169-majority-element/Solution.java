public class Solution {
    // O(nlogn)
    public int majorityElement(int[] nums) {
        Arrays.sort(nums);
        int len = nums.length;
        return nums[len / 2];
    }

    // O(n)
    public int majorityElement(int[] nums) {
        int major = nums[0];
        int count = 1;
        for (int i = 1; i < nums.length; i++) {
            if (count == 0) {
                major = nums[i];
                count++;
            } else if (major == nums[i])
                count++;
            else
                count--;
        }
        return major;
    }
}