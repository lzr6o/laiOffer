package LeetCode.WallsAndGates;

import java.util.LinkedList;
import java.util.Queue;

class WallsAndGates {
	void wallsAndGates(int[][] rooms) {
		Queue<int[]> q = new LinkedList<>();
		int step = 1;
		int ROWS = rooms.length, COLS = rooms[0].length;
		for (int r = 0; r < ROWS; r++) {
			for (int c = 0; c < COLS; c++) {
				if (rooms[r][c] == 0) {
					q.add(new int[] { r, c });
				}
			}
		}
		int[][] dirs = new int[][] { { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 } };
		while (!q.isEmpty()) {
			int num = q.size();
			for (int i = 0; i < num; i++) {
				int[] cur = q.poll();
				for (int[] dir : dirs) {
					int row = dir[0] + cur[0], col = dir[1] + cur[1];
					if (row < 0 || row == ROWS || col < 0 || col == COLS || rooms[row][col] != Integer.MAX_VALUE) {
						continue;
					}
					rooms[row][col] = step;
					q.add(new int[] { row, col });
				}
			}
			step++;
		}
	}

	public static void main(String[] args) {
		WallsAndGates lzr = new WallsAndGates();
		int[][] rooms = { { 2147483647, -1, 0, 2147483647 }, { 2147483647, 2147483647, 2147483647, -1 },
				{ 2147483647, -1, 2147483647, -1 }, { 0, -1, 2147483647, 2147483647 } };
		lzr.wallsAndGates(rooms);
		int ROWS = rooms.length, COLS = rooms[0].length;
		for (int r = 0; r < ROWS; r++) {
			for (int c = 0; c < COLS; c++) {
				System.out.print(rooms[r][c] + " ");
			}
			System.out.print("\n");
		}
	}
}