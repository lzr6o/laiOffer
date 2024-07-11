package leetcode;
class LargestSubArrayProduct {
	double largestProduct(double[] arr) {
		double min, max, res;
		min = max = res = arr[0];
		for (int i = 1; i < arr.length; i++) {
			double minPro = arr[i] * min;
			double maxPro = arr[i] * max;
			min = Math.min(Math.min(minPro, maxPro), arr[i]);
			max = Math.max(Math.max(minPro, maxPro), arr[i]);
			res = Math.max(res, max);
		}
		return res;
	}
	
	public static void main(String[] args) {
		LargestSubArrayProduct lzr = new LargestSubArrayProduct();
		double[] arr = { -5, -2, -1, -0.3 };
		double res = lzr.largestProduct(arr);
		System.out.print(res);
	}
}