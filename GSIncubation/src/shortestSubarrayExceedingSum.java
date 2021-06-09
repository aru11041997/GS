package task7;

public class shortestSubarrayExceedingSum {

	public static void main(String args[]) {
		System.out.println(subArrayExceedsSum(new int[] { 1, 2, 3,4,5,6},6));
		System.out.println(subArrayExceedsSum(new int[] { 1, 2, 3,4},6));
		System.out.println(subArrayExceedsSum(new int[] { },1));

	}

	public static int subArrayExceedsSum(int arr[], int target) {
		
		if (arr == null)
			throw new IllegalArgumentException("invalid input");
		else if(arr.length==0)
			return 0;
		else if(target<=0) {
			return 1;
		}
        int left = 0;
        int right = 0;
        int sum = 0;
        int lenOfShortestSubArray = Integer.MAX_VALUE;
        while (right < arr.length && left < arr.length) {
            if (sum + arr[right] > target) {
            	 lenOfShortestSubArray = findMinLength(left, right, lenOfShortestSubArray);
                 sum -= arr[left];
                 left++;
            } else if (sum + arr[right] == target) {
                sum += arr[right];
                lenOfShortestSubArray = findMinLength(left, right, lenOfShortestSubArray);
                right++;
            } else {
            	sum += arr[right];
                right++;
            }
        }
        
        return lenOfShortestSubArray == Integer.MAX_VALUE ? -1 : lenOfShortestSubArray;
    }

	private static int findMinLength(int left, int right, int lenOfShortestSubArray) {
		if(lenOfShortestSubArray>right - left + 1)
			return right - left + 1;
		
		return lenOfShortestSubArray;
	}

}
