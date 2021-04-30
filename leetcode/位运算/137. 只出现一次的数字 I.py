# 137. 只出现一次的数字 II
# o(1) 的空间 还是要的
class Solution:
    def singleNumber(self, nums: List[int]) -> int:
        num = 0
        for i in range(32):
            t = 0
            for val in nums:
                if (1 << i) & val:
                    t += 1
            if t % 3 > 0:
                num |= (1 << i)
        return num if num < 2 ** 31 else ~(num ^ 0xffffffff) 