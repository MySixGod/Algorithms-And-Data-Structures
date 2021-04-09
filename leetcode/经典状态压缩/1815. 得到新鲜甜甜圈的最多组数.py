# 
class Solution:
    def maxHappyGroups(self, batchSize: int, groups: List[int]) -> int:
        @cache
        def dfs(cur, rest):
            res = 0
            for i in range(1, batchSize):
                if rest // (31**i) % 31 > 0:
                    res = max(res, (cur == 0) + dfs(
                        (cur + i) % batchSize, rest - 31**i))
            return res

        arr = [0] * batchSize
        for val in groups:
            arr[val % batchSize] += 1
        init_state = sum([arr[i] * 31**i for i in range(1, batchSize)])
        return arr[0] + dfs(0, init_state)
