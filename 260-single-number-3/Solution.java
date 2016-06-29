public class Solution {
    public int[] singleNumber(int[] nums) {
        int diff = 0;

        // 计算不同的两个数的亦或
        for (int num : nums)
            diff ^= num;

        diff &= -diff;// 计算亦或结果最后为1的一位，不同的两个数这一位一定不同

        int[] res = { 0, 0 };
        // 按照这一个将不同的两个数分到两边，然后亦或两部分得到结果
        for (int num : nums) {
            if ((num & diff) == 0)
                res[0] ^= num;
            else
                res[1] ^= num;
        }
        return res;
    }
}