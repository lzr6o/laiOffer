package leetcode;

class CarPooling {

	boolean carPooling(int[][] trips, int capacity) {
		int last = 0;
		for (int[] trip : trips) {
			if (trip[2] > last) {
				last = trip[2];
			}
		}
		int[] diff = new int[last + 1];
		for (int[] trip : trips) {
			int cap = trip[0];
			int from = trip[1];
			int to = trip[2];
			diff[from] += cap;
			diff[to] -= cap;
		}
		int cur = 0;
		for (int num : diff) {
			cur += num;
			if (cur > capacity) {
				return false;
			}
		}
		return true;
	}

	public static void main(String[] args) {
		CarPooling lzr = new CarPooling();
		int[][] trips = { { 2, 1, 5 }, { 3, 3, 7 } };
		int capacity = 4;
		boolean res = lzr.carPooling(trips, capacity);
		System.out.print(res);
	}
}