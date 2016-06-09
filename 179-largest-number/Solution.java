public class Solution {
    public String largestNumber(int[] nums) {
        if (nums == null || nums.length == 0)
            return "0";

        String[] str = new String[nums.length];

        for (int i = 0; i < nums.length; i++)
            str[i] = nums[i] + "";

        Comparator<String> comp = new Comparator<String>() {

            @Override
            public int compare(String str1, String str2) {
                String s1 = str1 + str2;
                String s2 = str2 + str1;
                return s1.compareTo(s2);
            }
        };

        Arrays.sort(str, comp);// 高位排在数组的后面
        // 注意0的情况
        if (str[nums.length - 1].charAt(0) == '0')// 这个地方的0注意，不是数组是字符
            return "0";

        StringBuilder sb = new StringBuilder();
        for (String s : str)
            sb.insert(0, s);
        return sb.toString();
    }
}