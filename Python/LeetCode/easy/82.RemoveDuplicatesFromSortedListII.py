from typing import Optional

from ListNode import ListNode


class Solution:
    def deleteDuplicates(self, head: Optional[ListNode]) -> Optional[ListNode]:
        if not head or not head.next:
            return head
        dummy = ListNode(0)
        dummy.next = head
        cur = dummy
        while cur.next and cur.next.next:
            if cur.next.val == cur.next.next.val:
                dup = cur.next.val
                while cur.next and cur.next.val == dup:
                    cur.next = cur.next.next
            else:
                cur = cur.next
        return dummy.next


if __name__ == "__main__":
    sol = Solution()
    arr = [1, 2, 3, 3, 4, 4, 5]
    head = ListNode.build(arr)
    sol.deleteDuplicates(head)
    ListNode.print(head)
