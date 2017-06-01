class Solution(object):
    def matrixReshape(self, nums, r, c):
        return matrix_reshape(nums, r, c)


def matrix_reshape(nums, r, c):
    """
    :type nums: List[List[int]]
    :type r: int
    :type c: int
    :rtype: List[List[int]]
    """
    flat = sum(nums, [])
    if r * c != len(flat):
        return nums

    tuples = zip(*([iter(flat)] * c))

    return map(list, tuples)
