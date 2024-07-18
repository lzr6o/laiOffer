package Code;

class InsertInSortedLinkedList {

	class ListNode {
		int val;
		ListNode next;
		ListNode(int val) {
			this.val = val;
			next = null;
		}
	}

	ListNode insert(ListNode head, int val) {
		ListNode newNode = new ListNode(val);
		if (head == null || head.val >= val) {
			newNode.next = head;
			return newNode;
		}
		ListNode prev = head;
		while (prev.next != null && prev.next.val < val) {
			prev = prev.next;
		}
		newNode.next = prev.next;
		prev.next = newNode;
		return head;
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
		InsertInSortedLinkedList lzr = new InsertInSortedLinkedList();
		int[] arr = { 1, 2, 3, 5 };
		ListNode head = lzr.constructLinkedList(arr);
		int val = 4;
		ListNode res = lzr.insert(head, val);
		lzr.printLinkedList(res);
	}
}