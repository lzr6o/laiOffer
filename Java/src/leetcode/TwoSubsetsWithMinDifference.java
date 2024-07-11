package leetcode;
class TwoSubsetsWithMinDifference {
    int minDifference(int arr[]) {
    	if (arr == null || arr.length == 0) {
    		return 0;
    	}
    	int arrSum = 0;
    	for (int num : arr) {
    		arrSum += num;
    	}
    	int[] min = new int[] { Integer.MAX_VALUE };
        helper(arr, arrSum, 0, 0, 0, min);
        return min[0];
    }
    
    void helper(int[] arr, int arrSum, int sum, int index, int count, int[] min) {
    	if (count == arr.length/2) {
    		min[0] = Math.min(min[0], Math.abs((arrSum - sum) - sum));
    	}
    	if (index == arr.length) {
    		return;
    	}
    	helper(arr, arrSum, sum + arr[index], index + 1, count + 1, min);
    	helper(arr, arrSum, sum, index + 1, count, min);
    }
    
    public static void main(String[] args)
    {
    	TwoSubsetsWithMinDifference lzr = new TwoSubsetsWithMinDifference();
        int arr[] = { 1, 2, 3 };
        int res = lzr.minDifference(arr);
        System.out.print(res);
    }
}