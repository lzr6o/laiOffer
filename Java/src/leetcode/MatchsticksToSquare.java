package leetcode;

import java.util.Arrays;

class MatchsticksToSquare {
	boolean makesquare(int[] matchsticks) {
		if (matchsticks.length < 4) {
			return false;
		}
		int sum = 0;
		int[] sides = new int[4];
		for (int n : matchsticks) {
			sum += n;
		}
		if (sum % 4 != 0) {
			return false;
		}
		int len = sum / 4;
		Arrays.sort(matchsticks);
		return backtrack(matchsticks, sides, len, matchsticks.length - 1);
	}

	boolean backtrack(int[] matchsticks, int[] sides, int len, int idx) {
		if (idx == -1) {
			return true;
		}
		for (int i = 0; i < 4; i++) {
			if (sides[i] + matchsticks[idx] <= len) {
				sides[i] += matchsticks[idx];
				if (backtrack(matchsticks, sides, len, idx - 1)) {
					return true;
				}
				sides[i] -= matchsticks[idx];
			}
		}
		return false;
	}

	public static void main(String[] args) {
		MatchsticksToSquare lzr = new MatchsticksToSquare();
		int[] matchsticks = { 1, 1, 2, 2, 2 };
		boolean res = lzr.makesquare(matchsticks);
		System.out.print(res);
	}
}