public class Solution {
    public int findComplement(int num) {
        long i = 1;// int的话可能溢出
        while (i <= num)
            i = i << 1;
        return (int) (i - 1) ^ num;
    }
}