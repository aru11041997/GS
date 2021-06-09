import java.util.Arrays;
import java.util.Objects;

public class AddFraction {
	public static void main(String[] args) {

		System.out.println(Arrays.toString(addFractions(new int[] { 2, 3 }, new int[] { 1, 2 })));
		System.out.println(Arrays.toString(addFractions(new int[] { 2, 0 }, new int[] { 1, 3 })));
		System.out.println(Arrays.toString(addFractions(null, new int[] { 0, 3 })));
	}

	private static int[] addFractions(int[] fraction1, int[] fraction2) {
		if (Objects.isNull(fraction1) || Objects.isNull(fraction2)) {
			throw new NullPointerException("inputs must not be null");
		}
		if(fraction1[1]==0||fraction2[1]==0) {
			throw new IllegalArgumentException("denominator should not be zero.");
		}
		int resultDenominator = gcdOf(fraction1[1], fraction2[1]);
		resultDenominator = (fraction1[1] * fraction2[1]) / resultDenominator;
		int resultNumerator = fraction1[0] * (resultDenominator / fraction1[1])
				+ fraction2[0] * (resultDenominator / fraction2[1]);
		return findLCM(resultNumerator, resultDenominator);
	}

	private static int[] findLCM(int resultNumerator, int resultDenominator) {
		int commonValue = gcdOf(resultDenominator, resultNumerator);
		resultNumerator = resultNumerator / commonValue;
		resultDenominator = resultDenominator / commonValue;
		return (new int[] { resultNumerator, resultDenominator });
	}

	private static int gcdOf(int number1, int number2) {
		if (number2 == 0)
			return number1;
		else
			return gcdOf(number2, number1 % number2);
	}
}
