package leetcode;
class MinCostClimbingStairs {
	int minCostClimbingStairs(int[] cost) {
		int one = cost[0], two = cost[1];
		for (int i = 2; i < cost.length; i++) {
			int tmp = cost[i] + Math.min(one, two);
			one = two;
			two = tmp;
		}
		return Math.min(one, two);
	}

	public static void main(String[] args) {
		MinCostClimbingStairs lzr = new MinCostClimbingStairs();
		int[] cost = { 10, 15, 20 };
		int res = lzr.minCostClimbingStairs(cost);
		System.out.print(res);
	}
}