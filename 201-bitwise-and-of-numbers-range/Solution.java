public class Solution {
    // TLE
    public int rangeBitwiseAnd(int m, int n) {
        int res = m;
        while(m<n){
            m++;
            res &=m;
        }
        return res;
    }

    // n>m时，低位会是0
    public int rangeBitwiseAnd1(int m, int n) {
        if (m == 0)
            return 0;
        int move = 1;
        while (m != n) {
            m >>= 1;
            n >>= 1;
            move <<= 1;
        }
        return m * move;
    }
}