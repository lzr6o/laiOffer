package leetcode;

class CanPlaceFlowers {
	boolean canPlaceFlowers(int[] flowerbed, int n) {
		int[] arr = new int[flowerbed.length + 2];
		for (int i = 1; i <= flowerbed.length; i++) {
			arr[i] = flowerbed[i - 1];
		}
		for (int i = 1; i < arr.length - 1; i++) {
			if (arr[i - 1] == 0 && arr[i] == 0 && arr[i + 1] == 0) {
				arr[i] = 1;
				n--;
			}
		}
		return n <= 0;
	}

	public static void main(String[] args) {
		CanPlaceFlowers lzr = new CanPlaceFlowers();
		int[] flowerbed = { 1, 0, 0, 0, 1 };
		int n = 2;
		boolean res = lzr.canPlaceFlowers(flowerbed, n);
		System.out.print(res);
	}
}