package Code;
import java.util.HashSet;
import java.util.Set;

class RemoveCertainCharacters {
	String remove(String input, String t) {
		char[] arr = input.toCharArray();
		Set<Character> set = buildSet(t);
		int slow = 0;
		for (int fast = 0; fast < arr.length; fast++) {
			if (!set.contains(arr[fast])) {
				arr[slow++] = arr[fast];
			}
		}
		return new String(arr, 0, slow);
	}
	
	Set<Character> buildSet(String t) {
		Set<Character> set = new HashSet<>();
		for (int i = 0; i < t.length(); i++) {
			set.add(t.charAt(i));
		}
		return set;
	}
	
	public static void main(String args[]) {
		RemoveCertainCharacters lzr = new RemoveCertainCharacters();
		String input = "student";
		String t = "un";
		String res = lzr.remove(input, t);
		System.out.print(res);
	}
}