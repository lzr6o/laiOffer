package leetcode;

class AddTwoNumbers {
	ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		ListNode dummy = new ListNode(0);
		ListNode cur = dummy;
		int val = 0;
		while (l1 != null || l2 != null || val != 0) {
			if (l1 != null) {
				val += l1.val;
				l1 = l1.next;
			}
			if (l2 != null) {
				val += l2.val;
				l2 = l2.next;
			}
			cur.next = new ListNode(val % 10);
			val = val / 10;
			cur = cur.next;
		}
		return dummy.next;
	}

	public static void main(String[] args) {
		AddTwoNumbers lzr = new AddTwoNumbers();
		int[] fir = { 2, 4, 3 };
		ListNode a = ListNode.build(fir);
		ListNode.print(a);
		int[] sec = { 5, 6, 4 };
		ListNode b = ListNode.build(sec);
		ListNode.print(b);
		ListNode res = lzr.addTwoNumbers(a, b);
		ListNode.print(res);
	}
}