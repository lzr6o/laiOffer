package Code;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

class SortInSpecifiedOrder {
	int[] sortSpecial(int[] a, int[] b) {
		int[] res = new int[a.length];
		int tail = a.length - 1;
		Map<Integer, Integer> map = new HashMap<>();
		for (int num : b) {
			map.put(num, 0);
		}
		for (int num : a) {
			if (map.containsKey(num)) {
				int n = map.get(num);
				map.put(num, n + 1);
			} else {
				res[tail--] = num;
			}
		}
		int i = 0;
		for (int num : b) {
			int c = map.get(num);
			while (c > 0) {
				res[i++] = num;
				c--;
			}
		}
		Arrays.sort(res, i, res.length);
		return res;
	}
	
	public static void main(String[] args) {
		SortInSpecifiedOrder lzr = new SortInSpecifiedOrder();
		int[] a = { 2, 1, 2, 5, 7, 1, 9, 3 };
		int[] b = { 2, 1, 3 };
		int[] result = lzr.sortSpecial(a, b);
		System.out.print(Arrays.toString(result));
	}
}