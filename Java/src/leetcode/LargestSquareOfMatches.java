package leetcode;
class LargestSquareOfMatches {
	int largestSquareOfMatches(int[][] matrix) {
		if (matrix.length == 0 || matrix[0].length == 0) {
			return 0;
		}
		int res = 0;
		int m = matrix.length;
		int n = matrix[0].length;
		int[][] right = new int[m + 1][n + 1];
		int[][] down = new int[m + 1][n + 1];
		for (int i = m - 1; i >= 0; i--) {
			for (int j = n - 1; j >= 0; j--) {
				if (hasRight(matrix[i][j])) {
					right[i][j] = right[i][j + 1] + 1;
				}
				if (hasDown(matrix[i][j])) {
					down[i][j] = down[i + 1][j] + 1;
				}
				if (hasBoth(matrix[i][j])) {
					for (int maxLen = Math.min(right[i][j], down[i][j]); maxLen >= 1; maxLen--) {
						if (right[i + maxLen][j] >= maxLen && down[i][j + maxLen] >= maxLen) {
							res = Math.max(res, maxLen);
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
		int[][] matrix = { { 3, 1, 1, 3, 0, 1, 1, 0 },
				           { 2, 0, 0, 2, 0, 0, 0, 0 },
				           { 3, 1, 3, 0, 0, 0, 0, 0 },
				           { 2, 0, 2, 0, 0, 0, 0, 0 },
				           { 1, 1, 0, 0, 0, 0, 0, 0 } };
		int res = lzr.largestSquareOfMatches(matrix);
		System.out.print(res);
	}
}