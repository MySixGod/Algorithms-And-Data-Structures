# 经典动态规划 - 动态规划 一定要先写出 递归 准确的递归 方程
class Solution:
    def maxUncrossedLines(self, nums1: List[int], nums2: List[int]) -> int:
        # 检查输入参数
        size1 = len(nums1)
        size2 = len(nums2)

        # 初始状态定义
        dp = [[0] * size2 for _ in range(size1)]
        dp[0][0] = 1 if nums1[0] == nums2[0] else 0

        # 状态推导
        for i in range(size1):
            for j in range(size2):
                if i == 0 and j == 0:
                    continue
                if i == 0:
                    dp[i][j] = 1 if nums2[j] == nums1[i] else dp[i][j - 1]
                    continue
                if j == 0:
                    dp[i][j] = 1 if nums2[j] == nums1[i] else dp[i - 1][j]
                    continue
                dp[i][j] = max(dp[i - 1][j], dp[i][j - 1])
                if nums1[i] == nums2[j]:
                    dp[i][j] = max(dp[i][j], dp[i - 1][j - 1] + 1)

        # print(dp)
        return dp[size1 - 1][size2 - 1]
