package leetcode;
import java.util.Arrays;
import java.util.NoSuchElementException;

class MinHeap {
	int[] array;
	int size;
	MinHeap(int[] array) {
		if (array == null || array.length == 0) {
			throw new IllegalArgumentException("input array can not be null or empty");
		}
		this.array = array;
		size = array.length;
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
		array = new int[cap];
		size = 0;
	}
	
	int size() {
		return size;
	}
	
	boolean isEmpty() {
		return size == 0;
	}
	
	boolean isFull() {
		return size == array.length;
	}
	
	void percolateUp(int index) {
		while (index > 0) {
			int parentIndex = (index - 1) / 2;
			if (array[parentIndex] > array[index]) {
				swap(parentIndex, index);
			} else {
				break;
			}
			index = parentIndex;
		}
	}
	
	void percolateDown(int index) {
		while (index <= size / 2 - 1) {
			int leftChildIndex = index * 2 + 1;
			int rightChildIndex = index * 2 + 2;
			int swapCandidate = leftChildIndex;
			if (rightChildIndex <= size - 1 && array[leftChildIndex] >= array[rightChildIndex]) {
				swapCandidate = rightChildIndex;
			}
			if (array[index] > array[swapCandidate]) {
				swap(index, swapCandidate);
			} else {
				break;
			}
			index = swapCandidate;
		}
	}
	
	void swap(int i, int j) {
		int tmp = array[i];
		array[i] = array[j];
		array[j] = tmp;
	}
	
	int peek() {
		if (size == 0) {
			throw new NoSuchElementException("heap is empty");
		}
		return array[0];
	}
	
	int poll() {
		if (size == 0) {
			throw new NoSuchElementException("heap is empty");
		}
		int result = array[0];
		array[0] = array[size - 1];
		size--;
		percolateDown(0);
		return result;
	}
	
	void offer(int ele) {
		if (size == array.length) {
			array = Arrays.copyOf(array, (int)(array.length * 1.5));
		}
		array[size] = ele;
		size++;
		percolateUp(size - 1);
	}
	
	int update(int index, int ele) {
		if (index < 0 || index > size - 1) {
			throw new ArrayIndexOutOfBoundsException("invalid index range");
		}
		int result = array[index];
		array[index] = ele;
		if (result > ele) {
			percolateUp(index);
		} else {
			percolateDown(index);
		}
		return result;
	}
	
	public static void main(String args[]) {
		int[] array = { 5, 3, 1, 2, 4 };
		MinHeap lzr = new MinHeap(array);
		System.out.println(lzr.isEmpty());
		System.out.println(lzr.size);
	}
}