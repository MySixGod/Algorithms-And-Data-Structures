# 84. 柱状图中最大的矩形  单调栈 快速找到第一个比我大比我小的索引
class Solution:
    def largestRectangleArea(self, heights: List[int]) -> int:
        s = []
        left = []
        size = len(heights)
        for pos, val in enumerate(heights):
            if not s:
                s.append(pos)
                left.append(pos)
            else:
                while s and heights[s[-1]] >= val:
                    s.pop()
                if not s:
                    left.append(0)
                else:
                    left.append(s[-1]+1)
                s.append(pos)

        s = []
        right = []
        for i in range(size - 1, -1, -1):
            if not s:
                s.append(i)
                right.append(i)
            else:
                temp = i
                while s and heights[s[-1]] >= heights[i]:
                    s.pop()
                if not s:
                    right.append(size-1)
                else:
                    right.append(s[-1]-1)
                s.append(i)
        right = right[::-1]
        # print(left, right)
        ans = 0
        for pos, val in enumerate(heights):
            ans = max(ans, val * (right[pos] - left[pos] + 1))
        return ans
