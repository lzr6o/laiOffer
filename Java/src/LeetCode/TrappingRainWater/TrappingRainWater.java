package LeetCode.TrappingRainWater;

class TrappingRainWater {
	int trap(int[] height) {
		int L, R, maxL, maxR, res;
		L = res = 0;
		R = height.length - 1;
		maxL = height[0];
		maxR = height[R];
		while (L < R) {
			if (maxL < maxR) {
				L++;
				maxL = Math.max(maxL, height[L]);
				res += maxL - height[L];
			} else {
				R--;
				maxR = Math.max(maxR, height[R]);
				res += maxR - height[R];
			}
		}
		return res;
	}

	public static void main(String[] args) {
		TrappingRainWater lzr = new TrappingRainWater();
		int[] height = { 4, 2, 0, 3, 2, 5 };
		int res = lzr.trap(height);
		System.out.print(res);
	}
}