package Code;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

class LargestRectangleOf1s {
	int largest(int[][] input) {
		int temp[] = new int[input[0].length];
		int maxArea = 0;
		int area = 0;
		for (int i = 0; i < input.length; i++) {
			for (int j = 0; j < temp.length; j++) {
				if (input[i][j] == 0) {
					temp[j] = 0;
				} else {
					temp[j] += input[i][j];
				}
			}
			System.out.println();
			System.out.println(Arrays.toString(temp));
			area = largestRect1D(temp);
			maxArea = Math.max(maxArea, area);
		}
		return maxArea;
	}

	int largestRect1D(int[] array) {
		int result = 0;
		Deque<Integer> stack = new ArrayDeque<Integer>();
		for (int i = 0; i <= array.length; i++) {
			int cur = i == array.length ? 0 : array[i];
			if (stack.isEmpty() || array[stack.peekFirst()] < cur) {
				stack.offerFirst(i);
			} else {
				while (!stack.isEmpty() && array[stack.peekFirst()] >= cur) {
					// poll出比cur大的元素 直接出结果， 留着比cur小的元素做后续比较
					int height = array[stack.pollFirst()];
					int left = stack.isEmpty() ? 0 : stack.peekFirst() + 1;
					result = Math.max(result, height * (i - left));
					System.out.println("current i = " + i + ", height = " + height + ", left = " + left + ", result = " + result);
				}
				stack.offerFirst(i);
			}
		}
		return result;
	}

	public static void main(String[] args) {
		LargestRectangleOf1s lzr = new LargestRectangleOf1s();
		int[][] matrix = { { 1, 1, 1, 1 },
				           { 0, 0, 1, 1 },
				           { 1, 0, 1, 1 },
				           { 1, 1, 1, 1 } };
		int result = lzr.largest(matrix);
		System.out.print(result);
	}
}