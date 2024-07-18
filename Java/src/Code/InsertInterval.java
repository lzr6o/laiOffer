package Code;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class InsertInterval {

	int[][] insert(int[][] intervals, int[] newInterval) {
		List<int[]> ans = new ArrayList<>();
		int[] toAdd = newInterval;
		for (int[] interval : intervals) {
			if (interval[0] > toAdd[1]) {
				ans.add(toAdd);
				toAdd = interval;
			} else if (interval[1] >= toAdd[0]) {
				toAdd = new int[] { Math.min(interval[0], toAdd[0]), Math.max(interval[1], toAdd[1]) };
			} else {
				ans.add(interval);
			}
		}
		ans.add(toAdd);
		return ans.toArray(new int[ans.size()][2]);
	}

	public static void main(String[] args) {
		InsertInterval lzr = new InsertInterval();
		int[][] intervals = { { 1, 2 }, { 3, 5 }, { 6, 7 }, { 8, 10 }, { 12, 16 } };
		int[] newInterval = { 4, 8 };
		int[][] res = lzr.insert(intervals, newInterval);
		for (int[] arr : res) {
			System.out.print(Arrays.toString(arr) + " ");
		}
	}
}