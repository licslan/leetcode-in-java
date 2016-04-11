public class Solution {
    public int[] plusOne(int[] digits) {
        int length = digits.length - 1;
        while (length >= 0) {
            if (digits[length] == 9) {
                digits[length--] = 0;
            } else {
                digits[length]++;
                return digits;
            }
        }
        int[] res = new int[digits.length + 1];
        res[0] = 1;
        return res;
    }
}
