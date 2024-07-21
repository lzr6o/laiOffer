package LeetCode.TopKFrequentElements;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

class TopKFrequentElements {
	int[] topKFrequent(int[] nums, int k) {
		Map<Integer, Integer> map = new HashMap<>();
		for (int num : nums) {
			map.put(num, map.getOrDefault(num, 0) + 1);
		}
		PriorityQueue<Integer> heap = new PriorityQueue<>(k, (a, b) -> map.get(a) - map.get(b));
		for (int key : map.keySet()) {
			heap.add(key);
			if (heap.size() > k) {
				heap.poll();
			}
		}
		int[] ans = new int[k];
		for (int i = 0; i < k; i++) {
			ans[i] = heap.poll();
		}
		return ans;
	}

	public static void main(String[] args) {
		TopKFrequentElements lzr = new TopKFrequentElements();
		int[] nums = { 1, 1, 1, 2, 2, 3 };
		int k = 2;
		int[] res = lzr.topKFrequent(nums, k);
		System.out.print(Arrays.toString(res));
	}
}