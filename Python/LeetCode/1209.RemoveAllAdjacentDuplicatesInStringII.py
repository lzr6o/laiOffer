class Solution:
    def removeDuplicates(self, s: str, k: int) -> str:
        stack = []
        for c in s:
            if stack and stack[-1][0] == c:
                stack[-1][1] += 1
            else:
                stack.append([c, 1])
            if stack[-1][1] == k:
                stack.pop()
        res = ""
        for char, cnt in stack:
            res += char * cnt
        return res


if __name__ == "__main__":
    sol = Solution()
    s = "deeedbbcccbdaa"
    k = 3
    res = sol.removeDuplicates(s, k)
    print(res)
