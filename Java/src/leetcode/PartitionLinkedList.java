package leetcode;
class PartitionLinkedList {
	class ListNode {
		int value;
		ListNode next;
		ListNode(int value) {
			this.value = value;
			next = null;
		}
	}

	ListNode partition(ListNode head, int target) {
		if (head == null || head.next == null) {
			return head;
		}
		ListNode small = new ListNode(0);
		ListNode large = new ListNode(0);
		ListNode curSmall = small;
		ListNode curLarge = large;
		while (head != null) {
			if (head.value < target) {
				curSmall.next = head;
				curSmall = curSmall.next;
			} else {
				curLarge.next = head;
				curLarge = curLarge.next;
			}
			head = head.next;
		}
		curSmall.next = large.next;
		curLarge.next = null;
		return small.next;
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
		PartitionLinkedList lzr = new PartitionLinkedList();
		int[] array = { 2, 4, 3, 5, 1 };
		int target = 3;
		ListNode head = lzr.constructLinkedList(array);
		ListNode result = lzr.partition(head, target);
		lzr.printLinkedList(result);
	}
}