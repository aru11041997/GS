package com.epam.task5;

public class SecondSmallest {
	public static void main(String[] args) {
		System.out.println(secondSmallest(new int[] { -1, 0, 1, -2, 2}));
		System.out.println(secondSmallest(new int[] { 0, 1}));
		System.out.println(secondSmallest(new int[] { -1, 0, 1, -2, 2}));
		System.out.println(secondSmallest(new int[] { }));
		System.out.println(secondSmallest(new int[] {1,1,2}));
		System.out.println(secondSmallest(new int[] {1,1,1}));
	}

	private static int secondSmallest(int[] x) {
		
		if(x==null||x.length<2 )
			return 0;
		int initialValues=Integer.MAX_VALUE;
		int firstSmallestValue=initialValues;
		int secondSmallestValue=initialValues;
		for(int i=0;i<x.length;i++) {
			if(firstSmallestValue>x[i]) {
				secondSmallestValue=firstSmallestValue;
				firstSmallestValue=x[i];
			} else if(firstSmallestValue<x[i]&&secondSmallestValue>x[i]) {
				secondSmallestValue=x[i];
			}
		}
		if(secondSmallestValue==initialValues)
			return 0;
		return secondSmallestValue;
	}
}
