package leetcode;

import java.util.ArrayDeque;
import java.util.Deque;

class DisjointWhiteObjects {

	class Cell {
		int row;
		int column;
		int value;
		Cell(int row, int column, int value) {
			this.row = row;
			this.column = column;
			this.value = value;
		}
	}
	
	int whiteObjects(int[][] grid) {
		int rows = grid.length;
		int cols = grid[0].length;
		if (rows == 0 || cols == 0) {
			return 0;
		}
		int islands = 0;
		boolean[][] visit = new boolean[rows][cols];
		for (int r = 0; r < rows; r++) {
			for (int c = 0; c < cols; c++) {
				if (grid[r][c] == 0 && !visit[r][c]) {
					bfs(grid, rows, cols, r, c, visit);
					islands++;
				}
			}
		}
		return islands;
	}
	
	void bfs(int[][] grid, int rows, int cols, int r, int c, boolean[][] visit) {
		Deque<Cell> neighbors = new ArrayDeque<>();
		visit[r][c] = true;
		neighbors.offerLast(new Cell(r, c, grid[r][c]));
		while (!neighbors.isEmpty()) {
			Cell cell = neighbors.pollFirst();
			int[][] directions = { {1, 0}, {-1, 0}, {0, 1}, {0, -1} };
			for (int[] dir : directions) {
				int row = cell.row + dir[0];
				int col = cell.column + dir[1];
				if (row >= 0 && row < rows && col >= 0 && col < cols && grid[row][col] == 0 && !visit[row][col]) {
					neighbors.offerLast(new Cell(row, col, grid[row][col]));
					visit[row][col] = true;
				}
			}
		}
	}
	
	public static void main(String[] args) {
		DisjointWhiteObjects lzr = new DisjointWhiteObjects();
		int[][] matrix = { { 1, 0, 0, 0 },
				           { 1, 1, 0, 0 },
				           { 0, 0, 0, 1 },
				           { 1, 0, 1, 1 } };
		int res = lzr.whiteObjects(matrix);
		System.out.print(res);
	}
}