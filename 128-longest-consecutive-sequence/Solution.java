// 此题元素可以重复
public class Solution {

    // O(nlgn) solution
    public int longestConsecutive1(int[] nums) {
        Arrays.sort(nums);
        int max = 0, count = 1;
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i + 1] == nums[i] + 1)
                count++;
            else if (nums[i + 1] == nums[i])
                continue;
            else {
                max = Math.max(max, count);
                count = 1;
            }
        }
        return Math.max(max, count);
    }

    // O(n) solution，借助HashSet查找时间O(1)
    public int longestConsecutive(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for (int num : nums) set.add(num);
        int max = 0;
        for (int num : nums) {
            if (set.remove(num)) { //如果set中有这个元素，将其remove并返回true，否则返回false
                int count = 1;
                int val = num;
                while (set.remove(val - 1))
                    val--;
                count += num - val;
                val = num;
                while (set.remove(val + 1))
                    val++;
                count += val - num;
                max = Math.max(max, count);
            }
        }
        return max;
    }
}