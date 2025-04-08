#include <iostream>
#include <ostream>
#include <vector>

using namespace std;

class Solution {
public:
    vector<int> twoSum(vector<int>& nums, int target) {

    }
};

int main() {
    Solution sol = Solution();
    vector<int> nums = {2, 7, 11, 15};
    int target = 9;
    vector<int> res = sol.twoSum(nums, target);
    cout << "[" << res[0] << ", " << res[1] << "]" << endl;
    return 0;
}