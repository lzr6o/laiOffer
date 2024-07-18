package Code;
import java.util.ArrayList;
import java.util.List;

class SpiralOrderTraverseII {
	List<Integer> spiral(int[][] matrix) {
		List<Integer> list = new ArrayList<Integer>();
		int m = matrix.length;
		if (m == 0) {
			return list;
		}
		int n = matrix[0].length;
		int left = 0;
		int right = n - 1;
		int up = 0;
		int down = m - 1;
		while (left < right && up < down) {
			for (int i = left; i <= right; i++) {
				list.add(matrix[up][i]);
			}
			for (int i = up + 1; i <= down - 1; i++) {
				list.add(matrix[i][right]);
			}
			for (int i = right; i >= left; i--) {
				list.add(matrix[down][i]);
			}
			for (int i = down - 1; i >= up + 1; i--) {
				list.add(matrix[i][left]);
			}
			left++;
			right--;
			up++;
			down--;
		}
		if (left > right || up > down) {
			return list;
		}
		if (left == right) {
			for (int i = up; i <= down; i++) {
				list.add(matrix[i][left]);
			}
		} else {
			for (int i = left; i <= right; i++) {
				list.add(matrix[up][i]);
			}
		}
		return list;
	}
	
	public static void main(String[] args) {
		SpiralOrderTraverseII lzr = new SpiralOrderTraverseII();
		int[][] matrix = { { 1, 2, 3 },
				           { 4, 5, 6 },
				           { 7, 8, 9 } };
		List<Integer> list = lzr.spiral(matrix);
		System.out.print(list);
	}
}