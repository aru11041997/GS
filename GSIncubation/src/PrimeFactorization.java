import java.util.ArrayList;
import java.util.Arrays;

public class PrimeFactorization {
	public static void main(String[] args) {
		System.out.println(Arrays.toString(primeFactorization(15).toArray()));
		System.out.println(Arrays.toString(primeFactorization(0).toArray()));
		System.out.println(Arrays.toString(primeFactorization(-15).toArray()));
	}
	
	public static ArrayList<Integer> primeFactorization(int x) {
		
	    ArrayList<Integer> primeFactors = new ArrayList<>();
	    if ( x == 1) {
	        return primeFactors;
	    } else if (x < 0||x == 0 ) {
	        throw new IllegalArgumentException("Number should not be less than zero or zero");
	    } 
	        while (x % 2 == 0) {
	            primeFactors.add(2);
	            x /= 2;
	        }
	        for (int i = 3; i <= Math.sqrt(x); i+=2) {
	            while (x % i == 0) {
	                primeFactors.add(i);
	                x /= i;
	            }
	        }
	        if (x > 2){
	            primeFactors.add(x);
	        }
		    return primeFactors;
	    }
}
