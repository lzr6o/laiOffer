package Code;

class FrogJump {
	boolean canCross(int[] stones) {
		boolean[] dp = new boolean[stones.length];
		int[][] jump = new int[2][stones.length];
		jump[0][0] = 1;
		jump[1][0] = 1;
		int max = 1;
		for (int i = 0; i < stones.length; i++) {
			if (stones[i] + jump[i][1] >= stones[i + 1]) {
				dp[i] = true;
			} else {
				for (int j = max; j >= 0; j--) {
					if (dp[j] == true) {
						dp[i] = true;
						break;
					}
				}
			}
			jump[0][i] = 
			max = Math.max(max, stones[i + 1] - stones[i] + 1);
		}
		return dp[stones.length - 1];
	}
	
	public static void main(String[] args) {
		FrogJump lzr = new FrogJump();
		int[] stones = { 0, 1, 3, 5, 6, 8, 12, 17 };
		boolean res = lzr.canCross(stones);
		System.out.print(res);
	}
}