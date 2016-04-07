public class Solution {
// 	public int lengthOfLastWord(String s) {
// 		if (s.trim().equals("") || s.length() == 0) return 0;
// 		String[] ss = s.trim().split(" ");
// 		int len = ss.length;
// 		return ss[len - 1].length();
// 	}

    public int lengthOfLastWord(String s) {
		int len = s.length();
		if(len == 0) return 0;
		int sum = 0;
		while (s.charAt(len - 1) == ' ' && len > 1)
			len--;
		for (int i = len - 1; i >= 0; i--) {
			if (s.charAt(i) != ' ')
				sum++;
			else
				break;
		}
		return sum;
	}
}
