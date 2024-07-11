package leetcode;
class ValidSudoku {
	boolean isValidSudoku(char[][] board) {
		int[][] rows = new int[9][9];
		int[][] cols = new int[9][9];
		int[][][] boxs = new int[3][3][9];
		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				char c = board[i][j];
				if (c != '.') {
					int idx = c - '0' - 1;
					rows[i][idx]++;
					cols[j][idx]++;
					boxs[i / 3][j / 3][idx]++;
					if (rows[i][idx] > 1 || cols[j][idx] > 1 || boxs[i / 3][j / 3][idx] > 1) {
						return false;
					}
				}
			}
		}
		return true;
	}

	public static void main(String[] args) {
		ValidSudoku lzr = new ValidSudoku();
		char[][] board = { { '5', '3', '.', '.', '7', '.', '.', '.', '.' },
				{ '6', '.', '.', '1', '9', '5', '.', '.', '.' }, { '.', '9', '8', '.', '.', '.', '.', '6', '.' },
				{ '8', '.', '.', '.', '6', '.', '.', '.', '3' }, { '4', '.', '.', '8', '.', '3', '.', '.', '1' },
				{ '7', '.', '.', '.', '2', '.', '.', '.', '6' }, { '.', '6', '.', '.', '.', '.', '2', '8', '.' },
				{ '.', '.', '.', '4', '1', '9', '.', '.', '5' }, { '.', '.', '.', '.', '8', '.', '.', '7', '9' } };
		boolean res = lzr.isValidSudoku(board);
		System.out.print(res);
	}
}