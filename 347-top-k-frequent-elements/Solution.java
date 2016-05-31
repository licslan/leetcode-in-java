// 统计出现频率前k的元素，思路类似桶排序，O(n)
public class Solution {
    public static List<Integer> topKFrequent(int[] nums, int k) {
        // 借助HashMap统计每个元素出现的次数
        Map<Integer, Integer> countMap = new HashMap<>();
        for (int num : nums) {
            if (countMap.containsKey(num))// 这里不要把num写成nums了
                countMap.put(num, countMap.get(num) + 1);
            else
                countMap.put(num, 1);
        }

        // 将元素入桶，桶的编号为出现的次数
        // 即出现i次的元素放入i号桶，桶由数组＋链表实现，已经排好序
        // 同一个次数可能对对应几个元素，每一个桶是一个List
        List<Integer>[] buckets = new List[nums.length];
        for (int key : countMap.keySet()) {
            int count = countMap.get(key);
            if (buckets[count - 1] == null)
                buckets[count - 1] = new ArrayList<>();
            buckets[count - 1].add(key);
        }

        List<Integer> res = new ArrayList<>();
        for (int pos = buckets.length - 1; res.size() < k; pos--)
            if (buckets[pos] != null)
                res.addAll(buckets[pos]);
        return res;
    }
}