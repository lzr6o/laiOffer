package leetcode;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class PlaceToPutTheChair {
	final char EQUIP = 'E';
	final char OB = 'O';
	
	class Pair {
		int i;
		int j;
		Pair(int i, int j) {
			this.i = i;
			this.j = j;
		}
	}
	
	List<Integer> putChair(char[][] gym) {
		int M = gym.length;
		int N = gym[0].length;
		int[][] cost = new int[M][N];
		for (int i = 0; i < M; i++) {
			for (int j = 0; j < N; j++) {
				if (EQUIP == gym[i][j]) {
					if (!addCost(cost, gym, i, j)) {
						return Arrays.asList(-1, -1);
					}
				}
			}
		}
		List<Integer> result = null;
		for (int i = 0; i < M; i++) {
			for (int j = 0; j < N; j++) {
				if (EQUIP != gym[i][j] && OB != gym[i][j]) {
					if (result == null) {
						result = Arrays.asList(i, j);
					} else if (cost[i][j] < cost[result.get(0)][result.get(1)]) {
						result.set(0, i);
						result.set(1, j);
					}
				}
			}
		}
		return result == null ? Arrays.asList(-1, -1) : result;
	}
	
	boolean addCost(int[][] cost, char[][] gym, int i, int j) {
		boolean[][] visited = new boolean[gym.length][gym[0].length];
		int pathCost = 1;
		Queue<Pair> queue = new LinkedList<>();
		visited[i][j] = true;
		queue.offer(new Pair(i, j));
		while (!queue.isEmpty()) {
			int size = queue.size();
			for (int l = 0; l < size; l++) {
				Pair cur = queue.poll();
				List<Pair> neis = getNeis(cur, gym);
				for (Pair nei : neis) {
					if (!visited[nei.i][nei.j]) {
						visited[nei.i][nei.j] = true;
						cost[nei.i][nei.j] += pathCost;
						queue.offer(nei);
					}
				}
			}
			pathCost++;
		}
		for (int l = 0; l < gym.length; l++) {
			for (int m = 0; m < gym[0].length; m++) {
				if (!visited[l][m] && EQUIP == gym[l][m]) {
					return false;
				}
			}
		}
		return true;
	}
	
	List<Pair> getNeis(Pair cur, char[][] gym) {
		int x = cur.i;
		int y = cur.j;
		int M = gym.length;
		int N = gym[0].length;
		List<Pair> neis = new ArrayList<>();
		if (x + 1 < M && OB != gym[x + 1][y]) {
			neis.add(new Pair(x + 1, y));
		}
		if (y + 1 < N && OB != gym[x][y + 1]) {
			neis.add(new Pair(x, y + 1));
		}
		if (x - 1 >= 0 && OB != gym[x - 1][y]) {
			neis.add(new Pair(x - 1, y));
		}
		if (y - 1 >= 0 && OB != gym[x][y - 1]) {
			neis.add(new Pair(x, y - 1));
		}
		return neis;
	}
	
	public static void main(String[] args) {
		PlaceToPutTheChair lzr = new PlaceToPutTheChair();
		char[][] gym = new char[][] { { 'E', 'O', 'C' },
			                          { 'C', 'E', 'C' },
			                          { 'C', 'C', 'C' } };
		List<Integer> result = lzr.putChair(gym);
		System.out.print(result);
	}
}