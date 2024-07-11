package leetcode;

import java.util.Arrays;

class GetCountArray {
	int[] countArray(int[] arr) {
		int[] indexArr = initialIndexArray(arr);
		int[] countArr = new int[arr.length];
		int[] helper = new int[arr.length];
		mergeSort(arr, indexArr, countArr, helper, 0, arr.length - 1);
		return countArr;
	}

	int[] initialIndexArray(int[] arr) {
		int[] indices = new int[arr.length];
		for (int i = 0; i < arr.length; i++) {
			indices[i] = i;
		}
		return indices;
	}

	void mergeSort(int[] arr, int[] indexArr, int[] countArr, int[] helper, int left, int right) {
		if (left >= right) {
			return;
		}
		int mid = left + (right - left) / 2;
		mergeSort(arr, indexArr, countArr, helper, left, mid);
		mergeSort(arr, indexArr, countArr, helper, mid + 1, right);
		merge(arr, indexArr, countArr, helper, left, mid, right);
	}

	void merge(int[] arr, int[] indexArr, int[] countArr, int[] helper, int left, int mid, int right) {
		copyArray(indexArr, helper, left, right);
		int l = left;
		int r = mid + 1;
		int cur = left;
		while (l <= mid) {
			if (r > right || arr[helper[l]] <= arr[helper[r]]) {
				countArr[helper[l]] += (r - mid - 1);
				indexArr[cur++] = helper[l++];
			} else {
				indexArr[cur++] = helper[r++];
			}
		}
	}

	void copyArray(int[] indexArr, int[] helper, int left, int right) {
		for (int i = left; i <= right; i++) {
			helper[i] = indexArr[i];
		}
	}

	public static void main(String[] args) {
		GetCountArray lzr = new GetCountArray();
		int[] arr = {4, 1, 3, 2};
		int[] res = lzr.countArray(arr);
		System.out.print(Arrays.toString(res));
	}
}