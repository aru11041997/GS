package task7;

public class MedianOfSortedArrays {
	public static void main(String args[]) {
		System.out.println(findMedianSortedArrays( new int[] { 1, 3 }, new int[] { 2, 4 }));
		System.out.println(findMedianSortedArrays( new int[] {1, 3}, new int[] {}));
	}

	public static double findMedianSortedArrays(int[] a, int[] b) {
		
		if(a==null || b== null) {
			throw new IllegalArgumentException("invalid input");
		} else if(a.length==0 && b.length==0) {
			return 0.0;
		}
		int lengthOfArray = (a.length + b.length) / 2;
		double result = 0;
		int pt1 = 0;
		int pt2 = 0;
		int index = 0;
		int[] finalArr = new int[lengthOfArray + 1];
		while (pt1 < a.length && pt2 < b.length  && index < finalArr.length) {
			if (a[pt1] < b[pt2]) {
				finalArr[index] = a[pt1];
				pt1++;
			} else {
				finalArr[index] = b[pt2];
				pt2++;
			}
			index++;
		}

		while (pt1 < a.length && index < finalArr.length) {
			finalArr[index] = a[pt1];
			pt1++;
			index++;
		}

		while (pt2 < b.length && index < finalArr.length) {
			finalArr[index] = b[pt2];
			pt2++;
			index++;
		}
		if ((a.length + b.length) % 2 == 0) {
			result = Math.floor(finalArr[finalArr.length - 1] + finalArr[finalArr.length - 2]) / 2;
			return result;
		} else {
			result = finalArr[finalArr.length - 1];
			return result;
		}
	}

}
