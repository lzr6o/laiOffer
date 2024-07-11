package leetcode;
class PushDominoes {
	String pushDominoes(String dominoes) {
		char[] arr = dominoes.toCharArray();
		int L = -1, R = -1, idx = 0;
		for (int i = 0; i < dominoes.length(); i++) {
			char cur = arr[i];
			R = cur == 'R' ? i : R;
			L = cur == 'L' ? i : L;
			if (R < L && R != -1 && L != -1) {
				while (R < L) {
					arr[R++] = 'R';
					arr[L--] = 'L';
				}
				L = R = -1;
			}
			
		}
		return new String(arr);
	}
	
	public static void main(String[] args) {
		PushDominoes lzr = new PushDominoes();
		String dominoes = "R.R.L";
		String res = lzr.pushDominoes(dominoes);
		System.out.print(res);
	}
}