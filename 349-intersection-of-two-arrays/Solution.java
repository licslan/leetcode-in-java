// 找两个数组的交集，unique
public class Solution {
    // using 2 HashSet
    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> set1 = new HashSet<>();
        Set<Integer> res = new HashSet<>();
        for (int num : nums1)
            set1.add(num);
        for (int num : nums2)
            if (set1.contains(num))
                res.add(num);
        int[] nums = new int[res.size()];
        int i = 0;
        for (int num : res)
            nums[i++] = num;
        return nums;
    }

    // using 2 pointer
    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> set = new HashSet<>();
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int i = 0, j = 0;
        while (i < nums1.length && j < nums2.length) {
            if (nums1[i] < nums2[j]) {
                i++;
            } else if (nums1[i] > nums2[j]) {
                j++;
            } else {
                set.add(nums1[i]);
                i++;
                j++;
            }
        }
        int[] nums = new int[set.size()];
        int k = 0;
        for (int num : set)
            nums[k++] = num;
        return nums;
    }
}