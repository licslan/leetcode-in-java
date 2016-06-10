public class Solution {
    public int rob(int[] nums) {
        int rob = 0;// 抢了当前房子能获得的最大值
        int notrob = 0;// 不抢当前房子能获得的最大值
        // 注意几个变量出现计算的顺序
        for (int i = 0; i < nums.length; i++) {
            int currob = notrob + nums[i];// 如果抢当前的房子，前一个一定不能被抢
            notrob = Math.max(rob, notrob);// 如果不抢当前房子，取抢前一个房子和不抢前一个房子的最大值
            rob = currob;
        }
        return Math.max(rob, notrob);
    }
}