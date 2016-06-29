public class Solution {
    public boolean isUgly(int num) {
        for (int i = 2; i <= 5 && num > 0; i++) {// num的输入可能为0
            while (num % i == 0)
                num /= i;
        }
        return num == 1;
    }
}