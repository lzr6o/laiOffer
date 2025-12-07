class Solution:
    def smallestNumber(self, n: int) -> int:
        bit = 1
        while (n > res):
            res = (res << 1) | 1
        return res


if __name__ == "__main__":
    sol = Solution()
    n = 5
    res = sol.smallestNumber(n)
    print(res)
