package Code;

class EditDistance {

	int editDistance(String one, String two) {
		int[][] dp = new int[one.length() + 1][two.length() + 1];
		for (int i = 0; i <= one.length(); i++) {
			for (int j = 0; j <= two.length(); j++) {
				if (i == 0) {
					dp[i][j] = j;
				} else if (j == 0) {
					dp[i][j] = i;
				} else if (one.charAt(i - 1) == two.charAt(j - 1)) {
					dp[i][j] = dp[i - 1][j - 1];
				} else {
					int insert = dp[i][j - 1] + 1;
	                int replace = dp[i - 1][j - 1] + 1;
	                int delete = dp[i - 1][j] + 1;
	                dp[i][j] = Math.min(Math.min(insert, replace), delete);
				}
			}
		}
		return dp[one.length()][two.length()];
	}
	
	public static void main(String[] args) {
		EditDistance lzr = new EditDistance();
		String one = "sigh";
		String two = "asith";
		int res = lzr.editDistance(one, two);
		System.out.print(res);
	}
}