package task10;

public class PascalsTraingle {

	public static void main(String args[]) {

		System.out.println(pascal(1, 2));

	}

	public static int pascal(int col, int row) {
		if (col < 0 || row < 0)
			return 0;

		int value = 1;
		for (int i = 1; i <= row + 1; i++) {
			if (i == col + 1)
				return value;
			value = value * (row + 1 - i) / i;
		}

		return 0;
	}
}
