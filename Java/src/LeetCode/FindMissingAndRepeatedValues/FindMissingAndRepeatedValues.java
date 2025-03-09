package LeetCode.FindMissingAndRepeatedValues;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

class FindMissingAndRepeatedValues {
	int[] findMissingAndRepeatedValues(int[][] grid) {
		int ROWS = grid.length, COLS = grid[0].length, repeated = 0;
		int sum = (1 + ROWS * COLS) * (ROWS * COLS) / 2;
		Set<Integer> set = new HashSet<>();
		for (int i = 0; i < ROWS; i++) {
			for (int j = 0; j < COLS; j++) {
				if (!set.add(grid[i][j])) {
					repeated = grid[i][j];
				}
				sum -= grid[i][j];
			}
		}
		return new int[] { repeated, sum + repeated };
	}

	public static void main(String[] args) {
		FindMissingAndRepeatedValues lzr = new FindMissingAndRepeatedValues();
		int[][] grid = { { 1, 3 }, { 2, 2 } };
		int[] res = lzr.findMissingAndRepeatedValues(grid);
		System.out.print(Arrays.toString(res));
	}
}
