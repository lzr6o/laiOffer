package leetcode;

import java.util.Arrays;

class LargestSubMatrixProduct {
	double largest(double[][] matrix) {
		int ROWS = matrix.length, COLS = matrix[0].length;
		double res = Integer.MIN_VALUE;
		for (int i = 0; i < ROWS; i++) {
			double[] cur = new double[COLS];
			Arrays.fill(cur, 1);
			for (int j = i; j < ROWS; j++) {
				mul(cur, matrix[j]);
				res = Math.max(res, max(cur));
			}
		}
		return res;
	}

	void mul(double[] cur, double[] mul) {
		for (int i = 0; i < cur.length; i++) {
			cur[i] *= mul[i];
		}
	}

	double max(double[] cur) {
		double min, max, res;
		min = max = 1;
		res = Integer.MIN_VALUE;
		for (double num : cur) {
			double minPro = num * min;
			double maxPro = num * max;
			min = Math.min(Math.min(minPro, maxPro), num);
			max = Math.max(Math.max(minPro, maxPro), num);
			res = Math.max(res, max);
		}
		return res;
	}

	public static void main(String[] args) {
		LargestSubMatrixProduct lzr = new LargestSubMatrixProduct();
		double[][] matrix = { { 1, -0.2, -1 }, { 1, -1.5, 1 }, { 0, 0, 1 } };
		double res = lzr.largest(matrix);
		System.out.print(res);
	}
}