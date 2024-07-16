package leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

class MinimumIntervalToIncludeEachQuery {
	int[] minInterval(int[][] intervals, int[] queries) {
		Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
		int[] arr = Arrays.copyOf(queries, queries.length);
		Arrays.sort(arr);
		PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] - b[0]);
		Map<Integer, Integer> map = new HashMap<>();
		int idx = 0;
		for (int num : arr) {
			while (idx < intervals.length && intervals[idx][0] <= num) {
				pq.offer(new int[] { intervals[idx][1] - intervals[idx][0] + 1, intervals[idx][1] });
				idx++;
			}
			while (!pq.isEmpty() && pq.peek()[1] < num) {
				pq.poll();
			}
			map.put(num, pq.isEmpty() ? -1 : pq.peek()[0]);
		}
		for (int i = 0; i < queries.length; i++) {
			queries[i] = map.get(queries[i]);
		}
		return queries;
	}

	public static void main(String[] args) {
		MinimumIntervalToIncludeEachQuery lzr = new MinimumIntervalToIncludeEachQuery();
		int[][] intervals = { { 2, 3 }, { 2, 5 }, { 1, 8 }, { 20, 25 } };
		int[] queries = { 2, 19, 5, 22 };
		int[] res = lzr.minInterval(intervals, queries);
		System.out.print(Arrays.toString(res));
	}
}