package Code;
class JiQiRenDeYunDongFanWeiLCOF {
	int movingCount(int m, int n, int k) {
		boolean[][] visited = new boolean[m][n];
		return dfs(visited, m, n, k, 0, 0);
	}

	int dfs(boolean[][] visited, int m, int n, int k, int i, int j) {
		if (i >= m || j >= n || visited[i][j] || bitSum(i) + bitSum(j) > k) {
			return 0;
		}
		visited[i][j] = true;
		return 1 + dfs(visited, m, n, k, i + 1, j) + dfs(visited, m, n, k, i, j + 1);
	}

	int bitSum(int n) {
		int sum = 0;
		while (n > 0) {
			sum += n % 10;
			n /= 10;
		}
		return sum;
	}

	public static void main(String[] args) {
		JiQiRenDeYunDongFanWeiLCOF lzr = new JiQiRenDeYunDongFanWeiLCOF();
		int m = 14;
		int n = 14;
		int k = 5;
		int res = lzr.movingCount(m, n, k);
		System.out.print(res);
	}
}