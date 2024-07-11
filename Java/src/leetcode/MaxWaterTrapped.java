package leetcode;

class MaxWaterTrapped {
	int maxTrapped(int[] array) {
		int n = array.length;
		int totalWater = 0;
		int lMax = array[0];
		int rMax = array[n - 1];
		int[] leftMax = new int[n];
		int[] rightMax = new int[n];
		for (int i = 0; i <= n - 1; ++i) {
	        lMax = Math.max(array[i], lMax);
	        leftMax[i] = lMax;
	    }
	    for (int i = n - 1; i >= 0; i--) {
	        rMax = Math.max(array[i], rMax);
	        rightMax[i] = rMax;
	    }
		for (int i = 0; i < n; i++) {
		    int water = Math.min(leftMax[i], rightMax[i]) - array[i];
		    totalWater += (water > 0) ? water : 0;
		}
		return totalWater;
	}
	
	public static void main(String[] args) {
		MaxWaterTrapped lzr = new MaxWaterTrapped();
		int[] array = { 2, 1, 3, 2, 4 };
		int result = lzr.maxTrapped(array);
		System.out.print(result);
	}
}