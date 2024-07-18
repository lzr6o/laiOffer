package Code;

class LargestSquareOfMatches {
	int largestSquareOfMatches(int[][] matrix) {
		int res = 0, ROWS = matrix.length, COLS = matrix[0].length;
		if (ROWS == 0 || COLS == 0) {
			return 0;
		}
		int[][] RIGHT = new int[ROWS + 1][COLS + 1], DOWN = new int[ROWS + 1][COLS + 1];
		for (int i = ROWS - 1; i >= 0; i--) {
			for (int j = COLS - 1; j >= 0; j--) {
				if (hasRight(matrix[i][j])) {
					RIGHT[i][j] = RIGHT[i][j + 1] + 1;
				}
				if (hasDown(matrix[i][j])) {
					DOWN[i][j] = DOWN[i + 1][j] + 1;
				}
				if (hasBoth(matrix[i][j])) {
					for (int max = Math.min(RIGHT[i][j], DOWN[i][j]); max >= 1; max--) {
						if (RIGHT[i + max][j] >= max && DOWN[i][j + max] >= max) {
							res = Math.max(res, max);
							break;
						}
					}
				}
			}
		}
		return res;
	}

	boolean hasRight(int value) {
		return (value & 0b1) != 0;
	}

	boolean hasDown(int value) {
		return (value & 0b10) != 0;
	}

	boolean hasBoth(int value) {
		return value == 0b11;
	}

	public static void main(String[] args) {
		LargestSquareOfMatches lzr = new LargestSquareOfMatches();
		int[][] matrix = { { 3, 1, 1, 3, 0, 1, 1, 0 }, { 2, 0, 0, 2, 0, 0, 0, 0 }, { 3, 1, 3, 0, 0, 0, 0, 0 },
				{ 2, 0, 2, 0, 0, 0, 0, 0 }, { 1, 1, 0, 0, 0, 0, 0, 0 } };
		int res = lzr.largestSquareOfMatches(matrix);
		System.out.print(res);
	}
}