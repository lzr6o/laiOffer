package leetcode;
class ReverseLinkedListIterative {
	class ListNode {
		int value;
		ListNode next;
		ListNode(int value) {
			this.value = value;
			next = null;
		}
	}

	ListNode reverseLinkedList(ListNode head) {
		ListNode prev = null;
		while (head != null) {
			ListNode next = head.next;
			head.next = prev;
			prev = head;
			head = next;
		}
		return prev;
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
		ReverseLinkedListIterative lzr = new ReverseLinkedListIterative();
		int[] array = { 1, 2, 3 };
		ListNode head = lzr.constructLinkedList(array);
		ListNode result = lzr.reverseLinkedList(head);
		lzr.printLinkedList(result);
	}
}