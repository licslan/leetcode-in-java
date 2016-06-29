public class Solution {
    // 一个数和自己异或结果为0，和0异或结果为本身
    // 位操作
    public int missingNumber(int[] nums) {
        int res = 0, i = 0;
        for (; i < nums.length; i++)
            res ^= i ^ nums[i];
        return res ^ i;
    }
}