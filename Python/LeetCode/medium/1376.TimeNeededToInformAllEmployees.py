from collections import deque
from collections import defaultdict
from typing import List


class Solution:
    def numOfMinutes(self, n: int, headID: int, manager: List[int], informTime: List[int]) -> int:
        adj = defaultdict(list)  # Mgr -> [list of emps]
        for i in range(n):
            adj[manager[i]].append(i)

        # BFS
        q = deque([(headID, 0)])  # (id, time)
        res = 0
        while q:
            i, time = q.popleft()
            res = max(res, time)
            for emp in adj[i]:
                q.append((emp, time + informTime[i]))
        return res


if __name__ == "__main__":
    sol = Solution()
    n = 6
    headID = 2
    manager = [2, 2, -1, 2, 2, 2]
    informTime = [0, 0, 1, 0, 0, 0]
    res = sol.numOfMinutes(n, headID, manager, informTime)
    print(res)
