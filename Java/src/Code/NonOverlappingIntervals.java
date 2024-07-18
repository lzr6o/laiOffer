package Code;
import java.util.Arrays;

class NonOverlappingIntervals {
	int eraseOverlapIntervals(int[][] intervals) {
		Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
		int res = 0;
		int[] pre = intervals[0];
		for (int i = 1; i < intervals.length; i++) {
			if (intervals[i][0] < pre[1]) {
				pre[1] = Math.min(pre[1], intervals[i][1]);
				res++;
			} else {
				pre[1] = intervals[i][1];
			}
		}
		return res;
	}

	public static void main(String[] args) {
		NonOverlappingIntervals lzr = new NonOverlappingIntervals();
		int[][] intervals = { { 0, 2 }, { 1, 3 }, { 2, 4 }, { 3, 5 }, { 4, 6 } };
		int res = lzr.eraseOverlapIntervals(intervals);
		System.out.print(res);
	}
}