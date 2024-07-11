package leetcode;

class CycleNodeInLinkedList {

	class ListNode {
		int val;
		ListNode next;
		ListNode(int val) {
			this.val = val;
			next = null;
		}
	}
	
	ListNode cycleNode(ListNode head) {
		if (head == null || head.next == null) {
			return null;
		}
		ListNode slow = head;
		ListNode fast = head;
		while (fast != null && fast.next != null) {
			slow = slow.next;
			fast = fast.next.next;
			if (slow == fast) {
				fast = head;
				while (slow != fast) {
					slow = slow.next;
					fast = fast.next;
				}
				return slow;
			}
		}
		return null;
	}
	
	public static void main(String[] args) {
		CycleNodeInLinkedList lzr = new CycleNodeInLinkedList();
		
	}
}
