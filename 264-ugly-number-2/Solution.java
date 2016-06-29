public class Solution {
    // DP
    public int nthUglyNumber(int n) {
        if (n <= 0)
            return 0;
        int a = 0, b = 0, c = 0;
        int[] res = new int[n];
        res[0] = 1;
        for (int i = 1; i < n; i++) {
            int next = Math.min(res[a] * 2, Math.min(res[b] * 3, res[c] * 5));
            res[i] = next;
            if (res[a] * 2 == next) a++;
            if (res[b] * 3 == next) b++;
            if (res[c] * 5 == next) c++;
        }
        return res[n - 1];
    }
}