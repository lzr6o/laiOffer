package Code;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class MergeIntervals {
	int[][] merge(int[][] intervals) {
		Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
		List<int[]> res = new ArrayList<>();
		res.add(intervals[0]);
		for (int i = 1; i < intervals.length; i++) {
			int[] pre = res.get(res.size() - 1);
			if (pre[1] >= intervals[i][0]) {
				pre[1] = Math.max(pre[1], intervals[i][1]);
			} else {
				res.add(intervals[i]);
			}
		}
		return res.toArray(new int[0][]);
	}

	public static void main(String[] args) {
		MergeIntervals lzr = new MergeIntervals();
		int[][] intervals = new int[][] { { 1, 3 }, { 2, 6 }, { 8, 10 }, { 15, 18 } };
		int[][] res = lzr.merge(intervals);
		for (int i = 0; i < res.length; i++) {
			System.out.print(Arrays.toString(res[i]) + " ");
		}
	}
}