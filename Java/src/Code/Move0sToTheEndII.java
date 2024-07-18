package Code;
import java.util.Arrays;

class Move0sToTheEndII {
	int[] moveZero(int[] array) {
		if (array.length <= 1) {
			return array;
		}
		int end = 0;
		for (int i = 0; i < array.length; i++) {
			if (array[i] != 0) {
				array[end++] = array[i];
			}
		}
		for (int i = end; i < array.length; i++) {
			array[i] = 0;
		}
		return array;
	}
	
	public static void main(String[] args) {
		Move0sToTheEndII lzr = new Move0sToTheEndII();
		int[] array = { 1, 0, 3, 0, 1 };
		int[] result = lzr.moveZero(array);
		System.out.print(Arrays.toString(result));
	}
}