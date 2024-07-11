package leetcode;
class NumberOfNodes {
	class ListNode {
		int value;
		ListNode next;
		ListNode(int value) {
			this.value = value;
			next = null;
		}
	}
	
	int numberOfNodes(ListNode head) {
		int res = 0;
		while (head != null) {
			head = head.next;
			res++;
		}
		return res;
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
		NumberOfNodes lzr = new NumberOfNodes();
		int[] array = { 1, 2, 3 };
		ListNode head = lzr.constructLinkedList(array);
		int result = lzr.numberOfNodes(head);
		System.out.print(result);
	}
}