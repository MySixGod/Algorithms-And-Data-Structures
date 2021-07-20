class Solution:
    def maxPoints(self, points: List[List[int]]) -> int:

        m = len(points)
        n = len(points[0])

        dp = [[0] * n for _ in range(m)]

        for j in range(n):
            dp[0][j] = points[0][j]

        for i in range(1, m):
            pre = [0] * n
            for j in range(n):
                pre[j] = max(pre[j - 1], dp[i - 1][j] + j)

            after = [0] * n
            after[-1] = dp[i - 1][n - 1] - j
            for j in range(n - 2, -1, -1):
                after[j] = max(after[j + 1], dp[i - 1][j] - j)

            for j in range(n):
                dp[i][j] = max(dp[i][j], pre[j] + points[i][j] - j,
                               after[j] + points[i][j] + j)

        return max(dp[m - 1])
