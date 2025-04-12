/**
* Definition for singly-linked list.
*/
#pragma once

#include <iostream>

using namespace std;

struct ListNode {
    int val;
    ListNode *next;
    ListNode() : val(0), next(nullptr) {}
    explicit ListNode(const int x) : val(x), next(nullptr) {}
    ListNode(const int x, ListNode *next) : val(x), next(next) {}
};

inline ListNode* build(vector<int> &arr) {
    auto *dummy = new ListNode(0, nullptr);
    ListNode *cur = dummy;
    for (int num : arr) {
        auto *node = new ListNode(num, nullptr);
        cur->next = node;
        cur = cur->next;
    }
    return dummy->next;
}

inline void print(const ListNode *head) {
    const ListNode *cur = head;
    while (cur->next != nullptr) {
        cout << cur->val << "->";
        cur = cur->next;
    }
    cout << cur->val << endl;
}
