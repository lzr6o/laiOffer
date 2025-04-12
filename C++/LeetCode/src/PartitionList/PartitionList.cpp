#include "list/ListNode.h"
#include <iostream>

using namespace std;

class Solution {
public:
    ListNode *partition(ListNode *head, int x) {
        auto *left = new ListNode(0);
        ListNode *curL = left;
        auto *right = new ListNode(0);
        ListNode *curR = right;
        while (head != nullptr) {
            if (head->val < x) {
                curL->next = head;
                curL = curL->next;
            } else {
                curR->next = head;
                curR = curR->next;
            }
            head = head->next;
        }
        curR->next = nullptr;
        curL->next = right->next;
        return left->next;
    }
};

int main() {
    Solution sol = Solution();
    vector<int> arr = {1, 4, 3, 2, 5, 2};
    ListNode *head = build(arr);
    int x = 3;
    ListNode *res = sol.partition(head, x);
    print(res);
    return 0;
}
