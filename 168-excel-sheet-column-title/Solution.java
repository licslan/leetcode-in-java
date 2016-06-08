public class Solution {
    // recursion，这种方法直接拼接数组，效率非常低
    public String convertToTitle(int n) {
        return n == 0 ? "" : convertToTitle((n - 1) / 26) + (char) ('A' + (n - 1) % 26);
    }

    // iteration
    public String convertToTitle1(int n) {
        StringBuilder sb = new StringBuilder();
        while (n > 0) {
            n--;
            sb.insert(0, (char) ('A' + n % 26));
            n /= 26;
        }
        return sb.toString();
    }
}