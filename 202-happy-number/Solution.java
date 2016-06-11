public class Solution {
    public boolean isHappy(int n) {
        int fast = n, slow = n;
        do {
            slow = digitSquareSum(slow);
            fast = digitSquareSum(fast);
            fast = digitSquareSum(fast);
        } while (slow != fast);// do...while，while后面有分号
        if (slow == 1)
            return true;
        return false;

    }

    private int digitSquareSum(int n) {
        int sum = 0;
        while (n != 0) {
            int digit = n % 10;
            sum += digit * digit;
            n /= 10;
        }
        return sum;
    }
}