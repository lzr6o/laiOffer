package Code;
class MinimumWindowSubstring {
	String minWindow(String s, String t) {
		int min = Integer.MAX_VALUE, head = 0, i = 0, j = 0, count = t.length();
		int[] cnt = new int[128];
		for (char c : t.toCharArray()) {
			cnt[c]++;
		}
		while (j < s.length()) {
			if (--cnt[s.charAt(j++)] >= 0) {
				count--;
			}
			while (count == 0) {
				if (j - i < min) {
					min = j - i;
					head = i;
				}
				if (cnt[s.charAt(i++)]++ >= 0) {
					count++;
				}
			}
		}
		return min == Integer.MAX_VALUE ? "" : s.substring(head, head + min);
	}

	public static void main(String[] args) {
		MinimumWindowSubstring lzr = new MinimumWindowSubstring();
		String s = "cabwefgewcwaefgcf";
		String t = "cae";
		String res = lzr.minWindow(s, t);
		System.out.print(res);
	}
}