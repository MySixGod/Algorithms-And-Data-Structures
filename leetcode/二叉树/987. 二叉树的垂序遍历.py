# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
# 思路：直接遍历二叉树，求出每个节点的位置，排序
class Solution:
    def verticalTraversal(self, root: TreeNode) -> List[List[int]]:
        ls = []

        def dfs(root, col, line):
            if not root:
                return
            ls.append((col, line, root.val))
            dfs(root.left, col - 1, line + 1)
            dfs(root.right, col + 1, line + 1)

        dfs(root, 0, 0)
        ls.sort()
        min_col = ls[0][0]
        ans = []
        pos = 0
        while pos < len(ls):
            temp = []
            while pos < len(ls) and ls[pos][0] == min_col:
                temp.append(ls[pos][2])
                pos += 1
            ans.append(temp)
            min_col += 1
        return ans
