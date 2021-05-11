# 214. 最短回文串 -- 马拉车算法
class Solution:
    def shortestPalindrome(self, s: str) -> str:
        s = "#" + "#".join(s) + "#"
        size = len(s)
        # 回文串的中心index
        center = 0
        # 最大的回文串右边界
        max_right = -1
        # p[i] == 以s[i]为中心的最大回文串长度
        p = [0] * len(s)
        max_len = 0
        for i in range(len(s)):
            if i < max_right:
                mirror = 2 * center - i
                p[i] = min(max_right - i, p[mirror])

            l = i - (1 + p[i])
            r = i + (1 + p[i])

            while l >= 0 and r < size and s[l] == s[r]:
                p[i] += 1
                l -= 1
                r += 1
            
            # 如果探索到更大的右边界，则更新
            if i + p[i] > max_right:
                center = i
                max_right = i + p[i]

            if i == p[i]:
                max_len = max(max_len, p[i])
        s = s.replace("#", "")
        return s[max_len:][::-1] + s