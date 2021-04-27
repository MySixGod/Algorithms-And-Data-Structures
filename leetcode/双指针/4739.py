# 5739. 最高频元素的频数
# 输入数据范围
# 双指针解法
class Solution:
    def maxFrequency(self, nums: List[int], k: int) -> int:
        ls = sorted(list(Counter(nums).items()))
        size = len(ls)
        store_count = [0] * size
        store_acc = [0] * size
        store_count[0] = ls[0][1]
        store_acc[0] = ls[0][0] * ls[0][1]
        for pos in range(1, len(ls)):
            num, count = ls[pos]
            store_count[pos] = store_count[pos-1] + count
            store_acc[pos] = store_acc[pos-1] + num * count

        def get_pre_acc(i):
            if i < 0: return 0
            return store_acc[i]

        def get_pre_count(i):
            if i < 0: return 0
            return store_count[i]
            
        l = size - 2
        r = size - 1 
        ans = ls[0][1]
        while l >= 0:
            while l >= 0 and k >= ls[r][0] * (store_count[r] - get_pre_count(l-1)) - (store_acc[r] - get_pre_acc(l-1)):
                l -= 1
                continue
            if l < 0:
                ans = max(ans, store_count[r])
                break
            else:
                res = store_count[r] - store_count[l]
                rest = k - ls[r][0] * (store_count[r] - store_count[l]) + (store_acc[r] - store_acc[l])
                res += rest // (ls[r][0] - ls[l][0])
                ans = max(ans, res)
            r -= 1
        return ans