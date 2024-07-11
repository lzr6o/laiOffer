package leetcode;
import java.util.ArrayList;
import java.util.List;

class NQueens {
	List<List<Integer>> nqueens(int n) {
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		int[] cur = new int[n];
		boolean[] usedColumns = new boolean[n];
		boolean[] usedDiagonals = new boolean[2 * n - 1];
		boolean[] usedRevDiagonals = new boolean[2 * n - 1];
		helper(n, 0, cur, result, usedColumns, usedDiagonals, usedRevDiagonals);
		return result;
	}
	
	void helper(int n, int row, int[] cur, List<List<Integer>> result, boolean[] usedColumns, boolean[] usedDiagonals, boolean[] usedRevDiagonals) {
		if (row == n) {
			result.add(toList(cur));
			return;
		}
		for (int i = 0; i < n; i++) {
			if (valid(n, row, i, usedColumns, usedDiagonals, usedRevDiagonals)) {
				mark(n, row, i, usedColumns, usedDiagonals, usedRevDiagonals);
				cur[row] = i;
				helper(n, row + 1, cur, result, usedColumns, usedDiagonals, usedRevDiagonals);
				unMark(n, row, i, usedColumns, usedDiagonals, usedRevDiagonals);
			}
		}
	}
	
	boolean valid(int n, int row, int column, boolean[] usedColumns, boolean[] usedDiagonals, boolean[] usedRevDiagonals) {
		return !usedColumns[column] && !usedDiagonals[column + row] && !usedRevDiagonals[column - row + n - 1];
	}
	
	void mark(int n, int row, int column, boolean[] usedColumns, boolean[] usedDiagonals, boolean[] usedRevDiagonals) {
		usedColumns[column] = true;
		usedDiagonals[column + row] = true;
		usedRevDiagonals[column - row + n - 1] = true;
	}
	
	void unMark(int n, int row, int column, boolean[] usedColumns, boolean[] usedDiagonals, boolean[] usedRevDiagonals) {
		usedColumns[column] = false;
		usedDiagonals[column + row] = false;
		usedRevDiagonals[column - row + n - 1] = false;
	}
	
	List<Integer> toList(int[] array) {
		List<Integer> list = new ArrayList<>();
		for (int num : array) {
			list.add(num);
		}
		return list;
	}
	
	public static void main(String[] args) {
		NQueens lzr = new NQueens();
		int n = 4;
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		result = lzr.nqueens(n);
		System.out.print(result);
	}
}