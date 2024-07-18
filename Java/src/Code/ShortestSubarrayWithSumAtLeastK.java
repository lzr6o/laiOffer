package Code;
import java.util.ArrayDeque;
import java.util.Deque;

class ShortestSubarrayWithSumAtLeastK {
	int shortestSubarray(int[] nums, int k) {
        int n = nums.length, res = n + 1;
        long[] dp = new long[n + 1];
        for (int i = 0; i < n; i++) {
        	dp[i + 1] = dp[i] + nums[i];
        }
        Deque<Integer> deque = new ArrayDeque<>();
        for (int i = 0; i < n + 1; i++) {
            while (deque.size() > 0 && dp[i] - dp[deque.getFirst()] >= k) {
                res = Math.min(res, i - deque.pollFirst());
            }
            while (deque.size() > 0 && dp[i] <= dp[deque.getLast()]) {
            	deque.pollLast();
            }
            deque.addLast(i);
        }
        return res <= n ? res : -1;
    }
	
	public static void main(String[] args) {
		ShortestSubarrayWithSumAtLeastK lzr = new ShortestSubarrayWithSumAtLeastK();
		int[] nums = { 2, -1, 2 };
		int k = 3;
		int res = lzr.shortestSubarray(nums, k);
		System.out.print(res);
	}
}