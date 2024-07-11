package leetcode;
class LargestSquareSurroundedBy1 {
	int largestSquareSurroundedByOne(int[][] matrix) {
		if (matrix.length == 0 || matrix[0].length == 0) {
			return 0;
		}
		int res = 0;
		int m = matrix.length;
		int n = matrix[0].length;
		int[][] left = new int[m + 1][n + 1];
		int[][] up = new int[m + 1][n + 1];
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (matrix[i][j] == 1) {
					left[i + 1][j + 1] = left[i + 1][j] + 1;
					up[i + 1][j + 1] = up[i][j + 1] + 1;
					for (int maxLen = Math.min(left[i + 1][j + 1], up[i + 1][j + 1]); maxLen >= 1; maxLen--) {
						if (left[i + 2 - maxLen][j + 1] >= maxLen && up[i + 1][j + 2 - maxLen] >= maxLen) {
							res = Math.max(res, maxLen);
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
		int[][] matrix = { {1, 0, 1, 1, 1},
				           {1, 1, 1, 1, 1},
				           {1, 1, 0, 1, 0},
				           {1, 1, 1, 1, 1},
				           {1, 1, 1, 0, 0} };
		int result = lzr.largestSquareSurroundedByOne(matrix);
		System.out.print(result);
	}
}