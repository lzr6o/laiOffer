package Code;

class ContainerWithMostWater {

	int maxArea(int[] height) {
		int L = 0, R = height.length - 1, res = 0;
		while (L < R) {
			int area = Math.min(height[L], height[R]) * (R - L);
			res = Math.max(res, area);
			if (height[L] < height[R]) {
				L++;
			} else {
				R--;
			}
		}
		return res;
	}

	public static void main(String[] args) {
		ContainerWithMostWater lzr = new ContainerWithMostWater();
		int[] height = { 1, 8, 6, 2, 5, 4, 8, 3, 7 };
		int res = lzr.maxArea(height);
		System.out.print(res);
	}
}