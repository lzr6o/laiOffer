package leetcode;
import java.util.ArrayList;
import java.util.List;

class SpiralOrderTraverse {
	List<Integer> spiral(int[][] matrix) {
		List<Integer> res = new ArrayList<>();
		recursiveTraverse(matrix, 0, matrix.length, res);
		return res;
	}

	void recursiveTraverse(int[][] matrix, int offset, int size, List<Integer> res) {
		if (size == 0) {
			return;
		}
		if (size == 1) {
			res.add(matrix[offset][offset]);
			return;
		}
		for (int i = 0; i < size - 1; i++) {
			res.add(matrix[offset][offset + i]);
		}
		for (int i = 0; i < size - 1; i++) {
			res.add(matrix[offset + i][offset + size - 1]);
		}
		for (int i = size - 1; i >= 1; i--) {
			res.add(matrix[offset + size - 1][offset + i]);
		}
		for (int i = size - 1; i >= 1; i--) {
			res.add(matrix[offset + i][offset]);
		}
		recursiveTraverse(matrix, offset + 1, size - 2, res);
	}

	public static void main(String[] args) {
		SpiralOrderTraverse lzr = new SpiralOrderTraverse();
		int[][] matrix = { { 1, 2, 3 },
				           { 4, 5, 6 },
				           { 7, 8, 9 } };
		List<Integer> list = lzr.spiral(matrix);
		System.out.print(list);
	}
}