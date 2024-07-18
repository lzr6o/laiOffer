package Code;
import java.util.Arrays;

class RotateMatrix {
	void rotate(int[][] matrix) {
		int n = matrix.length;
		if (n <= 1) {
			return;
		}
		int round = n / 2;
		for (int level = 0; level < round; level++) {
			int left = level;
			int right = n - 2 - level;
			for (int i = left; i <= right; i++) {
				int tmp = matrix[left][i];
				matrix[left][i] = matrix[n - 1 - i][left];
				matrix[n - 1 - i][left] = matrix[n - 1 - left][n - 1 - i];
				matrix[n - 1 - left][n - 1 - i] = matrix[i][n - 1 - left];
				matrix[i][n - 1 - left] = tmp;
			}
		}
	}
	
	public static void main(String[] args) {
		RotateMatrix lzr = new RotateMatrix();
		int[][] matrix = { { 1, 2, 3 },
						   { 8, 9, 4 },
						   { 7, 6, 5 } };
		lzr.rotate(matrix);
		System.out.print(Arrays.deepToString(matrix));
	}
}