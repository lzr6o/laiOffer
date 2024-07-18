package Code;

class LargestXOf1s {
	int largest(int[][] matrix) {
		int ROWS = matrix.length, COLS = matrix[0].length;
		if (ROWS == 0 || COLS == 0) {
			return 0;
		}
		int[][] leftUp = leftUp(matrix, ROWS, COLS);
		int[][] rightDown = rightDown(matrix, ROWS, COLS);
		return merge(leftUp, rightDown, ROWS, COLS);
	}

	int merge(int[][] leftUp, int[][] rightDown, int ROWS, int COLS) {
		int res = 0;
		for (int i = 0; i < ROWS; i++) {
			for (int j = 0; j < COLS; j++) {
				leftUp[i][j] = Math.min(leftUp[i][j], rightDown[i][j]);
				res = Math.max(res, leftUp[i][j]);
			}
		}
		return res;
	}

	int[][] leftUp(int[][] matrix, int ROWS, int COLS) {
		int[][] left = new int[ROWS][COLS];
		int[][] up = new int[ROWS][COLS];
		for (int i = 0; i < ROWS; i++) {
			for (int j = 0; j < COLS; j++) {
				if (matrix[i][j] == 1) {
					left[i][j] = getNumber(left, i - 1, j - 1, ROWS, COLS) + 1;
					up[i][j] = getNumber(up, i - 1, j + 1, ROWS, COLS) + 1;
				}
			}
		}
		merge(left, up, ROWS, COLS);
		return left;
	}

	int[][] rightDown(int[][] matrix, int ROWS, int COLS) {
		int[][] right = new int[ROWS][COLS];
		int[][] down = new int[ROWS][COLS];
		for (int i = ROWS - 1; i >= 0; i--) {
			for (int j = COLS - 1; j >= 0; j--) {
				if (matrix[i][j] == 1) {
					right[i][j] = getNumber(right, i + 1, j + 1, ROWS, COLS) + 1;
					down[i][j] = getNumber(down, i + 1, j - 1, ROWS, COLS) + 1;
				}
			}
		}
		merge(right, down, ROWS, COLS);
		return right;
	}

	int getNumber(int[][] num, int x, int y, int ROWS, int COLS) {
		if (x < 0 || x >= ROWS || y < 0 || y >= COLS) {
			return 0;
		}
		return num[x][y];
	}

	public static void main(String[] args) {
		LargestXOf1s lzr = new LargestXOf1s();
		int[][] matrix = { { 0, 0, 0, 0 }, { 1, 1, 1, 1 }, { 0, 1, 1, 1 }, { 1, 0, 1, 1 } };
		int res = lzr.largest(matrix);
		System.out.print(res);
	}
}