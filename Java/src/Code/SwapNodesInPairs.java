package Code;
class SwapNodesInPairs {
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

	ListNode swapPairs(ListNode head) {
		ListNode dummy = new ListNode(0, head);
		ListNode pre = dummy;
		ListNode cur = head;
		while (cur != null && cur.next != null) {
			ListNode pair = cur.next.next;
			
		}
		return head;
	}

	public static void main(String[] args) {
		SwapNodesInPairs lzr = new SwapNodesInPairs();
		
	}
}