public class Solution {
    /*
     * 根据DP思想，1个台阶有1种方法，2个台阶有2种方法。
     * n个台阶可以理解为上n-2个台阶，然后2步直接上最后一步；或者上n-1个台阶，再1步上最后一步。
     * 
     */

    public int climbStairs(int n) {
        if (n == 0 || n == 1 || n == 2) {
            return n;
        }
        int[] mem = new int[n];
        mem[0] = 1;
        mem[1] = 2;
        for (int i = 2; i < n; i++) {
            mem[i] = mem[i - 1] + mem[i - 2];
        }
        return mem[n - 1];
    }

    /*
     * 递归在栈空间太小的时候可能会栈溢出
     */
    // public int climbStairs(int n) {
    // if (n == 0 || n == 1)
    // return n;
    // return climbStairs(n - 1) + climbStairs(n - 2);
    // }
}