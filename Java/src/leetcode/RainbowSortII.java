package leetcode;
import java.util.Arrays;

class RainbowSortII {
	int[] rainbowSort(int[] array) {
		if (array == null || array.length <= 1) {
			return array;
		}
		int zero = 0;
		int one = 0;
		int two = array.length - 1;
		int three = array.length - 1;
		while (one <= two) {
			if (array[one] == 0) {
				swap(array, zero++, one++);
			} else if (array[one] == 1) {
				one++;
			} else if (array[one] == 2) {
				swap(array, two--, one);
			} else if (array[one] == 3) {
				swap(array, two, one);
				swap(array, three--, two--);
			}
		}
		return array;
	}

	void swap(int[] array, int a, int b) {
		int tmp = array[a];
		array[a] = array[b];
		array[b] = tmp;
	}

	public static void main(String[] args) {
		RainbowSortII lzr = new RainbowSortII();
		int[] array = { 1, 3, 0, 2, 0, 0, 1 };
		int[] result = lzr.rainbowSort(array);
		System.out.print(Arrays.toString(result));
	}
}