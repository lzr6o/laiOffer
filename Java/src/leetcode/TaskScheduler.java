package leetcode;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

class TaskScheduler {
	int leastInterval(char[] tasks, int n) {
		int[] cnt = new int[26];
		for (char c : tasks) {
			cnt[c - 'A']++;
		}
		PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b - a);
		for (int num : cnt) {
			if (num != 0) {
				pq.offer(num);
			}
		}
		Queue<int[]> q = new LinkedList<>();
		int t = 0;
		while (!q.isEmpty() || !pq.isEmpty()) {
			t++;
			if (!pq.isEmpty()) {
				int cur = pq.poll() - 1;
				if (cur != 0) {
					q.add(new int[] { cur, t + n });
				}
			}
			if (!q.isEmpty() && q.peek()[1] == t) {
				pq.offer(q.poll()[0]);
			}
		}
		return t;
	}

	public static void main(String[] args) {
		TaskScheduler lzr = new TaskScheduler();
		char[] tasks = { 'A', 'A', 'A', 'B', 'B', 'B' };
		int n = 2;
		int res = lzr.leastInterval(tasks, n);
		System.out.print(res);
	}
}