# 1011. 在 D 天内送达包裹的能力
# 二分算法
class Solution:
    def shipWithinDays(self, weights: List[int], D: int) -> int:
        l = max(weights)
        # 优化细节： 尽可能缩减 二分算法的左右边界
        r = l * len(weights) // D
        ans = r            
        while l <= r:
            mid = l + (r - l) // 2
            cur = 0
            day = 1
            for val in weights:
                if cur + val <= mid:
                    cur += val
                else:
                    day += 1
                    cur = val
            if day > D:
                l = mid + 1
            else:
                ans = mid
                r = mid - 1
        return ans