#include <iostream>
#include <unordered_map>
#include <vector>

using namespace std;

class Solution {
  public:
  vector<int> findMissingAndRepeatedValues(vector<vector<int>> &grid) {
    int n = grid.size();
    int missing = -1, repeat = -1;
    unordered_map<int, int> freq;
    for (auto &row: grid) {
      for (int num: row) {
        freq[num]++;
      }
    }
    for (int num = 1; num <= n * n; num++) {
      if (!freq.count(num)) {
        missing = num;
      } else if (freq[num] == 2) {
        repeat = num;
      }
    }
    return {repeat, missing};
  }
};

int main() {
  Solution sol = Solution();
  vector<vector<int>> grid = {{1, 3}, {2, 2}};
  vector<int> res = sol.findMissingAndRepeatedValues(grid);
  cout << "[" << res[0] << ", " << res[1] << "]" << endl;
  return 0;
}
