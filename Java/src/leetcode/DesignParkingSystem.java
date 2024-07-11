package leetcode;

import java.util.HashMap;
import java.util.Map;

class DesignParkingSystem {
	Map<Integer, Integer> map;

	DesignParkingSystem(int big, int medium, int small) {
		map = new HashMap<>();
		map.put(1, big);
		map.put(2, medium);
		map.put(3, small);
	}

	boolean addCar(int carType) {
		int remain = map.get(carType);
		if (remain > 0) {
			map.put(carType, remain - 1);
			return true;
		}
		return false;
	}

	public static void main(String[] args) {
		DesignParkingSystem parkingSystem = new DesignParkingSystem(1, 1, 0);
		System.out.print(parkingSystem.addCar(1) + "\n");
		System.out.print(parkingSystem.addCar(2) + "\n");
		System.out.print(parkingSystem.addCar(3) + "\n");
		System.out.print(parkingSystem.addCar(1) + "\n");
	}
}
/**
 * Your ParkingSystem object will be instantiated and called as such:
 * ParkingSystem obj = new ParkingSystem(big, medium, small); boolean param_1 =
 * obj.addCar(carType);
 */