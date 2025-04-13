#include <iostream>
#include <map>
#include <ostream>
#include <vector>

using namespace std;

class TwoSum {
  public:
  vector<int> twoSum(vector<int> &nums, int target) {
    unordered_map<int, int> map;
    for (int i = 0; i < nums.size(); i++) {
      int left = target - nums[i];
      if (map.count(left)) {
        return {map[left], i};
      }
      map[nums[i]] = i;
    }
    return {};
  }
};

int main() {
  TwoSum lzr = TwoSum();
  vector<int> nums = {2, 7, 11, 15};
  int target = 9;
  vector<int> res = lzr.twoSum(nums, target);
  cout << "[" << res[0] << ", " << res[1] << "]" << endl;
  return 0;
}
