package task10;

import java.util.Objects;

public class Snowpack {
	public static void main(String[] args) {

		System.out.println(computeSnowpack(new Integer[] {0, 1, 3, 0, 1, 2, 0, 4, 2, 0, 3, 0}));
		System.out.println(computeSnowpack(new Integer[] { 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1 }));
	}

	public static Integer computeSnowpack(Integer[] arr) {
		
		if(Objects.isNull(arr) || arr.length==0) {
			throw new IllegalArgumentException("Invalid input");
		}
		int maxValueOnRight = 0;
		int maxValueOnLeft = 0;
		int left = 0;
		int right = arr.length-1;
		Integer snowValue = 0;
		while (left <= right) {
			if (arr[left] < arr[right]) {
				if (arr[left] < maxValueOnLeft) {
					snowValue = snowValue + (maxValueOnLeft - arr[left]);
				} else {
					maxValueOnLeft = arr[left];
				}
				left++;
			} else {
				if(arr[right]<maxValueOnRight) {
					snowValue=snowValue+(maxValueOnRight-arr[right]);
				} else {
					maxValueOnRight=arr[right];
				}
				right--;
			}
		}
		
		return snowValue;
	}
}