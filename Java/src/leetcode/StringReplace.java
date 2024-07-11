package leetcode;
import java.util.ArrayList;

class StringReplace {
	String replace(String input, String source, String target) {
		char[] array = input.toCharArray();
		if (source.length() >= target.length()) {
			return replaceShorter(array, source, target);
		}
		return replaceLonger(array, source, target);
	}

	String replaceShorter(char[] input, String s, String t) {
		int slow = 0;
		int fast = 0;
		while (fast < input.length) {
			if (fast <= input.length - s.length() && equalSubstring(input, fast, s)) {
				copySubstring(input, slow, t);
				slow += t.length();
				fast += s.length();
			} else {
				input[slow++] = input[fast++];
			}
		}
		return new String(input, 0, slow);
	}

	String replaceLonger(char[] input, String s, String t) {
		ArrayList<Integer> matches = getAllMatches(input, s);
		char[] result = new char[input.length + matches.size() * (t.length() - s.length())];
		int lastIndex = matches.size() - 1;
		int fast = input.length - 1;
		int slow = result.length - 1;
		while (fast >= 0) {
			if (lastIndex >= 0 && fast == matches.get(lastIndex)) {
				copySubstring(result, slow - t.length() + 1, t);
				slow -= t.length();
				fast -= s.length();
				lastIndex--;
			} else {
				result[slow--] = input[fast--];
			}
		}
		return new String(result);
	}

	boolean equalSubstring(char[] input, int fromIndex, String s) {
		for (int i = 0; i < s.length(); i++) {
			if (input[fromIndex + i] != s.charAt(i)) {
				return false;
			}
		}
		return true;
	}

	void copySubstring(char[] result, int fromIndex, String t) {
		for (int i = 0; i < t.length(); i++) {
			result[fromIndex + i] = t.charAt(i);
		}
	}

	ArrayList<Integer> getAllMatches(char[] input, String s) {
		ArrayList<Integer> matches = new ArrayList<Integer>();
		int i = 0;
		while (i <= input.length - s.length()) {
			if (equalSubstring(input, i, s)) {
				matches.add(i + s.length() - 1);
				i += s.length();
			} else {
				i++;
			}
		}
		return matches;
	}

	public static void main(String[] args) {
		StringReplace lzr = new StringReplace();
		String input = "dodododo";
		String source = "dod";
		String target = "a";
		String result = lzr.replace(input, source, target);
		System.out.print(result);
	}
}