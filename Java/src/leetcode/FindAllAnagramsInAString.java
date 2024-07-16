package leetcode;

import java.util.List;

class FindAllAnagramsInAString {
	List<Integer> findAnagrams(String s, String p) {
        
    }
	
	public static void main(String[] args) {
		FindAllAnagramsInAString lzr = new FindAllAnagramsInAString();
		String s = "abab";
		String p = "ab";
		List<Integer> res = lzr.findAnagrams(s, p);
		System.out.print(res);
	}
}