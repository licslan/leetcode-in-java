public class Solution {
    // O(32*n)
    // 每次计算数组中所有元素的同一位的和，模3，即可得到只有一个的那个数的那一位是多少
    // 如果把出现3次改为k次，那么只需模k就行了
    public int singleNumber(int[] nums) {
        int res = 0;
        int[] bitCount = new int[32];
        for (int i = 0; i < 32; i++) {
            for (int j = 0; j < nums.length; j++)
                bitCount[j] += (nums[j] >> i) & 1;
            res |= (bitCount[i] % 3) << i;
        }
        return res;
    }

    // 借助两个int数，用二进制模拟三进制
    public int singleNumber1(int[] nums) {
        //#curent  income  ouput
        //# ab      c/c       ab/ab
        //# 00      1/0       01/00
        //# 01      1/0       10/01
        //# 10      1/0       00/10
        // a=~abc+a~b~c;
        // b=~a~bc+~ab~c;
        int a = 0;
        int b = 0;
        for (int num : nums) {
            int ta = (~a & b & num) | (a & ~b & ~num);
            b = (~a & ~b & num) | (~a & b & ~num);
            a = ta;
        }
        //we need find the number that is 01,10 => 1, 00 => 0.
        return a | b;
    }
}