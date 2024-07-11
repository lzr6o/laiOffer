package leetcode;
class MergeStones {
	int minCost(int[] stones) {
		int n = stones.length;
		int[][] sum = new int[n][n];
		int[][] minCost = new int[n][n];
		for (int i = 0; i < sum.length; i++) {
			sum[i][i] = stones[i];
			for (int j = i + 1; j < sum.length; j++) {
				sum[i][j] = sum[i][j - 1] + stones[j];
			}
		}
		for (int k = 1; k < n; k++) {
			for (int i = 0; i < n - k; i++) {
				minCost[i][i + k] = Integer.MAX_VALUE;
				for (int j = i; j < i + k; j++) {
					int tmp = minCost[i][j] + minCost[j + 1][i + k] + sum[i][i + k];
					minCost[i][i + k] = Math.min(minCost[i][i + k], tmp);
				}
			}
		}
		return minCost[0][minCost.length - 1];
	}

	public static void main(String[] args) {
		MergeStones lzr = new MergeStones();
		int[] stones = { 4, 3, 3, 4 };
		int result = lzr.minCost(stones);
		System.out.print(result);
	}
}