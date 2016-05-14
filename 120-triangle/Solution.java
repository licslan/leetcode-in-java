public class Solution {
    // DP solution
    public int minimumTotal(List<List<Integer>> triangle) {
        // sum[i]表示以最后一层第i个点结束的最短路径
        int[] sum = new int[triangle.size()];
        sum[0] = triangle.get(0).get(0);
        int min = Integer.MAX_VALUE;
        for (int i = 1; i < triangle.size(); i++) {
            List<Integer> row = triangle.get(i);
            for (int j = i; j >= 0; j--) {
                int val = row.get(j);
                if (j == 0)
                    sum[j] += val;
                else if (j == i)
                    sum[j] += sum[j - 1] + val;
                else
                    sum[j] = Math.min(sum[j], sum[j - 1]) + val;
            }
        }
        for (int num : sum)
            min = Math.min(min, num);
        return min;
    }
}