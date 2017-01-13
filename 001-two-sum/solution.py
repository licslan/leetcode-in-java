class Solution(object):
    def twoSum(self, nums, target):
        """
        :type nums: List[int]
        :type target: int
        :rtype: List[int]
        """
        i = 0
        d = dict()
        for num in nums:
            d[num] = i
            i = i + 1

        i = 0
        for num in nums:
            if d.has_key(target-num) and d[target-num] != i:
                return [i, d[target-num]]
            i = i + 1
        return [-1, -1]
