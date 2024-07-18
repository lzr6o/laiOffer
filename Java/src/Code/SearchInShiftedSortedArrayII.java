package Code;
class SearchInShiftedSortedArrayII {
	int search(int[] array, int target) {
		int lo = 0;
		int hi = array.length - 1;
        // find the index of the smallest value using binary search.
        // Loop will terminate since mid < hi, and lo or hi will shrink by at least 1.
        // Proof by contradiction that mid < hi: if mid==hi, then lo==hi and loop would have been terminated.
        while (lo < hi ) {
            int mid = (lo + hi) / 2;
            if(array[mid] > array[hi]) {
            	lo = mid+1;
            } else {
            	hi = mid;
            }
        }
        // lo==hi is the index of the smallest value and also the number of places rotated.
        int rot = lo;
        lo = 0;
        hi = array.length - 1;
        // The usual binary search and accounting for rotation.
        while (lo <= hi ) {
            int mid = (lo + hi) / 2;
            int realmid = (mid + rot) % array.length;
            if (array[realmid] == target) {
            	return realmid;
            }
            if (array[realmid] < target) {
            	lo = mid + 1;
            } else {
            	hi = mid - 1;
            }
        }
        return -1;
	}

	public static void main(String[] args) {
		SearchInShiftedSortedArrayII lzr = new SearchInShiftedSortedArrayII();
		int[] nums = { 1, 1, 1, 1, 3 };
		int target = 1;
		int result = lzr.search(nums, target);
		System.out.print(result);
	}
}