# 3. 电动车游城市  最短路算法
class Solution:
    def electricCarPlan(self, paths: List[List[int]], cnt: int, start: int,
                        end: int, charge: List[int]) -> int:
        graph = defaultdict(set)
        store = {}
        for x, y, z in paths:
            graph[x].add(y)
            graph[y].add(x)
            if (x, y) in store:
                store[(x, y)] = min(z, store[(x, y)])
                store[(y, x)] = min(z, store[(x, y)])
            else:
                store[(x, y)] = z
                store[(y, x)] = z

        walked = set()
        heap = [(0, start, 0)]

        while heap:
            cost, cur_city, cur_charge = heapq.heappop(heap)
            if cur_city == end:
                return cost
            if (cur_city, cur_charge) in walked:
                continue
            walked.add((cur_city, cur_charge))

            for i in range(cur_charge + 1, cnt + 1):
                heapq.heappush(
                    heap,
                    (cost + (i - cur_charge) * charge[cur_city], cur_city, i))

            for next_city in graph[cur_city]:
                need = store[(cur_city, next_city)]
                if cur_charge >= need:
                    heapq.heappush(heap,
                                   (cost + need, next_city, cur_charge - need))

        return float("inf")
