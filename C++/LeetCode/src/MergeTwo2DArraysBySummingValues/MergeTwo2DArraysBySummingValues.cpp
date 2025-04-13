#include <vector>
#include <iostream>

using namespace std;

class Solution {
public:
    vector<vector<int> > mergeArrays(vector<vector<int> > &nums1, vector<vector<int> > &nums2) {
        int ptr1 = 0, ptr2 = 0;
        int N1 = nums1.size(), N2 = nums2.size();
        vector<vector<int>> merged;
        while (ptr1 < N1 && ptr2 < N2) {
            if (nums1[ptr1][0] == nums2[ptr2][0]) {
                merged.push_back(
                    {nums1[ptr1][0], nums1[ptr1][1] + nums2[ptr2][1]});
                ptr1++;
                ptr2++;
            } else if (nums1[ptr1][0] < nums2[ptr2][0]) {
                merged.push_back(nums1[ptr1]);
                ptr1++;
            } else {
                merged.push_back(nums2[ptr2]);
                ptr2++;
            }
        }
        while (ptr1 < N1) {
            merged.push_back(nums1[ptr1]);
            ptr1++;
        }
        while (ptr2 < N2) {
            merged.push_back(nums2[ptr2]);
            ptr2++;
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
        cout << "[" << pair[0] << ", " << pair[1] << "] ";
    }
    return 0;
}
