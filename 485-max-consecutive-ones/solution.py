class Solution(object):
    def findMaxConsecutiveOnes(self, nums):
        res = 0
        count = 0
        for num in nums:
            if num == 1:
                count += 1
                res = max(res, count)
            else:
                count = 0
        return res