package leetcode;

class CheckIfLinkedListHasACycle {

	class ListNode {
		int value;
		ListNode next;
		ListNode(int value) {
			this.value = value;
			next = null;
		}
	}

	boolean hasCycle(ListNode head) {
		if (head == null || head.next == null) {
			return false;
		}
		ListNode slow = head;
		ListNode fast = head;
		while (fast != null && fast.next != null) {
			slow = slow.next;
			fast = fast.next.next;
			if (slow == fast) {
				return true;
			}
		}
		return false;
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
		CheckIfLinkedListHasACycle lzr = new CheckIfLinkedListHasACycle();
		int[] array = { 1, 2, 3 };
		ListNode head = lzr.constructLinkedList(array);
		boolean result = lzr.hasCycle(head);
		System.out.print(result);
	}
}