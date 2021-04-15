# 263. 丑数
class Solution:
    def isUgly(self, n: int) -> bool:
        if n <= 0:
            return False

        @cache
        def dfs(x):
            if x == 1: 
                return True
            if x % 2 == 0 and dfs(x // 2):
                return True
            if x % 3 == 0 and dfs(x // 3):
                return True
            if x % 5 == 0 and dfs(x // 5):
                return True
            return False

        return dfs(n)


# 213. 打家劫舍 II
# dp[i] = max(nums[i] + dp[i-1][0], dp[i-1][1])
# 分两种情况， 第一间房子一定偷 或者不偷
class Solution:
    def rob(self, nums: List[int]) -> int:
        size = len(nums)
        if size == 1:
            return nums[0]
        dp = [[0, 0] for _ in range(size)]
        # 一定偷
        dp[0][1] = nums[0]
        dp[0][0] = float("-inf")
        for i in range(1, size):
            dp[i][1] = nums[i] + dp[i-1][0]
            dp[i][0] = max(dp[i-1][0], dp[i-1][1])
        ans = dp[size-1][0]
        # 一定不偷
        dp[0][1] = float("-inf")
        dp[0][0] = 0
        for i in range(1, size):
            dp[i][1] = nums[i] + dp[i-1][0]
            dp[i][0] = max(dp[i-1][0], dp[i-1][1])
        ans = max(ans, dp[size-1][0], dp[size-1][1])

        return ans

