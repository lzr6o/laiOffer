package Code;
class RemoveAdjacentRepeatedCharactersIII {
	String deDup(String input) {
		if (input == null || input.length() < 2) {
			return input;
		}
		char[] array = input.toCharArray();
		int slow = 0;
		for (int fast = 0; fast < array.length; fast++) {
			if (fast + 1 < array.length && array[fast] == array[fast + 1]) {
				while (fast + 1 < array.length && array[fast] == array[fast + 1]) {
					fast++;
				}
			} else {
				array[slow++] = array[fast];
			}
		}
		return new String(array, 0, slow);
	}
	
	public static void main(String[] args) {
		RemoveAdjacentRepeatedCharactersIII lzr = new RemoveAdjacentRepeatedCharactersIII();
		String input = "caaaabbbc";
		String result = lzr.deDup(input);
		System.out.print(result);
	}
}