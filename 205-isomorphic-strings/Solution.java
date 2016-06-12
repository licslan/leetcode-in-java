public class Solution {
    // 记录字符最后一次出现的位置
    public boolean isIsomorphic(String s, String t) {
        int[] pos1 = new int[256];
        int[] pos2 = new int[256];
        for (int i = 0; i < s.length(); i++) {
            if (pos1[s.charAt(i)] != pos2[t.charAt(i)])
                return false;
            pos1[s.charAt(i)] = pos2[t.charAt(i)] = i + 1;
        }
        return true;
    }
}