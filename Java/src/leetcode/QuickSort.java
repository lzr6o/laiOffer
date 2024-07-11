package leetcode;
import java.util.Arrays;

class QuickSort {
	int[] quickSort(int[] arr) {
		if (arr == null) {
			return arr;
		}
		quickSort(arr, 0, arr.length - 1);
		return arr;
	}

	void quickSort(int[] arr, int left, int right) {
		if (left >= right) {
			return;
		}
		int pivotPos = partition(arr, left, right);
		quickSort(arr, left, pivotPos - 1);
		quickSort(arr, pivotPos + 1, right);
	}

	int partition(int[] arr, int left, int right) {
		int pivotIndex = pivotIndex(left, right);
		int pivot = arr[pivotIndex];
		swap(arr, pivotIndex, right);
		int leftBound = left;
		int rightBound = right - 1;
		while (leftBound <= rightBound) {
			if (arr[leftBound] < pivot) {
				leftBound++;
			} else if (arr[rightBound] >= pivot) {
				rightBound--;
			} else {
				swap(arr, leftBound++, rightBound--);
			}
		}
		swap(arr, leftBound, right);
		return leftBound;
	}

	int pivotIndex(int left, int right) {
		return left + (int) (Math.random() * (right - left + 1));
	}

	void swap(int[] arr, int a, int b) {
		int tmp = arr[a];
		arr[a] = arr[b];
		arr[b] = tmp;
	}

	public static void main(String[] args) {
		QuickSort lzr = new QuickSort();
		int[] arr = { 1, 9, 8, 5, 3 };
		arr = lzr.quickSort(arr);
		System.out.print(Arrays.toString(arr));
	}
}