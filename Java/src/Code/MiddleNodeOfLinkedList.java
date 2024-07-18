package Code;
class MiddleNodeOfLinkedList {
	class ListNode {
		int value;
		ListNode next;
		ListNode(int value) {
			this.value = value;
			next = null;
		}
	}

	ListNode findMiddle(ListNode head) {
		if (head == null) {
			return null;
		}
		ListNode slow = head;
		ListNode fast = head;
		while (fast.next != null && fast.next.next != null) {
			slow = slow.next;
			fast = fast.next.next;
		}
		return slow;
	}

	ListNode constructLinkedList(int[] array) {
		ListNode dummy = new ListNode(0);
		ListNode cur = dummy;
		for (int num : array) {
			ListNode node = new ListNode(num);
			cur.next = node;
			cur = cur.next;
		}
		return dummy.next;
	}

	public static void main(String[] args) {
		MiddleNodeOfLinkedList lzr = new MiddleNodeOfLinkedList();
		int[] array = { 1, 2, 3 };
		ListNode head = lzr.constructLinkedList(array);
		ListNode result = lzr.findMiddle(head);
		System.out.print(result.value);
	}
}