package leetcode;
class MedianOfTwoSortedArrays {
	double median(int[] a, int[] b) {
		if (b.length < a.length) {
			return median(b, a);
		}
		int total = a.length + b.length;
		int half = (total + 1) / 2;
		int left = 0;
		int right = a.length;
		int i, j;
		while (left < right) {
			i = left + (right - left) / 2;
			j = half - i;
			if (a[i] < b[j - 1]) {
				left = i + 1;
			} else {
				right = i;
			}
		}
		i = left;
		j = half - left;
		int leftMedian = Math.max(i <= 0 ? Integer.MIN_VALUE : a[i - 1], j <= 0 ? Integer.MIN_VALUE : b[j - 1]);
		if (total % 2 == 1) {
			return leftMedian;
		}
		int rightMedian = Math.min(i >= a.length ? Integer.MAX_VALUE : a[i], j >= b.length ? Integer.MAX_VALUE : b[j]);
		return (leftMedian + rightMedian) * 0.5;
	}

	public static void main(String[] args) {
		MedianOfTwoSortedArrays lzr = new MedianOfTwoSortedArrays();
		int[] a = { 1, 2 };
		int[] b = { 3, 4 };
		double result = lzr.median(a, b);
		System.out.print(result);
	}
}