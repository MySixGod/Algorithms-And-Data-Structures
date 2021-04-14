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




