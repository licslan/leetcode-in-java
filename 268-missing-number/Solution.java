public class Solution {
    // 位操作
    public int missingNumber(int[] nums) {
        int res = 0, i = 0;
        for (; i < nums.length; i++)
            res ^= i ^ nums[i];
        return res ^ i;
    }
}