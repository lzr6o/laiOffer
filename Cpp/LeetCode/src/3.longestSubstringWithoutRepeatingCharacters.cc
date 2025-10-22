#include "headers.h"

class Solution
{
public:
    int lengthOfLongestSubstring(string str)
    {
        int left   = 0;
        int maxLen = 0;
        unordered_set<char> seen;
        for (int right = 0; right < str.size(); right++)
        {
            char c = str[right];
            while (seen.find(c) != seen.end())
            {
                seen.erase(str[left]); // 删除窗口左端字符
                left++;
            }
            seen.insert(c);
            maxLen = max(maxLen, right - left + 1);
        }
        return maxLen;
    };
};

TEST(longestSubStringWithoutRepeatingCharacters, longestSubStringWithoutRepeatingCharacters_1)
{
    Solution sol;
    string str = "abcabcbb";
    int ans    = 3;
    EXPECT_EQ(sol.lengthOfLongestSubstring(str), ans);
}

TEST(longestSubStringWithoutRepeatingCharacters, longestSubStringWithoutRepeatingCharacters_2)
{
    Solution sol;
    string str = "bbbbb";
    int ans    = 1;
    EXPECT_EQ(sol.lengthOfLongestSubstring(str), ans);
}

TEST(longestSubStringWithoutRepeatingCharacters, longestSubStringWithoutRepeatingCharacters_3)
{
    Solution sol;
    string str = "pwwkew";
    int ans    = 3;
    EXPECT_EQ(sol.lengthOfLongestSubstring(str), ans);
}

int main(int argc, char **argv)
{
    ::testing::InitGoogleTest(&argc, argv);

    return RUN_ALL_TESTS();
}