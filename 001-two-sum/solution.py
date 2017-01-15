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

    # solution2
    def twoSum1(self, nums, target):
        if len(nums) <= 1:
            return [-1, -1]
        d = {}
        for i in range(len(nums)):
            if nums[i] in d:
                return [d[nums[i]], i]
            else:
                d[target-nums[i]] = i
        return [-1, -1]