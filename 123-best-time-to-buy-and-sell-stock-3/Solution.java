public class Solution {
    // O(n^2),TLE
    // 将其分为两个时间段，分别计算每种划分的最大利润
    public int maxProfit1(int[] prices) {
        if (prices.length == 0)
            return 0;
        int[] maxProfit = new int[prices.length];
        for (int i = 1; i < prices.length; i++) {
            int minPrice1 = Integer.MAX_VALUE, maxProfit1 = 0;
            for (int j = 1; j < i; j++) {
                minPrice1 = Math.min(minPrice1, prices[j]);
                maxProfit1 = Math.max(maxProfit1, prices[j] - minPrice1);
            }
            int minPrice2 = Integer.MAX_VALUE, maxProfit2 = 0;
            for (int j = i; j < prices.length; j++) {
                minPrice2 = Math.min(minPrice2, prices[j]);
                maxProfit2 = Math.max(maxProfit2, prices[j] - minPrice2);
            }
            maxProfit[i] = maxProfit1 + maxProfit2;
        }
        Arrays.sort(maxProfit);
        return maxProfit[prices.length - 1];
    }
    
    // DP solution,O(n)
    // 利用动态规划的思想进行改进，保持计算的中间结果，减少重复的计算
    public int maxProfit(int[] prices) {
        int hold1 = Integer.MIN_VALUE, hold2 = Integer.MIN_VALUE;
        int release1 = 0, release2 = 0;
        for(int i:prices){                                // Assume we only have 0 money at first
            release2 = Math.max(release2, hold2 + i);     // The maximum if we've just sold 2nd stock so far.
            hold2 = Math.max(hold2, release1 - i);        // The maximum if we've just buy  2nd stock so far.
            release1 = Math.max(release1, hold1 + i);     // The maximum if we've just sold 1nd stock so far.
            hold1 = Math.max(hold1, -i);                  // The maximum if we've just buy  1st stock so far. 
        }
        return release2; // Since release1 is initiated as 0, so release2 will always higher than release1.
    }
}