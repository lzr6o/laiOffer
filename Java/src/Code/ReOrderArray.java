package Code;
import java.util.Arrays;

class ReorderArray {
	int[] reorder(int[] arr) {
		if (arr.length % 2 == 0) {
			reorder(arr, 0, arr.length - 1);
		} else {
			reorder(arr, 0, arr.length - 2);
		}
		return arr;
	}

	void reorder(int[] arr, int left, int right) {
		int len = right - left + 1;
		if (len <= 2) {
			return;
		}
		int mid = left + len / 2;
		int lmid = left + len / 4;
		int rmid = left + len * 3 / 4;
		reverse(arr, lmid, mid - 1);
		reverse(arr, mid, rmid - 1);
		reverse(arr, lmid, rmid - 1);
		reorder(arr, left, left + (lmid - left) * 2 - 1);
		reorder(arr, left + (lmid - left) * 2, right);
	}

	void reverse(int[] arr, int left, int right) {
		while (left < right) {
			int tmp = arr[left];
			arr[left] = arr[right];
			arr[right] = tmp;
			left++;
			right--;
		}
	}

	public static void main(String args[]) {
		ReorderArray lzr = new ReorderArray();
		int[] arr = { 1, 2, 3, 4, 5, 6, 7, 8 };
		int[] res = lzr.reorder(arr);
		System.out.print(Arrays.toString(res));
	}
}