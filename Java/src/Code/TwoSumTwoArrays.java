package Code;
import java.util.Arrays;

class TwoSumTwoArrays {
	boolean existSum(int[] a, int[] b, int target) {
		Arrays.sort(a);
		Arrays.sort(b);
		int i = 0;
		int j = b.length - 1;
		while (i < a.length && j >= 0) {
			int sum = a[i] + b[j];
			if (sum == target) {
				return true;
			} else if (sum < target) {
				i++;
			} else {
				j--;
			}
		}
		return false;
	}
	
	public static void main(String[] args) {
		TwoSumTwoArrays lzr = new TwoSumTwoArrays();
		int[] a = { 2, 8 };
		int[] b = { 3, 1, 5 };
		int target = 8;
		boolean result = lzr.existSum(a, b, target);
		System.out.print(result);
	}
}