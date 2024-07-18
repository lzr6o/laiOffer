package Code;
class ReplacementsOfAAndB {
	int minReplacements(String str) {
		int cntB = 0, dp = 0; // 令dp表示将s[0,i]变平衡最少需要删除的次数
		for (char c : str.toCharArray()) {
			if (c == 'a') {
				dp = Math.min(dp + 1, cntB); // 末尾出现a的时候，2个选择：1、删除这个a，然后将s[0,i-1]变平衡；2、保留这个a，删除前面所有的b
			} else {
				++cntB; // 出现b的时候，最后面的b不需要删除，dp不变，b的个数加1就好
			}
		}
		return dp;
	}

	public static void main(String[] args) {
		ReplacementsOfAAndB lzr = new ReplacementsOfAAndB();
		String str = "abba";
		int res = lzr.minReplacements(str);
		System.out.print(res);
	}
}