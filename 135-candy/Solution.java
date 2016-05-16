public class Solution {
    public int candy(int[] ratings) {
        int sum = 0;
        int[] nums = new int[ratings.length];
        // 每人最少要有一颗糖，全部初始化为1
        for (int i = 0; i < nums.length; i++)
            nums[i] = 1;
        // 从左到右扫描一遍
        for (int i = 0; i < nums.length - 1; i++) {
            if (ratings[i + 1] > ratings[i])
                nums[i + 1] = nums[i] + 1;
        }
        // 从右到左扫描一遍，注意判断条件
        for (int i = nums.length - 1; i > 0; i--) {
            if (ratings[i - 1] > ratings[i] && nums[i - 1] < nums[i] + 1)
                nums[i - 1] = nums[i] + 1;
        }
        for (int num : nums)
            sum += num;
        return sum;
    }
}