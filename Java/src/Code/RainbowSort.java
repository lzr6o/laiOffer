package Code;
import java.util.Arrays;

class RainbowSort {
	int[] rainbowSort(int[] arr) {
		if (arr == null || arr.length <= 1) {
			return arr;
		}
		int neg = 0;
		int one = arr.length - 1;
		int zero = 0;
		while (zero <= one) {
			if (arr[zero] == -1) {
				swap(arr, neg++, zero++);
			} else if (arr[zero] == 0) {
				zero++;
			} else {
				swap(arr, zero, one--);
			}
		}
		return arr;
	}

	void swap(int[] arr, int a, int b) {
		int tmp = arr[a];
		arr[a] = arr[b];
		arr[b] = tmp;
	}

	public static void main(String[] args) {
		RainbowSort lzr = new RainbowSort();
		int[] arr = { 1, 0, 1, -1, 0 };
		arr = lzr.rainbowSort(arr);
		System.out.print(Arrays.toString(arr));
	}
}