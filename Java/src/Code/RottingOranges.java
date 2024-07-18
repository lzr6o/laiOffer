package Code;
import java.util.LinkedList;
import java.util.Queue;

class RottingOranges {
	int orangesRotting(int[][] grid) {
		Queue<int[]> q = new LinkedList<>();
		int mins = 0, fresh = 0;
		int ROWS = grid.length, COLS = grid[0].length;
		for (int r = 0; r < ROWS; r++) {
			for (int c = 0; c < COLS; c++) {
				if (grid[r][c] == 1) {
					fresh++;
				}
				if (grid[r][c] == 2) {
					q.add(new int[] { r, c });
				}
			}
		}
		int[][] dirs = new int[][] { { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 } };
		while (!q.isEmpty() && fresh > 0) {
			int num = q.size();
			for (int i = 0; i < num; i++) {
				int[] cur = q.poll();
				for (int[] dir : dirs) {
					int row = dir[0] + cur[0], col = dir[1] + cur[1];
					if (row < 0 || row == ROWS || col < 0 || col == COLS || grid[row][col] != 1) {
						continue;
					}
					grid[row][col] = 2;
					q.add(new int[] { row, col });
					fresh--;
				}
			}
			mins++;
		}
		return fresh == 0 ? mins : -1;
	}

	public static void main(String[] args) {
		RottingOranges lzr = new RottingOranges();
		int[][] grid = { { 2, 1, 1 }, { 1, 1, 1 }, { 0, 1, 2 } };
		int res = lzr.orangesRotting(grid);
		System.out.print(res);
	}
}