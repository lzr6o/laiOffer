package Code;
class KthSmallestInTwoSortedArrays {
	int kth(int[] a, int[] b, int k) {
		return kth(a, 0, b, 0, k);
	}
	
	int kth(int[] a, int aleft, int[] b, int bleft, int k) {
		if (aleft >= a.length) {
			return b[bleft + k - 1];
		}
		if (bleft >= b.length) {
			return a[aleft + k - 1];
		}
		if (k == 1) {
			return Math.min(a[aleft], b[bleft]);
		}
		int amid = aleft + k / 2 - 1;
		int bmid = bleft + k / 2 - 1;
		int aval = amid >= a.length ? Integer.MAX_VALUE : a[amid];
		int bval = bmid >= b.length ? Integer.MAX_VALUE : b[bmid];
		if (aval <= bval) {
			return kth(a, amid + 1, b, bleft, k - k / 2);
		} else {
			return kth(a, aleft, b, bmid + 1, k - k / 2);
		}
	}
	
	public static void main(String[] args) {
		KthSmallestInTwoSortedArrays lzr = new KthSmallestInTwoSortedArrays();
		int[] a = { 1, 4, 6 };
		int[] b = { 2, 3 };
		int k = 3;
		int result = lzr.kth(a, b, k);
		System.out.print(result);
	}
}