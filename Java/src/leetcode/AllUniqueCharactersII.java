package leetcode;

class AllUniqueCharactersII {

	boolean allUnique(String word) {
		int[] vec = new int[8];
		char[] array = word.toCharArray();
		for (char c : array) {
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
		boolean result = lzr.allUnique(word);
		System.out.print(result);
	}
}