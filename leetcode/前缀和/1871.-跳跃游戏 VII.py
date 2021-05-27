# 谨记：前缀和一定要注意区间的边界  
class Solution:
    def canReach(self, s: str, minJump: int, maxJump: int) -> bool:
        
        size = len(s)
        
        # dp[i] 表示 i 点是否可走
        dp = [0] * size
        # 表示dp的前缀和
        pre_sum = [0] * size
        
        dp[0] = 1
        pre_sum[0] = 1
        
        for i in range(1, size):
            if s[i] == "0":
                # 谨记：前缀和一定要注意区间的边界  
                reduce = 0
                if i - maxJump - 1 >= 0:
                    reduce = pre_sum[i - maxJump - 1]
                # 谨记：前缀和一定要注意区间的边界  
                acc = 0
                if i - minJump >= 0:
                    acc = pre_sum[i - minJump]
                if acc - reduce >= 1:
                    dp[i] = 1
            pre_sum[i] = pre_sum[i-1] + dp[i] 
        # print(dp, pre_sum)
        return dp[-1] == 1
    
    