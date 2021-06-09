import java.util.Objects;

public class DotProduct {
	public static void main(String[] args) {
		System.out.println(dotProduct(new int[] {1,2},new int[] {2,3}));
		System.out.println(dotProduct(null,new int[] {2,3}));
	}

	private static long dotProduct(int[] array1, int[] array2) {
		if(Objects.isNull(array1)||Objects.isNull(array2)) {
			throw new NullPointerException("inputs must not be null");
		}
		long sum=0;
		if(array1.length!=array2.length) {
			throw new IllegalArgumentException("Length of the two arrays must be equal to process dot product");
		} else {
			for(int index=0;index<array1.length;index++) {
				sum=sum+(array1[index]*array2[index]);
			}
		}
		return sum;
	}
}
