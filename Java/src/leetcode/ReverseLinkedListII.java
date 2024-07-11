package leetcode;
class ReverseLinkedListII {
	static class ListNode {
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
	
	ListNode reverseBetween(ListNode head, int left, int right) {
		ListNode dummy = new ListNode(0);
		dummy.next = head;
		ListNode leftPrev = dummy;
		ListNode cur = head;
		for (int i = 0; i < left - 1; i++) {
			leftPrev = cur;
			cur = cur.next;
		}
		ListNode prev = null;
		for (int i = 0; i < right - left + 1; i++) {
			ListNode tmpNext = cur.next;
			cur.next = prev;
			prev = cur;
			cur = tmpNext;
		}
		leftPrev.next.next = cur;
		leftPrev.next = prev;
		return dummy.next;
	}
	
	public static void main(String[] args) {
		
	}
}