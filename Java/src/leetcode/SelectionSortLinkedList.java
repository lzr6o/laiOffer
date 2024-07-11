package leetcode;
class SelectionSortLinkedList {
	class ListNode {
		int value;
		ListNode next;

		ListNode(int value) {
			this.value = value;
			next = null;
		}
	}

	ListNode selectionSort(ListNode head) {
		if (head == null) {
			return head;
		}
		ListNode min = head;
		ListNode minPre = null;
		ListNode cur = head;
		while (cur.next != null) {
			if (cur.next.value < min.value) {
				min = cur.next; 
				minPre = cur;
			}
			cur = cur.next;
		}
		if (minPre != null) {
			minPre.next = min.next;
		}
		if (min == head) {
			min.next = selectionSort(head.next);
		} else {
			min.next = selectionSort(head);
		}
		return min;
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
		SelectionSortLinkedList lzr = new SelectionSortLinkedList();
		int[] array = { 3, 2, 1, 5, 4 };
		ListNode head = lzr.constructLinkedList(array);
		ListNode result = lzr.selectionSort(head);
		lzr.printLinkedList(result);
	}
}