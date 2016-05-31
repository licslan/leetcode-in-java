// 2个数组的交集，元素可以重复
public class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        List<Integer> list = new ArrayList<>();
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int i = 0, j = 0;
        while (i < nums1.length && j < nums2.length) {
            if (nums1[i] < nums2[j]) {
                i++;
            } else if (nums1[i] > nums2[j]) {
                j++;
            } else {
                list.add(nums1[i]);
                i++;
                j++;
            }
        }
        int[] nums = new int[list.size()];
        int k = 0;
        for (int num : list)
            nums[k++] = num;
        return nums;
    }

    // using HashMap，统计出现次数
    public int[] intersect1(int[] nums1, int[] nums2) {
        Map<Integer, Integer> map1 = new HashMap<>();
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < nums1.length; i++) {
            if (map1.containsKey(nums1[i]))
                map1.put(nums1[i], map1.get(nums1[i]) + 1);
            else
                map1.put(nums1[i], 1);
        }
        for (int i = 0; i < nums2.length; i++) {
            if (map1.containsKey(nums2[i]) && map1.get(nums2[i]) > 0) {
                list.add(nums2[i]);
                map1.put(nums2[i], map1.get(nums2[i]) - 1);
            }
        }
        int[] nums = new int[list.size()];
        int i = 0;
        for (int num : list)
            nums[i++] = num;
        return nums;
    }
}