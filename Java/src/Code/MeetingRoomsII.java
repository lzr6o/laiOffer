package Code;
import java.util.Arrays;
import java.util.PriorityQueue;

class MeetingRoomsII {
	int minMeetingRooms(int[][] intervals) {
		Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
		PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> a - b);
		for (int[] interval : intervals) {
			if (!pq.isEmpty() && pq.peek() <= interval[0]) {
				pq.poll();
			}
			pq.offer(interval[1]);
		}
		return pq.size();
	}

	public static void main(String[] args) {
		MeetingRoomsII lzr = new MeetingRoomsII();
		int[][] intervals = { { 2, 15 }, { 36, 45 }, { 9, 29 }, { 16, 23 }, { 4, 9 } };
		int res = lzr.minMeetingRooms(intervals);
		System.out.print(res);
	}
}