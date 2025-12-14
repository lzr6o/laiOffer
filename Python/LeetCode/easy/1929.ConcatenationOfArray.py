from typing import List


class Solution:
    def getConcatenation(self, nums: List[int]) -> List[int]:
        return nums * 2


if __name__ == '__main__':
    sol = Solution()
    nums = [1, 2, 3]
    res = sol.getConcatenation(nums)
    print(res)
