import random


class SkipNode:
    def __init__(self, key, value: int = 1):
        self.key = key
        self.value = value
        self.right = None
        self.down = None


class Skiplist:
    def __init__(self):
        self.max_level = 8
        self.skip_pro = 0.5

        # 初始化每一层跳表的左右节点
        left = [SkipNode(float("-inf")) for _ in range(self.max_level)]
        right = [SkipNode(float("inf")) for _ in range(self.max_level)]
        self.head = left[0]

        for i in range(self.max_level):
            left[i].right = right[i]
            # 最后一层没有 down
            if i + 1 < self.max_level:
                left[i].down = left[i + 1]
                right[i].down = right[i + 1]

    def random_level(self):
        level = 1
        while random.random() < self.skip_pro and level < self.max_level:
            level += 1
        return level

    def search(self, target: int) -> bool:
        node = self.head
        while node:
            if target > node.right.key:
                node = node.right
            elif target < node.right.key:
                node = node.down
            else:
                return True
        return False

    def add(self, num: int) -> None:
        node = self.head
        path = []
        exist = None
        while node:
            if num < node.right.key:
                path.append(node)
                node = node.down
            elif num > node.right.key:
                node = node.right
            else:
                exist = node.right
                break
        if exist:
            while exist:
                exist.value += 1
                exist = exist.down
            return
        level = self.random_level()
        node_ls = [SkipNode(num) for _ in range(level)]

        for i in range(level - 1):
            node_ls[i].down = node_ls[i + 1]

        for i in range(1, level + 1):
            node_ls[-i].right = path[-i].right
            path[-i].right = node_ls[-i]

    def erase(self, num: int) -> bool:
        node = self.head
        del_ls = []
        exist = None
        while node:
            if num < node.right.key:
                node = node.down
            elif num > node.right.key:
                node = node.right
            else:
                if node.right.value > 1:
                    exist = node.right
                    break
                del_ls.append(node)
                node = node.down

        if exist:
            while exist:
                exist.value -= 1
                exist = exist.down
            return True

        for t_node in del_ls:
            t_node.right = t_node.right.right
        if del_ls:
            return True
        return False
