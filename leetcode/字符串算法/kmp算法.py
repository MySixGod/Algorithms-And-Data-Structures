# 28. 实现 strStr()
# kmp算法
class Solution:
    def strStr(self, haystack: str, needle: str) -> int:
        # 参数检查
        if not needle: return 0
        if not haystack or len(haystack) < len(needle):
            return -1
        # 建立next数组
        size = len(needle)
        next = [0] * size

        for i in range(1, size):
            j = next[i - 1]
            while j > 0 and needle[i] != needle[j]:
                j = next[j - 1]
            if needle[i] == needle[j]: j += 1
            next[i] = j

        # print(next)
        # 开始匹配
        j = 0
        for i, val in enumerate(haystack):
            if val == needle[j]:
                j += 1
            else:
                # 状态重启
                while j > 0 and val != needle[j]:
                    j = next[j-1]
                if needle[j] == val:
                    j += 1
            if j == size:
                return i - j + 1

        return -1