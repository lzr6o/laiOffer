from typing import List, Any


class ListNode:
    def __init__(self, x):
        self.val = x
        self.next = None

    @staticmethod
    def build(arr: List[int]) -> Any:
        dummy = ListNode(0)
        cur = dummy
        for num in arr:
            cur.next = ListNode(num)
            cur = cur.next
        return dummy.next

    @staticmethod
    def print(head: Any) -> None:
        res = []
        cur = head
        while cur:
            res.append(str(cur.val))
            cur = cur.next
        print("->".join(res))
