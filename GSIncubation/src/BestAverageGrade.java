package task10;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public class BestAverageGrade {

	public static void main(String[] args) {

		String[][] scores = new String[][] { { "Sarah", "91" }, { "Goldie", "92" }, { "Elaine", "93" },
				{ "Elaine", "95" }, { "Goldie", "94" }, { "Sarah", "93" } };

		System.out.println(bestAverageGrade(scores));
	}

	public static Integer bestAverageGrade(String[][] scores) {
		if(Objects.isNull(scores) || scores.length==0) {
			throw new IllegalArgumentException("Invalid input");
		}
		Map<String, List<Integer>> map = new HashMap<>();
		for (int i = 0; i < scores.length; i++) {

			if (map.containsKey(scores[i][0])) {
				map.get(scores[i][0]).add(Integer.valueOf(scores[i][1]));

			} else {
				List<Integer> listOfScores = new ArrayList<>();
				listOfScores.add(Integer.valueOf(scores[i][1]));
				map.put(scores[i][0], listOfScores);
			}
		}
		int bestAverageValue = Integer.MIN_VALUE;
		int sum = 0;

		for (String temp : map.keySet()) {
			sum = map.get(temp).stream().mapToInt(Integer::intValue).sum();
			bestAverageValue = Math.max(bestAverageValue, sum / map.get(temp).size());
		}
		return bestAverageValue;
	}

}
