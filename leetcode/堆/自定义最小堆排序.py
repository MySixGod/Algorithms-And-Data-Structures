# 692. 前K个高频单词
# 自定义 最小堆的排序规则， 模板题
class Word:
    def __init__(self, freq, word):
        self.freq = freq
        self.word = word

    def __lt__(self, other):
        if self.freq == other.freq:
            return self.word > other.word
        return self.freq < other.freq

class Solution:
    def topKFrequent(self, words: List[str], k: int) -> List[str]:

        s = Counter(words)

        min_heap = []
        for word, freq in s.items():
            heapq.heappush(min_heap, Word(freq, word))
            if len(min_heap) > k:
                heapq.heappop(min_heap)

        res = []
        for i in range(k):
            res.append((heapq.heappop(min_heap)).word)
        res.reverse()
        return res