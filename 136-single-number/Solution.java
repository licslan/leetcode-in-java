public class Solution {
    // XOR，异或具有交换性，相同的两个数异或结果为0，0和任意一个数异或结果为那个数
    // 只要是偶数次都可以用这个方法
    public int singleNumber(int[] nums) {
        int res = 0;
        for (int num : nums)
            res ^= num;
        return res;
    }
}