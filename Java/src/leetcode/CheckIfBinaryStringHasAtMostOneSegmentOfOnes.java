package leetcode;

class CheckIfBinaryStringHasAtMostOneSegmentOfOnes {

	boolean checkOnesSegment(String s) {
		int check = 0;
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) == '0') {
				if (check == 1) {
					check++;
				}
			} else {
				if (check == 0) {
					check++;
				} else if (check == 2) {
					return false;
				}
			}
		}
		return true;
	}

	public static void main(String[] args) {
		CheckIfBinaryStringHasAtMostOneSegmentOfOnes lzr = new CheckIfBinaryStringHasAtMostOneSegmentOfOnes();
		String s = "001";
		boolean res = lzr.checkOnesSegment(s);
		System.out.print(res);
	}
}