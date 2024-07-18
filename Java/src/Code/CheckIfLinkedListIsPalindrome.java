package Code;

class CheckIfLinkedListIsPalindrome {
	boolean isPalindrome(ListNode head) {
		if (head == null || head.next == null) {
			return true;
		}
		ListNode middle = findMiddle(head);   // see LaiCode #36 above
		ListNode right = reverseLinkedList(middle.next);   // see LaiCode #34 above
		while (right != null) {
			if (head.val != right.val) {
				return false;
			}
			head = head.next;
			right = right.next;
		}
		return true;
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
	
	public static void main(String[] args) {
		CheckIfLinkedListIsPalindrome lzr = new CheckIfLinkedListIsPalindrome();
		int[] arr = { 1, 2, 3, 2, 1 };
		ListNode head = ListNode.build(arr);
		boolean res = lzr.isPalindrome(head);
		System.out.print(res);
	}
}