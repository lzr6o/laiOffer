package leetcode;
class SearchA2DMatrixII {
	int searchMatrix(int[][] matrix, int target) {
		int count = 0;
		int row = 0;
		int col = matrix[0].length - 1;
		while (row <= matrix.length - 1 && col >= 0) {
			if (matrix[row][col] < target) {
				row++;
			} else if (matrix[row][col] == target) {
				count++;
				col--;
				row++;
			} else {
				col--;
			}
		}
		return count;
	}
	
	public static void main(String[] args) {
		SearchA2DMatrixII lzr = new SearchA2DMatrixII();
		int[][] matrix = { { 1, 3, 5, 7 },
				           { 2, 4, 7, 8 },
				           { 3, 5, 9, 10 } };
		int target = 3;
		int res = lzr.searchMatrix(matrix, target);
		System.out.print(res);
	}
}