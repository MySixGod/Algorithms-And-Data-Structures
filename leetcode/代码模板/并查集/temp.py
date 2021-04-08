# 并查集是一种树形的数据结构，顾名思义，它用于处理一些不交集的 合并 及 查询 问题。 它支持两种操作
# 1.查找（Find）：确定某个元素处于哪个子集；
# 2.合并（Union）：将两个子集合并成一个集合。
class Solution:
    def equationsPossible(self, equations: List[str]) -> bool:

        father = {}

        def get_father(x):
            nonlocal father
            if x in father:
                if x == father[x]:
                    return x
                else:
                    # 路径压缩
                    father[x] = get_father(father[x])
                    return father[x]
            else:
                father[x] = x
                return x

        # 这里只是简单的合并
        # 在实际的使用中，还需要根据具体的场景选择是否使用 启发式合并（通过估值函数（常用节点个数进行估值）确定两颗子树谁挂到谁下面）
        # 路径压缩的缺点：单次合并可能造成大量修改，有时路径压缩并不适合使用
        # 例如，在可持久化并查集、线段树分治 + 并查集中，一般使用只启发式合并的并查集
        def union(x, y):
            nonlocal father
            x_f = get_father(x)
            y_f = get_father(y)
            father[x_f] = y_f

        # 判断是否属于同一个集合
        def is_same(x, y):
            return get_father(x) == get_father(y)

        return True
