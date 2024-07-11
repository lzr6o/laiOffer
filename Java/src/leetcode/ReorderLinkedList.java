package leetcode;
class ReorderLinkedList {
	class ListNode {
		int value;
		ListNode next;
		ListNode(int value) {
			this.value = value;
			next = null;
		}
	}

	ListNode reorder(ListNode head) {
		if (head == null || head.next == null) {
			return head;
		}
		ListNode mid = middleNode(head);
		ListNode one = head;
		ListNode two = mid.next;
		mid.next = null;
		return merge(one, reverse(two));
	}

	ListNode middleNode(ListNode head) {
		ListNode slow = head;
		ListNode fast = head;
		while (fast.next != null && fast.next.next != null) {
			slow = slow.next;
			fast = fast.next.next;
		}
		return slow;
	}
	
	ListNode reverse(ListNode head) {
		if (head == null || head.next == null) {
			return head;
		}
		ListNode prev = null;
		while (head != null) {
			ListNode next = head.next;
			head.next = prev;
			prev = head;
			head = next;
		}
		return prev;
	}
	
	ListNode merge(ListNode one, ListNode two) {
		ListNode dummy = new ListNode(0);
		ListNode cur = dummy;
		while (one != null && two != null) {
			cur.next = one;
			one = one.next;
			cur.next.next = two;
			two = two.next;
			cur = cur.next.next;
		}
		if (one != null) {
			cur.next = one;
		} else {
			cur.next = two;
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
		ReorderLinkedList lzr = new ReorderLinkedList();
		int[] array = { 1, 2, 3, 4 };
		ListNode head = lzr.constructLinkedList(array);
		ListNode result = lzr.reorder(head);
		lzr.printLinkedList(result);
	}
}