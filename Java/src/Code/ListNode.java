package Code;

public class ListNode {
	public int val;
	public ListNode next;

	public ListNode(int val) {
		this.val = val;
		next = null;
	}

	public static ListNode build(int[] arr) {
		ListNode dummy = new ListNode(0);
		ListNode cur = dummy;
		for (int num : arr) {
			ListNode node = new ListNode(num);
			cur.next = node;
			cur = cur.next;
		}
		return dummy.next;
	}

	public static void print(ListNode head) {
		while (head.next != null) {
			System.out.print(head.val + " -> ");
			head = head.next;
		}
		System.out.print(head.val + "\n");
	}

	public static void main(String[] args) {
		int[] arr1 = { 1, 2, 3 };
		int[] arr2 = { 1, 2, 3 };
		ListNode list1 = build(arr1);
		ListNode list2 = build(arr2);
		print(list1);
		print(list2);
	}
}