public class Solution {
    public int reverse(int x) {
        long res = 0;
		for (; x != 0; x /= 10) {
			res = res * 10 + x % 10;
		}
		return res > Integer.MAX_VALUE || res < Integer.MIN_VALUE ? 0: (int) res;//int x倒转过来可能会变成long，这时要强转一下
    }
}
