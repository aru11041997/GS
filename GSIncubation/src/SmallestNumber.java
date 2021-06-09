package com.epam.task5;

public class SmallestNumber {

	public static void main(String[] args) {
		System.out.println(findMin(new int[] { 3, 4, 5, 6, 1, 2 }));
		System.out.println(findMin(new int[] { 2, 1 }));
		System.out.println(findMin(new int[] { 1, 2, 3, 4, 5, 6 }));
		System.out.println(findMin(new int[] { 1 }));
		System.out.println(findMin(new int[] { 4, 1, 2, 3 }));
	}

	public static int findMin(int[] a) {
		int lowerValue = 0;
		int higherValue = a.length - 1;
		int midValue;
		while (lowerValue < higherValue) {
			midValue = (lowerValue + higherValue) / 2;
			if (midValue > 0 && a[midValue - 1] > a[midValue]) {
				return a[midValue];
			}
			if (a[midValue] >= a[lowerValue] && a[midValue] > a[higherValue]) {
				lowerValue = midValue + 1;
			} else {
				higherValue = midValue - 1;
			}
		}
		return a[lowerValue];
	}
}
