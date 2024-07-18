package Code;

import java.util.Arrays;
import java.util.PriorityQueue;

class CourseScheduleIII {

	int scheduleCourse(int[][] courses) {
		Arrays.sort(courses, (a, b) -> a[1] - b[1]);
		PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> b[0] - a[0]);
		int days = 0;
		for (int[] crs : courses) {
			if (crs[0] + days <= crs[1]) {
				days += crs[0];
				pq.offer(crs);
			} else if (!pq.isEmpty() && pq.peek()[0] > crs[0]) {
				days = days - pq.poll()[0] + crs[0];
				pq.offer(crs);
			}
		}
		return pq.size();
	}

	public static void main(String[] args) {
		CourseScheduleIII lzr = new CourseScheduleIII();
		int[][] courses = { { 5, 5 }, { 4, 6 }, { 2, 6 } };
		int res = lzr.scheduleCourse(courses);
		System.out.print(res);
	}
}