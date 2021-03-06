public class Solution {
    public String addBinary(String a, String b) {
        int carry = 0;
        StringBuilder sb = new StringBuilder();
        int i = 0;
        int alen = a.length();
        int blen = b.length();
        while (i < alen || i < blen || carry != 0) {
            int x = (i < alen) ? ((a.charAt(alen - 1 - i) == '1') ? 1 : 0) : 0;
            int y = (i < blen) ? ((b.charAt(blen - 1 - i) == '1') ? 1 : 0) : 0;
            sb.insert(0, (x + y + carry) % 2);
            carry = (x + y + carry) / 2;
            i++;
        }
        return sb.toString();
    }
}