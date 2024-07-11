package leetcode;
class ReverseLinkedListInPairs {
	static class ListNode {
		int value;
		ListNode next;
		ListNode(int value) {
			this.value = value;
			next = null;
		}
	}
	
	ListNode reverseInPairs(ListNode head) {
		ListNode dummy = new ListNode(0);
		dummy.next = head;
		ListNode cur = dummy;
		while (cur.next != null && cur.next.next != null) {
			ListNode next = cur.next.next;
			cur.next.next = cur.next.next.next;
			next.next = cur.next;
			cur.next = next;
			cur = cur.next.next;
		}
		return dummy.next;
	}
	
	public static void main(String[] args) {
		ReverseLinkedListInPairs lzr = new ReverseLinkedListInPairs();
		ListNode node = new ListNode(1);
		node.next = new ListNode(2);
		node.next.next = new ListNode(3);
		ListNode result = lzr.reverseInPairs(node);
		while (result != null) {
			System.out.print(result.value + " ");
			result = result.next;
		}
	}
}