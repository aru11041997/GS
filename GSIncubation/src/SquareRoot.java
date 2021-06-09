import java.math.BigDecimal;
import java.math.RoundingMode;

public class SquareRoot {

	public static void main(String[] args) {
		System.out.println(squareRoot(10));
		System.out.println(squareRoot(100));
		System.out.println(squareRoot(9));
		System.out.println(squareRoot(4));
	}

	public static double squareRoot(double x) {
		if (x == 0 || x == 1) {
			return x;
		} else if (x < 0) {
			throw new IllegalArgumentException("Value should not be zero");
		}
		int lowerValue = 0;
		int higherValue = (int) (x / 2);
		int mid;
		double ans = 0;
		int output = 0;
		while (lowerValue <= higherValue) {
			mid = (lowerValue + higherValue) / 2;
			if (mid * mid < x) {
				ans = mid;
				lowerValue = mid + 1;
			} else if (mid * mid == x) {
				output = mid;
				break;
			} else {
				higherValue = mid - 1;
			}
		}
		if(output*output==x) {
			return output;
		}
		else {
			return squareRootOfValueIfExistsInDecimal(ans, x);
		}
	}

	public static double squareRootOfValueIfExistsInDecimal(double ans, double x) {
		double lowerValue = ans;
		double higherValue = ans + 1;
		double midValue;
		while (lowerValue <= higherValue) {
			midValue = (lowerValue + higherValue) / 2;
			double temp = midValue * midValue;
			if (temp == x || Math.abs(temp - x) <= 0.0000001) {
				ans = midValue;
				break;
			} else if (temp < x) {
				lowerValue = midValue;
			} else {
				higherValue = midValue;
			}
		}
		return ans;
	}

}
