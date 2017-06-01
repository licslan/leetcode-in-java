# -*- coding:utf-8 -*-


class Solution(object):
    def reverseWords(self, s):
        return reverse_words(s)


def reverse_words(s):
    """
    :type s: str
    :rtype: str
    """
    # join()拼接string list的string元素
    # x[::-1]这种方式可以将string逆序（从最后一个元素开始逆向处理，处理全部元素）
    return ' '.join(map(lambda x: x[::-1], s.split()))
