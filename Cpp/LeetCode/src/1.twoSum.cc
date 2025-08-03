#include "headers.h"

class Solution
{
public:
    vector<int> twoSum(vector<int> &nums, int target)
    {
        unordered_map<int, int> map;
        for (int i = 0; i < nums.size(); i++)
        {
            int left = target - nums[i];
            if (map.count(left))
            {
                return {map[left], i};
            }
            map[nums[i]] = i;
        }
        return {};
    }
};

TEST(twoSum, twoSum_1)
{
    Solution s;
    vector<int> nums = {2, 7, 11, 15};
    int target       = 9;
    vector<int> ans  = {0, 1};
    EXPECT_EQ(s.twoSum(nums, target), ans);
}

TEST(twoSum, twoSum_2)
{
    Solution s;
    vector<int> nums = {3, 2, 4};
    int target       = 6;
    vector<int> ans  = {1, 2};
    EXPECT_EQ(s.twoSum(nums, target), ans);
}

TEST(twoSum, twoSum_3)
{
    Solution s;
    vector<int> nums = {3, 3};
    int target       = 6;
    vector<int> ans  = {0, 1};
    EXPECT_EQ(s.twoSum(nums, target), ans);
}

int main(int argc, char **argv)
{
    ::testing::InitGoogleTest(&argc, argv);

    return RUN_ALL_TESTS();
}