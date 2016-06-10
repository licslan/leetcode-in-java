public class Solution {
    // you need treat n as an unsigned value
    public int reverseBits(int n) {
        // 这里一定要注意，右移的时候用>>>，不能用>>
        n = (n >>> 16) | (n << 16);
        n = ((n & 0xff00ff00) >>> 8) | ((n & 0x00ff00ff) << 8);
        n = ((n & 0xf0f0f0f0) >>> 4) | ((n & 0x0f0f0f0f) << 4);
        n = ((n & 0xcccccccc) >>> 2) | ((n & 0x33333333) << 2);
        n = ((n & 0xaaaaaaaa) >>> 1) | ((n & 0x55555555) << 1);
        return n;
    }

    public int reverseBits1(int n) {
        int res = 0;
        for (int i = 0; i < 32; i++) {
            res += n & 1;
            n >>>= 1;
            if (i < 31)// 最后一个位的时候不用移
                res <<= 1;
        }
        return res;
    }
    // 0x7fffffff = 2147483647
    // 0x80000000 = -2147483648
    // 0x80000001 = -2147483647
    // 0xffffffff = -1
    // >>，右移，用符号位补高位
    // >>>，无符号的右移，总是用0补高位
}