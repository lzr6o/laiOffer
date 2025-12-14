from itertools import combinations


class Solution:
    def largestTriangleArea(self, points: list[list[int]]) -> float:
        return max(0.5 * abs(i[0] * j[1] + j[0] * k[1] + k[0] * i[1] - j[0] * i[1] - k[0] * j[1] - i[0] * k[1])
                   for i, j, k in combinations(points, 3))


if __name__ == "__main__":
    sol = Solution()
    points = [[0, 0], [0, 1], [1, 0], [0, 2], [2, 0]]
    res = sol.largestTriangleArea(points)
    print(res)
