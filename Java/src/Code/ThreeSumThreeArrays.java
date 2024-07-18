package Code;
import java.util.Arrays;

class ThreeSumThreeArrays {
	boolean exist(int[] a, int[] b, int[] c, int target) {
		Arrays.sort(a);
		Arrays.sort(b);
		for (int num : c) {
			int i = 0;
			int j = b.length - 1;
			while (i < a.length && j >= 0) {
				int sum = a[i] + b[j] + num;
				if (sum == target) {
					return true;
				} else if (sum < target) {
					i++;
				} else {
					j--;
				}
			}
		}
		return false;
	}

	public static void main(String[] args) {
		ThreeSumThreeArrays lzr = new ThreeSumThreeArrays();
		int[] a = { 1, 3, 5 };
		int[] b = { 8, 2 };
		int[] c = { 3 };
		int target = 14;
		boolean result = lzr.exist(a, b, c, target);
		System.out.print(result);
	}
}