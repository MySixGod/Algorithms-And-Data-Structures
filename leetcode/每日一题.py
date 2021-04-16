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
            dp[i][1] = nums[i] + dp[i - 1][0]
            dp[i][0] = max(dp[i - 1][0], dp[i - 1][1])
        ans = dp[size - 1][0]
        # 一定不偷
        dp[0][1] = float("-inf")
        dp[0][0] = 0
        for i in range(1, size):
            dp[i][1] = nums[i] + dp[i - 1][0]
            dp[i][0] = max(dp[i - 1][0], dp[i - 1][1])
        ans = max(ans, dp[size - 1][0], dp[size - 1][1])

        return ans


# 87. 扰乱字符串
# 判断 s2 是否是 s1 的扰乱字符串
class Solution:
    def isScramble(self, str1: str, str2: str) -> bool:
        ls1 = sorted(list(str1))
        ls2 = sorted(list(str2))
        if ls1 != ls2:
            return False

        @cache
        def dfs(s1, s2):
            # print(s1, s2)
            size = len(s1)
            if size == 1:
                return s1 == s2
            else:
                for i in range(1, size):
                    pre1 = sorted(list(s1[:i]))
                    pre2 = sorted(list(s2[:i]))
                    after = sorted(list(s2[-i:]))
                    if pre1 == pre2 and dfs(s1[:i], s2[:i]) and dfs(
                            s1[i:], s2[i:]):
                        return True
                    if pre1 == after and dfs(s1[:i], s2[size - i:]) and dfs(
                            s1[i:], s2[:size - i]):
                        return True
                return False

        return dfs(str1, str2)