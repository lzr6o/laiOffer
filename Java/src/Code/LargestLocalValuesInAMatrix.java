package Code;

class LargestLocalValuesInAMatrix {

	int[][] largestLocal(int[][] grid) {
		int ROWS = grid.length, COLS = grid[0].length;
		int[][] max = new int[ROWS - 2][COLS - 2];
		for (int r = 0; r < ROWS - 2; r++) {
			for (int c = 0; c < COLS - 2; c++) {
				for (int i = r; i < r + 3; i++) {
					for (int j = c; j < c + 3; j++) {
						max[r][c] = Math.max(max[r][c], grid[i][j]);
					}
				}
			}
		}
		return max;
	}

	public static void main(String[] args) {
		LargestLocalValuesInAMatrix lzr = new LargestLocalValuesInAMatrix();
		int[][] grid = { { 9, 9, 8, 1 }, { 5, 6, 2, 6 }, { 8, 2, 6, 4 }, { 6, 2, 2, 2 } };
		int[][] res = lzr.largestLocal(grid);
		int ROWS = res.length, COLS = res[0].length;
		for (int r = 0; r < ROWS; r++) {
			for (int c = 0; c < COLS; c++) {
				System.out.print(res[r][c] + " ");
			}
			System.out.print("\n");
		}
	}
}