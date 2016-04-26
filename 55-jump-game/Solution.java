/*
 * 贪心
 * 只需要时刻计算前位置和当前位置所能跳的最远长度,并始终和n作比较就可以
 * 
 */
public class Solution {
    public boolean canJump(int[] nums) {
        int n = nums.length;
        if (n == 0 || n == 1)
            return true;

        int maxStep = nums[0];// 贪心的标志
        for (int i = 1; i < n; i++) {
            if (maxStep == 0)
                return false;
            maxStep--;
            maxStep = Math.max(maxStep, nums[i]);
            if (maxStep + i >= n - 1)
                return true;
        }
        return false;
    }
}
