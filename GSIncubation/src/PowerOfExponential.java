
public class PowerOfExponential {
	public static void main(String[] args) {
		System.out.println(power(2, -5));
		System.out.println(power(2, 5));
		System.out.println(power(2, 4));
	}

	public static double power(double base, int exponent) {
		if (base == 0) {
			return 0;
		}
		if (base == 1 || exponent == 0) {
			return 1;
		}
		return compute(base, exponent);
	}

	private static double compute(double base, int exponent) {
		if (exponent == 0) {
			return 1;
		}
		double pow = compute(base, exponent / 2);
		if (exponent % 2 == 0) {
			return pow * pow;
		} else if(exponent>0) {
				return (base * pow * pow);
		} else {
			return (pow*pow)/base;
		}
	}
}
