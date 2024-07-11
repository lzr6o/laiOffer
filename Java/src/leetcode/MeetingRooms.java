package leetcode;
import java.util.Arrays;

class MeetingRooms {
	boolean canAttendMeetings(int[][] intervals) {
		Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
		for (int i = 1; i < intervals.length; i++) {
			int[] cur = intervals[i], pre = intervals[i - 1];
			if (cur[0] < pre[1]) {
				return false;
			}
		}
		return true;
	}

	public static void main(String[] args) {
		MeetingRooms lzr = new MeetingRooms();
		int[][] intervals = { { 7, 10 }, { 2, 4 } };
		boolean res = lzr.canAttendMeetings(intervals);
		System.out.print(res);
	}
}