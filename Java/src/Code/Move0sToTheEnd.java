package Code;
import java.util.Arrays;

class Move0sToTheEnd {
	int[] moveZero(int[] arr) {
		if (arr == null || arr.length <= 1) {
			return arr;
		}
		int left = 0;
		int right = arr.length - 1;
		while (left <= right) {
			if (arr[left] != 0) {
				left++;
			} else if (arr[right] == 0) {
				right--;
			} else {
				swap(arr, left++, right--);
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
		Move0sToTheEnd lzr = new Move0sToTheEnd();
		int[] array = { 1, 0, -4, -5, 0, 2, 3 };
		int[] result = lzr.moveZero(array);
		System.out.print(Arrays.toString(result));
	}
}