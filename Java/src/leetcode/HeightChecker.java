package leetcode;

import java.util.Arrays;

class HeightChecker {
	int heightChecker(int[] heights) {
		int[] order = heights.clone();
		Arrays.sort(order);
		int cnt = 0;
		for (int i = 0; i < order.length; i++) {
			if (order[i] != heights[i]) {
				cnt++;
			}
		}
		return cnt;
	}

	public static void main(String[] args) {
		HeightChecker lzr = new HeightChecker();
		int[] heights = { 1, 1, 4, 2, 1, 3 };
		int res = lzr.heightChecker(heights);
		System.out.print(res);
	}
}