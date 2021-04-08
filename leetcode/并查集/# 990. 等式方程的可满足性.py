# 990. 等式方程的可满足性
# 思路：并查集 将相等的变量 纳入 相同的集合， 不相等的变量不能属于同一个集合
class Solution:
    def equationsPossible(self, equations: List[str]) -> bool:
        if not equations:
            return True
        father = {}

        def get_father(x):
            nonlocal father
            if x in father:
                if x == father[x]:
                    return x
                else:
                    father[x] = get_father(father[x])
                    return father[x]
            else:
                father[x] = x
                return x

        def union(x, y):
            nonlocal father
            x_f = get_father(x)
            y_f = get_father(y)
            father[x_f] = y_f

        def is_same(x, y):
            return get_father(x) == get_father(y)

        for val in equations:
            if val[1:3] == "==":
                union(val[0], val[3])

        for val in equations:
            if val[1:3] == "!=":
                if is_same(val[0], val[3]):
                    return False
        return True

