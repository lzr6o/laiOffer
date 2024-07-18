package Code;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

class SmallestRangeCoveringElementsFromKLists {
	int[] smallestRange(List<List<Integer>> nums) {
		int[] res = { -100000, 100000 };
		int max = Integer.MIN_VALUE;
		PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> (a[0] - b[0]));
		for (int i = 0; i < nums.size(); i++) {
			int num = nums.get(i).get(0);
			max = Math.max(max, num);
			int[] toAdd = { num, 0, i };
			pq.add(toAdd);
			// 0th idx we hav min value of list
			// 1st idx we have the idx of the min value
			// 2nd idx we have idx of the list
		}
		while (true) {
			int[] cur = pq.poll();
			if (res[1] - res[0] > max - cur[0]) {
				res[0] = cur[0];
				res[1] = max;
			}
			cur[1]++; // element checked so idx increased to add next element from same list to pq
			List<Integer> list = nums.get(cur[2]);
			if (cur[1] == list.size()) {
				break; // break since no elements are left to be added to the list so cant do
						// comparison between three
			} else {
				cur[0] = list.get(cur[1]);
				max = Math.max(cur[0], max); // if the new element coming in the pq could be greater than max so we
												// checked for it
				pq.add(cur);
			}
		}
		return res;
	}

	public static void main(String[] args) {
		SmallestRangeCoveringElementsFromKLists lzr = new SmallestRangeCoveringElementsFromKLists();
		Integer[][] arrs = { { 4, 10, 15, 24, 26 }, { 0, 9, 12, 20 }, { 5, 18, 22, 30 } };
		List<List<Integer>> nums = new ArrayList<>();
		for (Integer[] arr : arrs) {
			nums.add(Arrays.asList(arr));
		}
		int[] res = lzr.smallestRange(nums);
		System.out.print(Arrays.toString(res));
	}
}
