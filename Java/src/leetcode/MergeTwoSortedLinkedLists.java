package leetcode;
class MergeTwoSortedLinkedLists {
	class ListNode {
		int value;
		ListNode next;
		ListNode(int value) {
			this.value = value;
			next = null;
		}
	}

	ListNode merge(ListNode one, ListNode two) {
		ListNode dummy = new ListNode(0);
		ListNode cur = dummy;
		while (one != null && two != null) {
			if (one.value <= two.value) {
				cur.next = one;
				one = one.next;
			} else {
				cur.next = two;
				two = two.next;
			}
			cur = cur.next;
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
		MergeTwoSortedLinkedLists lzr = new MergeTwoSortedLinkedLists();
		int[] first = { 1, 4, 6 };
		ListNode one = lzr.constructLinkedList(first);
		int[] second = { 2, 5 };
		ListNode two = lzr.constructLinkedList(second);
		ListNode result = lzr.merge(one, two);
		lzr.printLinkedList(result);
	}
}