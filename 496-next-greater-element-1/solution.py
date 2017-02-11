class Solution(object):
    def nextGreaterElement(self, findNums, nums):
        """
        :type findNums: List[int]
        :type nums: List[int]
        :rtype: List[int]
        """
        map, stack = {}, []  # using list as a stack
        # stack里面存的都是暂时没有找到next greater element的元素
        for num in nums:
            while stack and stack[-1] < num:
                map[stack.pop()] = num
            stack.append(num)
        res = []
        for num in findNums:
            res.append(map.get(num, -1))
        return res