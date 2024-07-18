package Code;
import java.util.Arrays;

class LargestAndSmallest {
	int[] largestAndSmallest(int[] array) {
		int n = array.length;
		for (int i = 0; i < n / 2; i++) {
			if (array[i] < array[n - 1 - i]) {
				swap(array, i, n - 1 - i);
			}
		}
		return new int[] { largest(array, 0, (n - 1) / 2), smallest(array, n / 2, n - 1)};
	}
	
	int largest(int[] array, int left, int right) {
		int largest = array[left];
		for (int i = left + 1; i <= right; i++) {
			largest = Math.max(largest, array[i]);
		}
		return largest;
	}
	
	int smallest(int[] array, int left, int right) {
		int smallest = array[left];
		for (int i = left + 1; i <= right; i++) {
			smallest = Math.min(smallest, array[i]);
		}
		return smallest;
	}
	
	void swap(int[] array, int i, int j) {
		int tmp = array[i];
		array[i] = array[j];
		array[j] = tmp;
	}
	
	public static void main(String[] args) {
		LargestAndSmallest lzr = new LargestAndSmallest();
		int[] array = { 2, 1, 5, 4, 3 };
		int[] result = lzr.largestAndSmallest(array);
		System.out.print(Arrays.toString(result));
	}
}