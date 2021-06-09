package task9;

import java.util.HashMap;

public class LengthOfCycle {

	public static void main(String args[]) {
		System.out.println(countLengthofcycle(new int[] { 1, 0 }, 0));
		System.out.println(countLengthofcycle(new int[] { 1, 2, 0 }, 0));
		System.out.println(countLengthofcycle(new int[] { 1, 3, 2, 0 }, 0));
		System.out.println(countLengthofcycle(new int[] { 1, 3, 2, 4, 2 }, 0));

	}

	private static Integer countLengthofcycle(int[] arr, int startIndex) {
		if (arr == null)
			throw new IllegalArgumentException("invalid input");
		else if (arr.length == 0)
			return -1;
		int index = startIndex;
		int count = 1;
		int length = -1;
		HashMap<Integer, Integer> map = new HashMap<>();
		while (index < arr.length) {

			if (map.containsKey(index)) {
				length = count - map.get(index);
				break;
			} else {
				map.put(index, count);
				index = arr[index];
				count++;
			}
		}

		return length;
	}

}
