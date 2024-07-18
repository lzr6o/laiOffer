package Code;

import java.util.Arrays;
import java.util.NoSuchElementException;

class MinHeap {
	int[] arr;
	int size;

	MinHeap(int[] arr) {
		if (arr == null || arr.length == 0) {
			throw new IllegalArgumentException("input array can not be null or empty");
		}
		this.arr = arr;
		size = arr.length;
		heapify();
	}

	void heapify() {
		for (int i = size / 2 - 1; i >= 0; i--) {
			percolateDown(i);
		}
	}

	MinHeap(int cap) {
		if (cap <= 0) {
			throw new IllegalArgumentException("capacity can not be <= 0");
		}
		arr = new int[cap];
		size = 0;
	}

	int size() {
		return size;
	}

	boolean isEmpty() {
		return size == 0;
	}

	boolean isFull() {
		return size == arr.length;
	}

	void percolateUp(int idx) {
		while (idx > 0) {
			int parentIndex = (idx - 1) / 2;
			if (arr[parentIndex] > arr[idx]) {
				swap(parentIndex, idx);
			} else {
				break;
			}
			idx = parentIndex;
		}
	}

	void percolateDown(int idx) {
		while (idx <= size / 2 - 1) {
			int leftChildIndex = idx * 2 + 1;
			int rightChildIndex = idx * 2 + 2;
			int swapCandidate = leftChildIndex;
			if (rightChildIndex <= size - 1 && arr[leftChildIndex] >= arr[rightChildIndex]) {
				swapCandidate = rightChildIndex;
			}
			if (arr[idx] > arr[swapCandidate]) {
				swap(idx, swapCandidate);
			} else {
				break;
			}
			idx = swapCandidate;
		}
	}

	void swap(int i, int j) {
		int tmp = arr[i];
		arr[i] = arr[j];
		arr[j] = tmp;
	}

	int peek() {
		if (size == 0) {
			throw new NoSuchElementException("heap is empty");
		}
		return arr[0];
	}

	int poll() {
		if (size == 0) {
			throw new NoSuchElementException("heap is empty");
		}
		int res = arr[0];
		arr[0] = arr[size - 1];
		size--;
		percolateDown(0);
		return res;
	}

	void offer(int ele) {
		if (size == arr.length) {
			arr = Arrays.copyOf(arr, (int) (arr.length * 1.5));
		}
		arr[size] = ele;
		size++;
		percolateUp(size - 1);
	}

	int update(int idx, int ele) {
		if (idx < 0 || idx > size - 1) {
			throw new ArrayIndexOutOfBoundsException("invalid index range");
		}
		int result = arr[idx];
		arr[idx] = ele;
		if (result > ele) {
			percolateUp(idx);
		} else {
			percolateDown(idx);
		}
		return result;
	}

	public static void main(String args[]) {
		int[] arr = { 5, 3, 1, 2, 4 };
		MinHeap lzr = new MinHeap(arr);
		System.out.println(lzr.isEmpty());
		System.out.println(lzr.size);
	}
}