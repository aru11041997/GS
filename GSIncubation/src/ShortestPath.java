package task9;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class ShortestPath {

	public static void main(String[] args) {

		List<List<Integer>> trainMap = Arrays.asList(Arrays.asList(1), Arrays.asList(0, 2, 4), Arrays.asList(1, 3),
				Arrays.asList(2, 4), Arrays.asList(3, 1));
		System.out.println(findShortestPath(trainMap, 0, 4));

	}

	static List<Integer> findShortestPath(List<List<Integer>> trainMap, int source, int destination) {

		if (trainMap == null)
			throw new IllegalArgumentException("invalid input");
		else if (trainMap.isEmpty())
			return null;
		int[] parentNodes = new int[trainMap.size()];
		int[] distances = new int[trainMap.size()];
		bfs(trainMap, source, destination, parentNodes, distances);
		List<Integer> path = new ArrayList<Integer>();
		if (distances[source] == Integer.MAX_VALUE) {
			return null;
		} else {
			path.add(destination);
			int position = destination;
			while (parentNodes[position] != -1) {
				path.add(parentNodes[position]);
				position = parentNodes[position];
			}
		}
		Collections.reverse(path);
		return path;
	}

	private static void bfs(List<List<Integer>> trainMap, int source, int destination, int[] parentNodes,
			int[] distances) {
		int size = trainMap.size();
		int peek = 0;
		boolean[] visited = new boolean[size];
		Arrays.fill(parentNodes, -1);
		Arrays.fill(distances, Integer.MAX_VALUE);
		Queue<Integer> queue = new LinkedList<>();
		queue.add(source);
		distances[source] = 0;
		visited[source] = true;
		while (!queue.isEmpty()) {
			peek = queue.remove();
			List<Integer> temp = trainMap.get(peek);
			for (Integer adjacentNodes : temp) {
				if (!visited[adjacentNodes]) {
					distances[adjacentNodes] = distances[peek] + 1;
					visited[adjacentNodes] = true;
					parentNodes[adjacentNodes] = peek;
					queue.add(adjacentNodes);

					if (adjacentNodes == destination) {
						break;
					}
				}
			}
		}
	}

}
