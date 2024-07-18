package Code;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

class PlaceToPutTheChairII {
	final char EQUIP = 'E';
	
	List<Integer> putChair(char[][] gym) {
		List<Integer> row = new ArrayList<>();
		List<Integer> col = new ArrayList<>();
		int M = gym.length;
		int N = gym[0].length;
		for (int i = 0; i < M; i++) {
			for (int j = 0; j < N; j++) {
				if (gym[i][j] == EQUIP) {
					row.add(i);
					col.add(j);
				}
			}
		}
		Collections.sort(row);
		Collections.sort(col);
		return Arrays.asList(row.get(row.size()/2), col.get(col.size()/2));
	}
	
	public static void main(String[] args) {
		PlaceToPutTheChairII lzr = new PlaceToPutTheChairII();
		char[][] gym = { {'E', ' ', ' ' },
				         {' ', 'E', ' ' },
				         {' ', ' ', 'E' } };
		List<Integer> result = lzr.putChair(gym);
		System.out.print(result);
	}
}