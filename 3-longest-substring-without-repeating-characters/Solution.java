public class Solution {
    public int lengthOfLongestSubstring(String s) {
        if (s == null)
            return 0;
        char[] arr = s.toCharArray();
        int max = 0;

        HashMap<Character, Integer> map = new HashMap<Character, Integer>();

        for (int i = 0; i < arr.length; i++) {
            if (!map.containsKey(arr[i])) {
                map.put(arr[i], i);
            } else {
                max = Math.max(max, map.size());
                i = map.get(arr[i]);
                map.clear();
            }
        }

        return Math.max(max, map.size());
    }
}