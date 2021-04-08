class Solution:
    def countRangeSum(self) -> int:
        nums = []
        # tree 可以选用 字典或者 数组
        tree = {}
        # 区间的边界
        max_sum = len(nums)

        def lowbit(x):
            return x & (-x)

        def update(x):
            while x <= max_sum:
                tree[x] = tree.get(x, 0) + 1
                x = x + lowbit(x)

        def get_num(x):
            if x < 0:
                return 0
            while x > 0:
                ans += tree.get(x, 0)
                x = x - lowbit(x)
            return ans

        # 建树
        def init_tree:
            for i in range(1, len(nums) + 1):
                tree[i] += nums[i-1]
                j = i + lowbit(i)
                if j <= len(nums):
                    tree[j] += tree[i]



