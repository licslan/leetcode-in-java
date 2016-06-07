public class Solution {
    // 利用桶排序思想，O(n) time
    public static int maximumGap(int[] nums) {
        if (nums == null || nums.length < 2)
            return 0;

        // 找到数组的最大值和最小值
        int max = nums[0], min = nums[0];
        for (int num : nums) {
            max = Math.max(max, num);
            min = Math.min(min, num);
        }

        // maxGap的最小值（当排序后所有相邻的数的gap都是一样大）
        int gap = (int) Math.ceil((double) (max - min) / (nums.length - 1));
        int[] bucketsMIN = new int[nums.length - 1];// 那个桶中的最小值
        int[] bucketsMAX = new int[nums.length - 1];// 那个桶中的最大值
        Arrays.fill(bucketsMIN, Integer.MAX_VALUE);
        Arrays.fill(bucketsMAX, Integer.MIN_VALUE);

        // 将数组中的元素入桶
        for (int num : nums) {
            if (num == min || num == max)
                continue;
            int index = (num - min) / gap;
            bucketsMIN[index] = Math.min(num, bucketsMIN[index]);
            bucketsMAX[index] = Math.max(num, bucketsMAX[index]);
        }

        // 遍历桶找到gap的最大值
        // 同一个桶中的最大值和最小值的差一定小于maxGap
        int maxGap = gap;
        int pre = min;
        for (int i = 0; i < nums.length - 1; i++) {
            if (bucketsMAX[i] == Integer.MIN_VALUE)// 空桶，bucketsMIN[i] == Integer.MAX_VALUE也可以
                continue;
            maxGap = Math.max(maxGap, bucketsMIN[i] - pre);
            pre = bucketsMAX[i];// 记录前一个有元素的痛的最大值
        }
        maxGap = Math.max(maxGap, max - pre);// 一定要记得比较这最后一个gap
        return maxGap;
    }
}