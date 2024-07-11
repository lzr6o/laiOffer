package leetcode;

class ArrayHopperIII {

	int minJump(int[] array) {
		int[] minJump = new int[array.length + 1];
		for (int i = 1; i < minJump.length; i++) {
			minJump[i] = -1;
			for (int j = 0; j < i; j++) {
				if (minJump[j] != -1 && array[j] + j >= i) {
					minJump[i] = (minJump[i] == -1) ? (minJump[j] + 1) : Math.min(minJump[i], minJump[j] + 1);
				}
			}
		}
		return minJump[minJump.length - 1];
	}

	public static void main(String[] args) {
		ArrayHopperIII lzr = new ArrayHopperIII();
		int[] array = { 1, 3, 2, 0, 2 };
		int result = lzr.minJump(array);
		System.out.print(result);
	}
}