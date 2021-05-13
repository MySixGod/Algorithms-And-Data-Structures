# 技巧：使用前缀和的时候，可以 增加哨兵，这样可以很好的处理边界条件，减少代码的复杂度
class Solution:
    def xorQueries(self, arr: List[int],
                   queries: List[List[int]]) -> List[int]:
        arr = [0] + arr
        pre = [0] * len(arr)
        for i in range(1, len(arr)):
            pre[i] = arr[i] ^ pre[i - 1]

        ans = []
        for x, y in queries:
            ans.append(pre[y + 1] ^ pre[x])
        return ans


