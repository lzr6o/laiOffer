package Code;
class RotateList {
	class ListNode {
		int val;
		ListNode next;

		ListNode() {
		}

		ListNode(int val) {
			this.val = val;
		}

		ListNode(int val, ListNode next) {
			this.val = val;
			this.next = next;
		}
	}
	
	ListNode rotateRight(ListNode head, int k) {
		if (head == null) {
			return head;
		}
		int len = 1;
		ListNode tail = head;
		while (tail.next != null) {
			tail = tail.next;
			len++;
		}
		k = k % len;
		if (k == 0) {
			return head;
		}
		ListNode cur = head;
		for (int i = 0; i < len - k - 1; i++) {
			cur = cur.next;
		}
		ListNode newHead = cur.next;
		cur.next = null;
		tail.next = head;
		return newHead;
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
			System.out.print(head.val + " ");
			head = head.next;
		}
	}
	
	public static void main(String[] args) {
		RotateList lzr = new RotateList();
		int[] arr = { 1, 2, 3, 4, 5 };
		int k = 2;
		ListNode head = lzr.constructLinkedList(arr);
		ListNode res = lzr.rotateRight(head, k);
		lzr.printLinkedList(res);
	}
}