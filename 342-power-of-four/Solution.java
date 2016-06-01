public class Solution {
    // 循环
    public boolean isPowerOfFour(int num) {
        while(num%4==0) num/=4;
        if(num==1) return true;
        return false;
    }

    // 不使用循环，用位运算
    // 是4的幂的数1，4，16，...，用二进制表示一定是0001,0100,010000这样的
    public boolean isPowerOfFour(int num) {
        // 首先检查是否只有一位为1
        if((num&(num-1))!=0) return false;
        // 再检查为1的那一位是否在1，3，...，31这些位上
        if((num&0x55555555)!=0) return true;
        return false;
    }
}