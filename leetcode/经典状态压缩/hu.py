class Solution2:
    def is_hu(self, groups) -> int:
        # 数字种类为10种
        species = 10
        arr = [0] * species

        # 统计每一个牌的数量
        for val in groups:
            arr[val] += 1

        init_state = sum([arr[i] * species**i for i in range(1, species)])

        from functools import lru_cache

        @lru_cache(None)
        def dfs(state):
            if state == 0: return True
            for i in range(1, species + 1):
                num = state // (species**i) % species
                if num > 0:
                    if num >= 3 and dfs(state - species**i * 3):
                        return True
                    if state // (species**(i + 1)) % species > 0 and state // (
                            species**(i + 2)) % species > 0 and dfs(
                                state - species**i - species**(i + 1) -
                                species**(i + 2)):
                        return True
                    if state // (species**(i - 1)) % species > 0 and state // (
                            species**(i + 1)) % species > 0 and dfs(
                                state - species**i - species**(i + 1) -
                                species**(i - 1)):
                        return True
                    if state // (species**(i - 1)) % species > 0 and state // (
                            species**(i - 2)) % species > 0 and dfs(
                                state - species**i - species**(i - 1) -
                                species**(i - 2)):
                        return True
            return False

        for i in range(1, species):
            if arr[i] >= 2:
                state = init_state - 2 * species**i
                if dfs(state):
                    return True
        return False


if __name__ == '__main__':
    test = [[2, 2, 3, 4, 5],
            [4, 1, 6, 1, 2, 4, 7, 7, 4, 6, 5, 9, 3, 5, 3, 1, 8, 7, 3, 1, 5],
            [1, 1, 2, 3], [1, 2, 3, 6], [1, 2, 4, 5], [1, 3, 2, 4],
            [3, 3, 3, 4, 5, 6, 7], [1, 1, 2, 3, 4, 5, 6, 7, 8, 9],
            [1, 2, 2, 3, 4, 5, 6, 7, 8, 9], [1, 2, 2, 2, 3, 4, 5, 6, 7, 8],
            [1, 2, 3, 4, 4, 4, 5, 6, 7, 8], [1, 2, 3, 4, 4, 4, 5, 6, 6, 6, 7],
            [1, 1, 1, 1], [3, 3, 3, 4, 4, 4, 5], [3, 3, 3, 4, 5, 5, 5],
            [3, 3, 3, 4, 4, 5, 5], [1, 1, 1, 2, 3, 4, 5, 6, 7, 8, 9, 9, 9],
            [1, 1, 1, 2, 3, 4, 5, 6, 7, 8, 9, 9, 9],
            [1, 1, 1, 2, 3, 4, 5, 6, 7, 8, 9, 9, 9, 9],
            [1, 1, 1, 1, 2, 3, 4, 5, 6, 7, 8, 9, 9, 9],
            [
                1, 1, 1, 1, 2, 3, 4, 5, 6, 7, 8, 9, 9, 9, 1, 1, 1, 1, 2, 3, 4,
                5, 6
            ]]
    s = Solution2()
    for val in test:
        flag = False
        for i in range(1, 10):
            val.append(i)
            res = s.is_hu(val)
            val.pop()
            if res:
                flag = True
        if flag:
            print(val, flag)
