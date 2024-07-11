package leetcode;
import java.util.Arrays;

class MergeSortedArray {
	void merge(int[] nums1, int m, int[] nums2, int n) {
		while (m > 0 && n > 0) {
			if (nums1[m - 1] > nums2[n - 1]) {
				nums1[m + n - 1] = nums1[m - 1];
				m--;
			} else {
				nums1[m + n - 1] = nums2[n - 1];
				n--;
			}
		}
		while (n > 0) {
			nums1[n - 1] = nums2[n - 1];
			n--;
		}
	}

	public static void main(String[] args) {
		MergeSortedArray lzr = new MergeSortedArray();
		int[] nums1 = { 1, 2, 3, 0, 0, 0 }, nums2 = { 2, 5, 6 };
		int m = 3, n = 3;
		lzr.merge(nums1, m, nums2, n);
		System.out.print(Arrays.toString(nums1));
	}
}