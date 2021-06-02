class Solution:
    def checkSubarraySum(self, nums: List[int], k: int) -> bool:

        acc = 0
        # 前缀和 一定要注意边界
        store = {0:-1}

        for pos, val in enumerate(nums):
            acc += val
            tar = acc % k
            if tar in store:
                if pos > store[tar] + 1:
                    return True
            else:
                store[tar] = pos
        return False

