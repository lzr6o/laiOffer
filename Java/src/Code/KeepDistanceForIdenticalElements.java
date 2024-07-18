package Code;
import java.util.Arrays;

class KeepDistanceForIdenticalElements {
	int[] keepDistance(int k) {
		int[] array = new int[2 * k];
		return helper(array, k) ? array : null;
	}
	
	boolean helper(int[] array, int n) {
		if (n == 0) {
			return true;
		}
		for (int i = 0; i < array.length - n - 1; i++) {
			if (array[i] == 0 && array[i + n + 1] == 0) {
				array[i] = n;
				array[i + n + 1] = n;
				if (helper(array, n - 1)) {
					return true;
				}
				array[i] = 0;
				array[i + n + 1] = 0;
			}
		}
		return false;
	}
	
	public static void main(String[] args) {
		KeepDistanceForIdenticalElements lzr = new KeepDistanceForIdenticalElements();
		int k = 3;
		int[] result = new int[2 * k];
		result = lzr.keepDistance(k);
		System.out.print(Arrays.toString(result));
	}
}