package LeetCode.SwapNodesInPairs;

import LeetCode.ListNode.ListNode;

class SwapNodesInPairs {
	ListNode swapPairs(ListNode head) {
		if (head == null || head.next == null) {
			return head;
		}
		ListNode dummy = new ListNode(0);
		ListNode cur = dummy;
		dummy.next = head;
		while (cur.next != null && cur.next.next != null) {
			ListNode fir = cur.next;
			ListNode sec = cur.next.next;
			cur.next = sec;
			fir.next = sec.next;
			sec.next = fir;
			cur = cur.next.next;
		}
		return dummy.next;
	}

	public static void main(String[] args) {
		SwapNodesInPairs lzr = new SwapNodesInPairs();
		int[] nodes = { 1, 2, 3, 4 };
		ListNode list = ListNode.build(nodes);
		ListNode res = lzr.swapPairs(list);
		ListNode.print(res);
	}
}