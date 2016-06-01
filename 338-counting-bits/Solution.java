public class Solution {
    // 循环每个数，通过位运算计算1的位数
    public int[] countBits(int num) {
        int[] arr = new int[num+1];
        for (int i = 0; i <= num; i++) {
            int j = i;
            while(j!=0){
                arr[i] += j&1;
                j = j>>1;
            }
        }
        return arr;
    }

    // DP Solution
    public int[] countBits1(int num) {
        int[] arr = new int[num + 1];
        arr[0] = 0;
        for (int i = 1; i < num + 1; i++) {
            // 当arr[i]为奇数时，最后一位为1，arr[i-1]的最后一位为0，其他为与arr[i]一样，arr[i]=arr[i-1]
            // 当arr[i]为偶数时，最后一位为0，其右移一位与其1的个数相同，所以arr[i]=arr[i/2]
            arr[i] = (i % 2 == 0) ? arr[i / 2] : arr[i - 1] + 1;
        }
        return arr;
    }
}