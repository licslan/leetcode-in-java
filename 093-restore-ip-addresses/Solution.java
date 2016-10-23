public class Solution {
    List<String> restoreIpAddresses(String s) {
        List<String> ans = new ArrayList<String>();
        int len = s.length();
        // 第一次划分
        for (int i = 1; i <= 3; ++i) {
            if (len - i > 9)
                continue;
            // 第二次划分
            for (int j = i + 1; j <= i + 3; ++j) {
                if (len - j > 6)
                    continue;
                // 第三次划分
                for (int k = j + 1; k <= j + 3 && k < len; ++k) {
                    // IP地址的4段
                    int a, b, c, d;
                    // "01"会被转为1，在下面解决
                    a = Integer.parseInt(s.substring(0, i));
                    b = Integer.parseInt(s.substring(i, j));
                    c = Integer.parseInt(s.substring(j, k));
                    d = Integer.parseInt(s.substring(k));
                    if (a > 255 || b > 255 || c > 255 || d > 255)
                        continue;
                    String ip = a + "." + b + "." + c + "." + d;
                    // 排除从"01"转为"1","00"转为"0"这种子串
                    if (ip.length() < len + 3)
                        continue;
                    ans.add(ip);
                }
            }
        }
        return ans;
    }
}