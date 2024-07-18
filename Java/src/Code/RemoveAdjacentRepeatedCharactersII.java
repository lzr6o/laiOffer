package Code;
class RemoveAdjacentRepeatedCharactersII {
	String deDup(String input) {
		if (input == null || input.length() < 3) {
			return input;
		}
		char[] string = input.toCharArray();
		int slow = 2;
		for (int fast = 2; fast < string.length; fast++) {
			if (string[slow - 2] != string[fast]) {
				string[slow++] = string[fast];
			}
		}
		return new String(string, 0, slow);
	}

	public static void main(String[] args) {
		RemoveAdjacentRepeatedCharactersII lzr = new RemoveAdjacentRepeatedCharactersII();
		String input = "aaaabbbc";
		String result = lzr.deDup(input);
		System.out.print(result);
	}
}