#include "listnode.h"

namespace LeetCode
{
void print_list(ListNode *head)
{
    while (head != nullptr)
    {
        std::cout << head->val;
        if (head->next != nullptr)
            std::cout << "->";
        head = head->next;
    }
    std::cout << std::endl;
}

bool is_same_list(ListNode *l1, ListNode *l2)
{
    std::cout << "l1 : ";
    print_list(l1);
    std::cout << "l2 : ";
    print_list(l2);

    while (l1 != nullptr && l2 != nullptr && l1->val == l2->val)
    {
        l1 = l1->next;
        l2 = l2->next;
    }
    return l1 == l2 ? true : false;
}

List::List()
{
    this->head = nullptr;
}

List::List(std::initializer_list<int> l) : head(nullptr), tail(nullptr)
{
    for (auto it : l)
        insert(it);
}

List::~List()
{
    if (!m_release)
        return;
    ListNode *del_p = nullptr;
    while (head != nullptr)
    {
        del_p = head->next;
        delete head;
        head = del_p;
    }
    delete head;
}

void List::insert(int x)
{
    if (head == nullptr)
        head = tail = new ListNode(x);
    else
    {
        ListNode *p = new ListNode(x);
        tail->next  = p;
        tail        = p;
        tail->next  = nullptr;
    }
}

void List::print()
{
    print_list(this->head);
}

void List::setRelease(bool release)
{
    m_release = release;
}

bool List::operator==(const List &l1) const
{
    return is_same_list(this->head, l1.head);
}
} // namespace LeetCode