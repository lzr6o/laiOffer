package leetcode;

import java.util.Arrays;

class Heaters {
	int findRadius(int[] houses, int[] heaters) {
		int min = 0, radius = Integer.MAX_VALUE;
		Arrays.sort(houses);
		Arrays.sort(heaters);
		int j = 0;
		for (int i = 0; i < houses.length; i++) {
			while (j < heaters.length && heaters[j] < houses[i]) {
				j++;
			}
			if (j == 0) {
				radius = heaters[0] - houses[i];
			} else if (j == heaters.length) {
				radius = houses[i] - heaters[j - 1];
			} else {
				radius = Math.min(heaters[j] - houses[i], houses[i] - heaters[j - 1]);
			}
			min = Math.max(min, radius);
		}
		return min;
	}

	public static void main(String[] args) {
		Heaters lzr = new Heaters();
		int[] houses = { 1, 2, 3 };
		int[] heaters = { 2 };
		int res = lzr.findRadius(houses, heaters);
		System.out.print(res);
	}
}