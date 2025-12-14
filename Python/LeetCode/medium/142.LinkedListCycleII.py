from typing import Optional

import ListNode


class Solution:
    def detectCycle(self, head: Optional[ListNode]) -> Optional[ListNode]:
        slow = fast = head
        while fast and fast.next:
            fast = fast.next.next
            slow = slow.next
            if fast == slow:
                break
        else:
            return None
        fast = head
        while fast != slow:
            fast = fast.next
            slow = slow.next
        return fast


if __name__ == "__main__":
    sol = Solution()
