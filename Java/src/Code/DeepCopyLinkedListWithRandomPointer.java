package Code;
import java.util.HashMap;
import java.util.Map;

class DeepCopyLinkedListWithRandomPointer {
	class RandomListNode {
		int value;
		RandomListNode next;
		RandomListNode random;
		RandomListNode(int value) {
			this.value = value;
		}
	}
	
	RandomListNode copy(RandomListNode head) {
		if (head == null) {
			return null;
		}
		RandomListNode dummy = new RandomListNode(0);
		RandomListNode cur = dummy;
		Map<RandomListNode, RandomListNode> map = new HashMap<>();
		while (head != null) {
			if (!map.containsKey(head)) {
				map.put(head, new RandomListNode(head.value));
			}
			cur.next = map.get(head);
			if (head.random != null) {
				if (!map.containsKey(head.random)) {
					map.put(head.random, new RandomListNode(head.random.value));
				}
				cur.next.random = map.get(head.random);
			}
			head = head.next;
			cur = cur.next;
		}
		return dummy.next;
	}
	
	public static void main(String[] args) {
		DeepCopyLinkedListWithRandomPointer lzr = new DeepCopyLinkedListWithRandomPointer();
		
	}
}