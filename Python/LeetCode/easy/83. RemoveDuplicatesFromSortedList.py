from ListNode import ListNode

from typing import Optional


class Solution:
    def deleteDuplicates(self, head: Optional[ListNode]) -> Optional[ListNode]:
        cur = head
        while cur:
            while cur.next and cur.next.val == cur.val:
                cur.next = cur.next.next
            cur = cur.next
        return head


if __name__ == "__main__":
    sol = Solution()
    arr = [1, 1, 2, 3, 3]
    head = ListNode.build(arr)
    sol.deleteDuplicates(head)
    ListNode.print(head)
