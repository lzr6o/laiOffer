package leetcode;

class CheckIfLinkedListIsPalindrome {

	class ListNode {
		int value;
		ListNode next;
		ListNode(int value) {
			this.value = value;
			next = null;
		}
	}

	boolean isPalindrome(ListNode head) {
		if (head == null || head.next == null) {
			return true;
		}
		ListNode middle = findMiddle(head);   // see LaiCode #36 above
		ListNode right = reverseLinkedList(middle.next);   // see LaiCode #34 above
		while (right != null) {
			if (head.value != right.value) {
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
		CheckIfLinkedListIsPalindrome lzr = new CheckIfLinkedListIsPalindrome();
		int[] array = { 1, 2, 3, 2, 1 };
		ListNode head = lzr.constructLinkedList(array);
		boolean result = lzr.isPalindrome(head);
		System.out.print(result);
	}
}