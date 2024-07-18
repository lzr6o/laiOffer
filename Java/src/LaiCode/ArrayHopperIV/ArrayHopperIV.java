package LaiCode.ArrayHopperIV;

import java.util.Arrays;

class ArrayHopperIV {

	int minJump(int[] arr, int idx) {
		int len = arr.length;
		if (idx < 0 || idx >= len) {
			return -1;
		}
		if (idx == len - 1) {
			return 0;
		}
		int[] minJump = new int[len];
		Arrays.fill(minJump, -1);
		minJump[len - 1] = 0;
		for (int i = len - 2; i >= 0; i--) {
			if (arr[i] + i >= len - 1) {
				minJump[i] = 1;
				continue;
			}
			for (int j = i + 1; j < len; j++) {
				if (minJump[j] != -1 && i + arr[i] >= j) {
					minJump[i] = minJump[i] == -1 ? minJump[j] + 1 : Math.min(minJump[i], minJump[j] + 1);
				}
			}
		}
		for (int i = 1; i < len - 1; i++) {
			for (int j = 0; j < i; j++) {
				if (minJump[j] != -1 && i - arr[i] <= j) {
					minJump[i] = minJump[i] == -1 ? minJump[j] + 1 : Math.min(minJump[i], minJump[j] + 1);
				}
			}
		}
		return minJump[idx];
	}

	public static void main(String[] args) {
		ArrayHopperIV lzr = new ArrayHopperIV();
		int[] arr = { 1, 3, 1, 2, 2 };
		int idx = 2;
		int res = lzr.minJump(arr, idx);
		System.out.print(res);
	}
}