public class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        List<Integer> element = new ArrayList<Integer>();
        generate(result, element, nums, 0);
        return result;
    }

    private void generate(List<List<Integer>> result, List<Integer> element, int[] nums, int n) {
        if (n == nums.length) {
            result.add(element);
            return;
        }

        int size = element.size();
        for (int i = 0; i <= size; i++) {
            List<Integer> temp = new ArrayList<Integer>(element);
            temp.add(i, nums[n]);
            generate(result, temp, nums, n + 1);
        }
    }
}
