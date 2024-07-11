package leetcode;
class RemoveLinkedListElements {
	class ListNode {
		int value;
		ListNode next;
		ListNode(int value) {
			this.value = value;
			next = null;
		}
	}

	ListNode removeElements(ListNode head, int val) {
		ListNode dummy = new ListNode(0);
		dummy.next = head;
		ListNode prev = dummy;
		while (head != null) {
			if (head.value == val) {
				prev.next = head.next;
			} else {
				prev = head;
			}
			head = head.next;
		}
		return dummy.next;
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
	
	void printLinkedList(ListNode head) {
		while (head != null) {
			System.out.print(head.value + " ");
			head = head.next;
		}
	}

	public static void main(String[] args) {
		RemoveLinkedListElements lzr = new RemoveLinkedListElements();
		int val = 6;
		int[] array = { 1, 2, 6, 3, 4, 5, 6 };
		ListNode head = lzr.constructLinkedList(array);
		ListNode result = lzr.removeElements(head, val);
		lzr.printLinkedList(result);
	}
}