package leetcode;

class LargestSquareSurroundedBy1 {
	int largestSquareSurroundedByOne(int[][] matrix) {
		int res = 0, ROWS = matrix.length, COLS = matrix[0].length;
		if (ROWS == 0 || COLS == 0) {
			return 0;
		}
		int[][] LEFT = new int[ROWS + 1][COLS + 1], UP = new int[ROWS + 1][COLS + 1];
		for (int i = 0; i < ROWS; i++) {
			for (int j = 0; j < COLS; j++) {
				if (matrix[i][j] == 1) {
					LEFT[i + 1][j + 1] = LEFT[i + 1][j] + 1;
					UP[i + 1][j + 1] = UP[i][j + 1] + 1;
					for (int max = Math.min(LEFT[i + 1][j + 1], UP[i + 1][j + 1]); max >= 1; max--) {
						if (LEFT[i + 2 - max][j + 1] >= max && UP[i + 1][j + 2 - max] >= max) {
							res = Math.max(res, max);
							break;
						}
					}
				}
			}
		}
		return res;
	}

	public static void main(String[] args) {
		LargestSquareSurroundedBy1 lzr = new LargestSquareSurroundedBy1();
		int[][] matrix = { { 1, 0, 1, 1, 1 }, { 1, 1, 1, 1, 1 }, { 1, 1, 0, 1, 0 }, { 1, 1, 1, 1, 1 },
				{ 1, 1, 1, 0, 0 } };
		int res = lzr.largestSquareSurroundedByOne(matrix);
		System.out.print(res);
	}
}