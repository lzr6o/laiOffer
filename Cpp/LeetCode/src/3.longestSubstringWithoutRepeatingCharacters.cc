#include "headers.h"

class Solution
{
public:
    int lengthOfLongestSubstring(string s)
    {
        int maxLen = 0;
        unordered_set<char> charSet;
        for (char c : s)
        {
            if (charSet.find(c) != charSet.end())
            {
                while (charSet.find(c) != charSet.end())
                {
                    charSet.erase(charSet.begin());
                }
            }
            else
            {
                charSet.insert(c);
                maxLen = max(maxLen, (int)charSet.size());
            }
        }
        return maxLen;
    };
};

TEST(longestSubStringWithoutRepeatingCharacters, longestSubStringWithoutRepeatingCharacters_1)
{
    Solution s;
    string str = "abcabcbb";
    int ans    = 3;
    EXPECT_EQ(s.lengthOfLongestSubstring(str), ans);
}

TEST(longestSubStringWithoutRepeatingCharacters, longestSubStringWithoutRepeatingCharacters_2)
{
    Solution s;
    string str = "bbbbb";
    int ans    = 1;
    EXPECT_EQ(s.lengthOfLongestSubstring(str), ans);
}

TEST(longestSubStringWithoutRepeatingCharacters, longestSubStringWithoutRepeatingCharacters_3)
{
    Solution s;
    string str = "pwwkew";
    int ans    = 3;
    EXPECT_EQ(s.lengthOfLongestSubstring(str), ans);
}

int main(int argc, char **argv)
{
    ::testing::InitGoogleTest(&argc, argv);

    return RUN_ALL_TESTS();
}