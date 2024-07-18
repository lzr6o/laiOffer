package Code;

import java.util.HashMap;
import java.util.Map;

class DegreeOfAnArray {
	class Node {
		int cnt;
		int start;
		int end;

		Node(int cnt, int start) {
			this.cnt = cnt;
			this.start = start;
		}
	}

	int findShortestSubArray(int[] nums) {
		Map<Integer, Node> map = new HashMap<>();
		int min = 0;
		int degree = 0;
		Node node;
		for (int i = 0; i < nums.length; i++) {
			int num = nums[i];
			if (!map.containsKey(num)) {
				map.put(num, new Node(1, i));
			} else {
				node = map.get(num);
				node.cnt++;
				node.end = i;
			}
			node = map.get(num);
			int len = node.end - node.start + 1;
			if (len < 1) {
				len = 1;
			}
			if (node.cnt > degree) {
				degree = node.cnt;
				min = len;
			} else if (node.cnt == degree) {
				min = Math.min(min, len);
			}
		}
		return min;
	}

	public static void main(String[] args) {
		DegreeOfAnArray lzr = new DegreeOfAnArray();
		int[] nums = { 2, 1 };
		int res = lzr.findShortestSubArray(nums);
		System.out.print(res);
	}
}