# 1734. 解码异或后的排列
# 画图：先将数据的关系在本子画出来，更容易找到规律，更好解题
class Solution:
    def decode(self, encoded: List[int]) -> List[int]:
        n = len(encoded) + 1
        acc = 0
        for i in range(1, n+1):
            acc ^= i
        for i in range(1, len(encoded), 2):
            acc ^= encoded[i]
        ans = [acc]
        for val in encoded:
            ans.append(val ^ ans[-1])
        return ans


