# 72. 编辑距离 将字符串A 转换为B
# 1. 插入一个字符
# 2. 删除一个字符
# 3. 替换一个字符
class Solution:
    def minDistance(self, word1: str, word2: str) -> int:
        if word1 == word2:
            return 0
        size1 = len(word1)
        size2 = len(word2)
        if not word1 or not word2:
            return max(size1, size2)

        dp = [[0] * (size2 + 1) for _ in range(size1 + 1)]

        for i in range(size1 + 1):
            for j in range(size2 + 1):
                if i == 0 or j == 0:
                    dp[i][j] = max(i, j)
                else:
                    if word1[i - 1] == word2[j - 1]:
                        dp[i][j] = dp[i - 1][j - 1]
                    else:
                        dp[i][j] = min(dp[i - 1][j - 1], dp[i - 1][j],
                                       dp[i][j - 1]) + 1
        return dp[size1][size2]








