package task8;

public class OptimalPath {
	public static void main(String[] args) {
		Integer arr[][] = { { 0, 0, 0, 0, 5 }, { 0, 1, 1, 1, 0 }, { 2, 0, 0, 0, 0 } };
		System.out.println(optimalPath(arr));
	}

	public static Integer optimalPath(Integer[][] grid) {

		if (grid == null) {
            throw new IllegalArgumentException("Input invalid");
        }
        int rows = grid.length;
        int columns = grid[0].length;
        int down = 0;
        int left = 0;
        for (int i = rows - 1; i >= 0; i--) {
            for (int j = 0; j < columns; j++) {
                down = i + 1 < rows ? grid[i + 1][j] : 0;
                left = j - 1 >= 0 ? grid[i][j - 1] : 0;
                grid[i][j] = grid[i][j] + Math.max(left, down);
            }
        }
        return grid[0][columns - 1];
	}
}
