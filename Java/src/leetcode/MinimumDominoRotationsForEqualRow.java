package leetcode;

import java.util.ArrayList;
import java.util.List;

class MinimumDominoRotationsForEqualRow {
	int minDominoRotations(int[] tops, int[] bottoms) {
		List<Integer> target = new ArrayList<>();
		target.add(tops[0]);
		target.add(bottoms[0]);
		int missingT = 0, missingB = 0;
		for (int i = 0; i < tops.length; i++) {
			if (!target.contains(tops[i]) && !target.contains(bottoms[i])) {
				return -1;
			} else if (!target.contains(tops[i])) {
				missingT++;
			} else {
				missingB++;
			}
		}
		return Math.min(missingT, missingB);
	}

	public static void main(String[] args) {
		MinimumDominoRotationsForEqualRow lzr = new MinimumDominoRotationsForEqualRow();
		int[] tops = { 2, 1, 2, 4, 2, 2 };
		int[] bottom = { 5, 2, 6, 2, 3, 2 };
		int res = lzr.minDominoRotations(tops, bottom);
		System.out.print(res);
	}
}