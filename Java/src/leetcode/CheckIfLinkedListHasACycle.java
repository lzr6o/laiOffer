package leetcode;

class CheckIfLinkedListHasACycle {
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

	public static void main(String[] args) {
		CheckIfLinkedListHasACycle lzr = new CheckIfLinkedListHasACycle();
		int[] arr = { 1, 2, 3 };
		ListNode head = ListNode.build(arr);
		boolean res = lzr.hasCycle(head);
		System.out.print(res);
	}
}