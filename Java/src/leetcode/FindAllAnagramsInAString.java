package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class FindAllAnagramsInAString {
	List<Integer> findAnagrams(String s, String p) {
		List<Integer> res = new ArrayList<>();
		if (p.length() > s.length()) {
			return res;
		}
		int L = 0, R = 0;
		int[] sCnt = new int[26], pCnt = new int[26];
		for (int i = 0; i < p.length(); i++) {
			sCnt[s.charAt(i) - 'a']++;
			pCnt[p.charAt(i) - 'a']++;
		}
		if (Arrays.equals(sCnt, pCnt)) {
			res.add(0);
		}
		for (R = p.length(); R < s.length(); R++) {
			sCnt[s.charAt(R) - 'a']++;
			sCnt[s.charAt(L) - 'a']--;
			L++;
			if (Arrays.equals(sCnt, pCnt)) {
				res.add(L);
			}
		}
		return res;
	}

	public static void main(String[] args) {
		FindAllAnagramsInAString lzr = new FindAllAnagramsInAString();
		String s = "cbaebabacd";
		String p = "abc";
		List<Integer> res = lzr.findAnagrams(s, p);
		System.out.print(res);
	}
}