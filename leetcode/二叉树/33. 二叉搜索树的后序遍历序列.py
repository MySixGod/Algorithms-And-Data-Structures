class Solution:
    def verifyPostorder(self, postorder: [int]) -> bool:
        size = len(postorder)
        def dfs(i, j):
            if i >= j: return True
            l = i
            while postorder[l] < postorder[j]:
                l += 1
            r = l
            while postorder[r] > postorder[j]:
                r += 1
            return r == j and dfs(i, l-1) and dfs(l, j-1)

        return dfs(0, size - 1)


class Solution:
    def verifyPostorder(self, postorder: [int]) -> bool:
        stack, root = [], float("+inf")
        for i in range(len(postorder) - 1, -1, -1):
            if postorder[i] > root: return False
            while(stack and postorder[i] < stack[-1]):
                root = stack.pop()
            stack.append(postorder[i])
        return True
