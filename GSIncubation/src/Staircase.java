package task8;

public class Staircase {

	public static void main(String[] args) {
		System.out.println(countSteps(3));
		System.out.println(countSteps(1));
		System.out.println(countSteps(2));
		System.out.println(countSteps(10));
		System.out.println(countSteps(-5));
	}
	
	public static Integer countSteps(Integer n) {
		if(n==null) {
			throw new IllegalArgumentException();
		} else if(n<=0) {
			return 0;
		}
		int[] memo = new int[n+1];
		memo[0] = 1;
        memo[1] = 2;
        if(n>2) {
        	memo[2] = 4;
            for(int i=3; i<=n; i++){
                memo[i] = memo[i-1] + memo[i-2]+memo[i-3];
            }
        }
        return memo[n-1];
	}
}
