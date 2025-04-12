#include <vector>
#include <iostream>

using namespace std;

class Solution {
public:
    vector<vector<int> > mergeArrays(vector<vector<int> > &nums1, vector<vector<int> > &nums2) {
        vector<vector<int> > merged;
        int Left = 0, Right = 0;
        while (Left < nums1.size() || Right < nums2.size()) {
            if (nums1[Left][0] < nums2[Right][0]) {
                merged.push_back({nums1[Left][0], nums1[Left][1]});
                Left++;
            } else if (nums1[Left][0] > nums2[Right][0]) {
                merged.push_back({nums2[Right][0], nums2[Right][1]});
                Right++;
            } else {
                merged.push_back({nums1[Left][0], nums1[Left][1] + nums2[Right][1]});
                Left++;
                Right++;
            }
        }
        return merged;
    }
};

int main() {
    Solution sol = Solution();
    vector<vector<int>> nums1 = {{2,4}, {3, 6}, {5,5}};
    vector<vector<int>> nums2 = {{1,3}, {4,3}};
    vector<vector<int> > merged = sol.mergeArrays(nums1, nums2);
    for (auto pair : merged) {
        cout << "[" << pair[0] << ", " << pair[1] << "], ";
    }
    return 0;
}
