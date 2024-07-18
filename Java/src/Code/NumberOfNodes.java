package Code;

class NumberOfNodes {
	int numberOfNodes(ListNode head) {
		int res = 0;
		while (head != null) {
			head = head.next;
			res++;
		}
		return res;
	}

	public static void main(String[] args) {
		NumberOfNodes lzr = new NumberOfNodes();
		int[] arr = { 1, 2, 3 };
		ListNode head = ListNode.build(arr);
		int res = lzr.numberOfNodes(head);
		System.out.print(res);
	}
}