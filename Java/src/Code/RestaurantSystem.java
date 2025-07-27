package Code;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.PriorityQueue;
import java.util.Comparator;

/*
 统计食堂消费
 每个食堂都有自己的ID，分别为早餐、午餐、晚餐3种类型，用mealType表示（1是早餐，2是午餐，3是晚餐）。
 消费者会去各个食堂消费，通过实现以下几个函数，统计每个食堂的总收入。
 */
public class RestaurantSystem {
	//map是全局变量
	Map<Integer, int[]> map = new HashMap<>();

	// TODO Auto-generated method stub
	RestaurantSystem() {

	}

	// 某个餐厅某顿饭的营业额，实时更新
	void receive(int restaurantId, int mealType, int money) {
		if (!map.containsKey(restaurantId)) {
			map.put(restaurantId, new int[] { 0, 0, 0,0 });
		}
		map.get(restaurantId)[mealType - 1] += money;
		map.get(restaurantId)[3] += money;
		System.out.println("餐厅" + restaurantId + " " + Arrays.toString(map.get(restaurantId)));
	}

	/*
	 * 查询餐厅的营业额，如果营业额为零，不输出； 如果营业额不为零，按照营业额从大到小输出 如果营业额一样，优先输出餐厅ID小的
	 */
	int[] queryRestaurant() {
		PriorityQueue<int[]>Total = new PriorityQueue<>(new Comparator<int[]>() {
		@Override
		public  int compare(int[] array1, int[] array2) {
			if(array1[1] > array2[1]) {
				return -1;
			} else if (array1[1]== array2[1]) {
				if (array1[0]< array2[0]) {
					return -1;
				}
			}	
			return 1;
			}
		});
		for (Entry<Integer, int[]> entry:map.entrySet()) {
			Total.offer(new int[] {entry.getKey(), entry.getValue()[3]});
		}
		int index = 0;
		int[] result = new int[Total.size()];
		while(!Total.isEmpty() ) {
			result[index] = Total.poll()[0];
			index++;
		}
		for (int num : result) {
			System.out.print(num + " ");
		}
		System.out.println();
		return result;
	}

	// 查询某个餐厅某顿饭的营业额，如果总营业额为零，直接返回0
	int queryIncome(int restaurantId, int mealType) {
		if (map.containsKey(restaurantId)) {
			int kabb = map.get(restaurantId)[mealType-1];
			if( kabb!=0){
				return kabb;
			}
		}
		return 0;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		RestaurantSystem baobei = new RestaurantSystem();
		baobei.receive(5, 2, 50);
		baobei.receive(0, 3, 10);
		baobei.receive(0, 1, 3);
		baobei.receive(2, 2, 28);
		baobei.receive(0, 2, 15);
		System.out.println(baobei.queryIncome(0, 2));
		baobei.queryRestaurant();
	}
}
