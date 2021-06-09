package task8;

public class StudentElection {

	public static void main(String[] args) {
		System.out.println(whoIsElected(1, 1));
		System.out.println(whoIsElected(2, 2));
		System.out.println(whoIsElected(4, 2));
	}
	
	public static int whoIsElected(int n, int k) { 
		if(n==0) {
			throw new IllegalArgumentException("Invalid input");
		}
		
		if (n == 1) 
		    return 1; 
		else 
		    return (whoIsElected(n - 1, k) + k-1) % n + 1; 
	}
}
