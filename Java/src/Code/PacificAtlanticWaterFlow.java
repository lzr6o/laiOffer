package Code;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class PacificAtlanticWaterFlow {
	List<List<Integer>> pacificAtlantic(int[][] heights) {
		int ROWS = heights.length, COLS = heights[0].length;
		boolean[][] pac = new boolean[ROWS][COLS];
		boolean[][] atl = new boolean[ROWS][COLS];
		for (int c = 0; c < COLS; c++) {
			dfs(heights, ROWS, COLS, 0, c, pac, heights[0][c]);
			dfs(heights, ROWS, COLS, ROWS - 1, c, atl, heights[ROWS - 1][c]);
		}
		for (int r = 0; r < ROWS; r++) {
			dfs(heights, ROWS, COLS, r, 0, pac, heights[r][0]);
			dfs(heights, ROWS, COLS, r, COLS - 1, atl, heights[r][COLS - 1]);
		}
		List<List<Integer>> res = new ArrayList<>();
		for (int r = 0; r < ROWS; r++) {
			for (int c = 0; c < COLS; c++) {
				if (pac[r][c] && atl[r][c]) {
					res.add(Arrays.asList(r, c));
				}
			}
		}
		return res;
	}

	void dfs(int[][] heights, int ROWS, int COLS, int r, int c, boolean[][] visited, int prevHeight) {
		if (r < 0 || c < 0 || r == ROWS || c == COLS || visited[r][c] || heights[r][c] < prevHeight) {
			return;
		}
		visited[r][c] = true;
		dfs(heights, ROWS, COLS, r + 1, c, visited, heights[r][c]);
		dfs(heights, ROWS, COLS, r - 1, c, visited, heights[r][c]);
		dfs(heights, ROWS, COLS, r, c + 1, visited, heights[r][c]);
		dfs(heights, ROWS, COLS, r, c - 1, visited, heights[r][c]);
	}
	
	public static void main(String[] args) {
		PacificAtlanticWaterFlow lzr = new PacificAtlanticWaterFlow();
		int[][] heights = { { 1, 2, 2, 3, 5 }, { 3, 2, 3, 4, 4 }, { 2, 4, 5, 3, 1 }, { 6, 7, 1, 4, 5 }, { 5, 1, 1, 2, 4 } };
		List<List<Integer>> res = lzr.pacificAtlantic(heights);
		for (List<Integer> list: res) {
			System.out.print(list + " ");
		}
	}
}