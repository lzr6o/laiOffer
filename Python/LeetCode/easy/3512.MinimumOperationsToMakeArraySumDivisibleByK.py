from typing import List


class Solution:
    def minOperations(self, nums: List[int], k: int) -> int:
        return sum(nums) % k


if __name__ == '__main__':
    sol = Solution()
    nums = [3, 9, 7]
    k = 5
    res = sol.minOperations(nums, k)
    print(res)
