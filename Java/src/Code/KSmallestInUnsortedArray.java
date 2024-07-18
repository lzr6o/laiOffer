package Code;
import java.util.PriorityQueue;
import java.util.Comparator;

class KSmallestInUnsortedArray {
	int[] kSmallest(int[] arr, int k) {
		if (arr.length == 0 || k == 0) {
			return new int[0];
		}
		PriorityQueue<Integer> maxHeap = new PriorityQueue<Integer>(k, new Comparator<Integer>() {
			@Override
			public int compare(Integer o1, Integer o2) {
				if (o1.equals(o2)) {
					return 0;
				}
				return o1 > o2 ? -1 : 1;
			}
		});
		for (int i = 0; i < arr.length; i++) {
			if (i < k) {
				maxHeap.offer(arr[i]);
			} else if (arr[i] < maxHeap.peek()) {
				maxHeap.poll();
				maxHeap.offer(arr[i]);
			}
		}
		int[] res = new int[k];
		for (int i = k - 1; i >= 0; i--) {
			res[i] = maxHeap.poll();
		}
		return res;
	}

	public static void main(String ars[]) {
		KSmallestInUnsortedArray lzr = new KSmallestInUnsortedArray();
		int[] arr = { 3, 4, 1, 2, 5 };
		int[] res = lzr.kSmallest(arr, 3);
		for (int i = 0; i < res.length; i++) {
			System.out.print(res[i] + " ");
		}
	}
}