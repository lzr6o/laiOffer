package Code;

class AllUniqueCharactersII {
	boolean allUnique(String word) {
		int[] vec = new int[8];
		char[] arr = word.toCharArray();
		for (char c : arr) {
			if ((vec[c / 32] >>> (c % 32) & 1) != 0) {
				return false;
			}
			vec[c / 32] |= 1 << (c % 32);
		}
		return true;
	}
	
	public static void main(String[] args) {
		AllUniqueCharactersII lzr = new AllUniqueCharactersII();
		String word = "abA+a88";
		boolean res = lzr.allUnique(word);
		System.out.print(res);
	}
}