public class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        // 将值作为key，索引作为value
        for (int i = 0; i < nums.length; ++i)
            map.put(nums[i], i);

        for (int i = 0; i < nums.length; ++i) {
            // 题目中有个条件：you may not use the same element twice
            if (map.containsKey(target - nums[i]) && (map.get(target - nums[i]) != i))
                return new int[]{i, map.get(target - nums[i])};
        }

        return new int[]{-1, -1};
    }
}