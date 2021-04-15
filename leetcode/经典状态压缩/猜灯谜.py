# 1178. 猜字谜
# 返回一个答案数组 answer，数组中的每个元素 answer[i] 是在给出的单词列表 words 中
# 可以作为字谜迷面 puzzles[i] 所对应的谜底的单词数目。
# 思路：每个 字符串 都转成 2 进制
# 1 <= words.length <= 10^5
# 4 <= words[i].length <= 50
# 1 <= puzzles.length <= 10^4
# puzzles[i].length == 7
class Solution:
    def findNumOfValidWords(self, words: List[str],
                            puzzles: List[str]) -> List[int]:
        ans = []
        w_size = len(words)
        w_num = [0] * w_size
        p_size = len(puzzles)
        p_num = [0] * p_size
        offset = [2**i for i in range(26)]
        for i in range(w_size):
            w_num[i] = sum(offset[ord(val) - ord("a")]
                           for val in set(words[i]))
        for i in range(p_size):
            p_num[i] = sum(offset[ord(val) - ord("a")]
                           for val in set(puzzles[i]))
            count = 0
            first = [ord(puzzles[i][0]) - ord("a")]
            for pos, word in enumerate(words):
                if w_num[pos] // first % 2 and w_num[pos] & p_num[i] == w_num[
                        pos]:
                    count += 1
            ans.append(count)
        return ans


class Solution:
    def findNumOfValidWords(self, words: List[str],
                            puzzles: List[str]) -> List[int]:
        ans = []
        w_size = len(words)
        w_num = [0] * w_size
        p_size = len(puzzles)
        p_num = [0] * p_size
        offset = [2**i for i in range(26)]
        b_words = [[] for i in range(26)]
        for i in range(w_size):
            acc = 0
            for val in set(words[i]):
                acc += offset[ord(val) - ord("a")]
                b_words[ord(val) - ord("a")].append(i)
            w_num[i] = acc

        for i in range(p_size):
            p_num[i] = sum(offset[ord(val) - ord("a")]
                           for val in set(puzzles[i]))
            count = 0
            for pos in b_words[ord(puzzles[i][0]) - ord("a")]:
                if w_num[pos] & p_num[i] == w_num[pos]:
                    count += 1
            ans.append(count)
        return ans


class Solution:
    def findNumOfValidWords(self, words: List[str],
                            puzzles: List[str]) -> List[int]:

        ans = []
        w_size = len(words)
        w_num = defaultdict(int)
        p_size = len(puzzles)
        p_num = [0] * p_size
        offset = [2**i for i in range(26)]
        b_words = [[] for i in range(26)]
        for i in range(w_size):
            key = sum(offset[ord(val) - ord("a")] for val in set(words[i]))
            w_num[key] += 1

        b_ls = sorted(list(w_num.keys()))
        store = {}
        for i in range(p_size):
            p_num[i] = sum(offset[ord(val) - ord("a")]
                           for val in set(puzzles[i]))

            count = 0
            first = offset[ord(puzzles[i][0]) - ord("a")]
            if (first, p_num[i]) in store:
                ans.append(count)
                continue
            # 因为 word 是 puzzle 的子集，所以word 一定小于 p_num[i], 二分查找优化
            index = bisect_right(b_ls, p_num[i])
            for num in b_ls[:index]:
                if num // first % 2 and num & p_num[i] == num:
                    count += w_num[num]
            ans.append(count)
            store[(first, p_num[i])] = count
        return ans


class Solution:
    def findNumOfValidWords(self, words: List[str],
                            puzzles: List[str]) -> List[int]:

        ans = []
        w_size = len(words)
        w_num = defaultdict(int)
        offset = [2**i for i in range(26)]
        for i in range(w_size):
            key = sum(offset[ord(val) - ord("a")] for val in set(words[i]))
            w_num[key] += 1

        store = {}
        for i in range(len(puzzles)):

            # first 必须有，其他可有可无
            first = offset[ord(puzzles[i][0]) - ord("a")]
            count = w_num[first]
            t_ls = [offset[ord(val) - ord("a")] for val in puzzles[i][1:]]
            from itertools import combinations
            for i in range(1, 7):
                sub_ls = combinations(t_ls, i)
                for v in sub_ls:
                    count += w_num[first + sum(v)]
            ans.append(count)
        return ans
