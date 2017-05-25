# -*- coding:utf-8 -*-


class Solution(object):
    def arrayPairSum(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        return sum(sorted(nums)[::2])  # 列表中所有数，每两个取一个，且取前一个

if __name__ == '__main__':
    nums = [2, 3, 5, 1, 9, 7]
    print Solution().arrayPairSum(nums)

