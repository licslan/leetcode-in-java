public class Solution {
    public int romanToInt(String s) {
        int res = 0;
        // 先把不符合下面规律的数数出来，比如 IV 4、IX 9 这种（罗马数字中 IV 只有可能出现一次）
        if (s.indexOf("IV") != -1)
            res -= 2;
        if (s.indexOf("IX") != -1)
            res -= 2;
        if (s.indexOf("XL") != -1)
            res -= 20;
        if (s.indexOf("XC") != -1)
            res -= 20;
        if (s.indexOf("CD") != -1)
            res -= 200;
        if (s.indexOf("CM") != -1)
            res -= 200;

        char[] c = s.toCharArray();

        for (char ch : c) {
            if (ch == 'I')
                res += 1;
            else if (ch == 'V')
                res += 5;
            else if (ch == 'X')
                res += 10;
            else if (ch == 'L')
                res += 50;
            else if (ch == 'C')
                res += 100;
            else if (ch == 'D')
                res += 500;
            else if (ch == 'M')
                res += 1000;
        }
        
        return res;
    }
}