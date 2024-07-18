package Code;
import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

class AllValidPermutationsOfParenthesesII {
	final char[] PS = new char[] { '(', ')', '<', '>', '{', '}' };
	
	List<String> validParentheses(int l, int m, int n) {
		int[] remain = new int[] { l, l, m, m, n, n };
		int targetLen = 2 * l + 2 * m + 2 * n;
		StringBuilder cur = new StringBuilder();
		Deque<Character> stack = new LinkedList<>();
		List<String> res = new ArrayList<>();
		helper(cur, stack, remain, targetLen, res);
		return res;
	}
	
	void helper(StringBuilder cur, Deque<Character> stack, int[] remain, int targetLen, List<String> result) {
		if (cur.length() == targetLen) {
			result.add(cur.toString());
			return;
		}
		for (int i = 0; i < remain.length; i++) {
			if (i % 2 == 0) {
				if (remain[i] > 0) {
					cur.append(PS[i]);
					stack.offerFirst(PS[i]);
					remain[i]--;
					helper(cur, stack, remain, targetLen, result);
					cur.deleteCharAt(cur.length() - 1);
					stack.pollFirst();
					remain[i]++;
				}
			} else {
				if (!stack.isEmpty() && stack.peekFirst() == PS[i - 1]) {
					cur.append(PS[i]);
					stack.pollFirst();
					remain[i]--;
					helper(cur, stack, remain, targetLen, result);
					cur.deleteCharAt(cur.length() - 1);
					stack.offerFirst(PS[i - 1]);
					remain[i]++;
				}
			}
		}
	}
	
	public static void main(String[] args) {
		AllValidPermutationsOfParenthesesII lzr = new AllValidPermutationsOfParenthesesII();
		int l = 2;
		int m = 1;
		int n = 0;
		List<String> res = new ArrayList<>();
		res = lzr.validParentheses(l, m, n);
		System.out.print(res);
	}
}