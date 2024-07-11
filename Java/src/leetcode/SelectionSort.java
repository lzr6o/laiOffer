package leetcode;
import java.util.Arrays;

class SelectionSort {
	int[] selectionSort(int[] arr) {
		if (arr == null || arr.length <= 1) {
			return arr;
		}
		for (int i = 0; i < arr.length - 1; i++) {
			int min = i;
			for (int j = i + 1; j < arr.length; j++) {
				if (arr[j] < arr[min]) {
					min = j;
				}
			}
			swap(arr, i, min);
		}
		return arr;
	}

	void swap(int[] arr, int a, int b) {
		int tmp = arr[a];
		arr[a] = arr[b];
		arr[b] = tmp;
	}

	public static void main(String[] args) {
		SelectionSort lzr = new SelectionSort();
		int[] array = { 4, 2, -3, 6, 1 };
		array = lzr.selectionSort(array);
		System.out.print(Arrays.toString(array));
	}
}