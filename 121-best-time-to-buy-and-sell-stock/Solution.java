public class Solution {
    // 卖出一定要在买入后面
    public int maxProfit(int[] prices) {
        // prices数组可能没有元素
        int minPrice = Integer.MAX_VALUE, maxProfit = 0;
        for (int price : prices) {
            minPrice = Math.min(minPrice, price);
            maxProfit = Math.max(maxProfit, price - minPrice);
        }
        return maxProfit;
    }

    // DP solution
    public int maxProfit1(int[] prices) {
        int hold = Integer.MIN_VALUE;
        int release = 0;
        for (int price : prices) {
            release = Math.max(release, hold + price);
            hold = Math.max(hold, -price);// 到这个price为止最低的买入价格
        }
        return release;
    }
}