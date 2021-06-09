package task7;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.TreeMap;

public class LargestTreeUsingBfs {
	public static void main(String[] args) {
		Map<Integer, Integer> map = new HashMap<>();
		map.put(1, 2);
		map.put(3, 4);
		map.put(2, 5);
		map.put(4, 5);
		map.put(6, 7);
		map.put(0, 2);

		System.out.println(largestTree(map));
	}

	static int count = 0;

	public static Integer largestTree(final Map<Integer, Integer> immediateParent) {
		int ans = 0;
		if (immediateParent == null || immediateParent.isEmpty()) {
			throw new IllegalArgumentException();
		}
		Map<Integer, ArrayList<Integer>> parentNodes = getParentNodes(immediateParent);
		Map<Integer, Integer> rootsAndItsNodesSize = new TreeMap<>(Collections.reverseOrder());
		int max = 0;
		max = getMaxNodes(parentNodes, rootsAndItsNodesSize, max);

		ans = getLargestTreeRoot(ans, rootsAndItsNodesSize, max);
		return ans;
	}

	private static int getLargestTreeRoot(int ans, Map<Integer, Integer> rootsAndItsNodesSize, int max) {
		for (Map.Entry<Integer, Integer> entry : rootsAndItsNodesSize.entrySet()) {
			if (entry.getValue() == max) {
				ans = entry.getKey();
			}
		}
		return ans;
	}

	private static int getMaxNodes(Map<Integer, ArrayList<Integer>> parentNodes,
			Map<Integer, Integer> rootsAndItsNodesSize, int max) {
		int size;
		for (Map.Entry<Integer, ArrayList<Integer>> entry : parentNodes.entrySet()) {
			size = bfs(entry.getKey(), parentNodes);
			rootsAndItsNodesSize.put(entry.getKey(), size);
			if (max < size) {
				max = size;
			}
		}
		System.out.println(rootsAndItsNodesSize);
		return max;
	}

	private static Map<Integer, ArrayList<Integer>> getParentNodes(final Map<Integer, Integer> immediateParent) {
		Map<Integer, ArrayList<Integer>> parentNodes = new HashMap<>();
		for (Map.Entry<Integer, Integer> entry : immediateParent.entrySet()) {
			if (entry.getValue() == null || entry.getKey() == null) {
				throw new IllegalArgumentException();
			}
			ArrayList<Integer> temp = parentNodes.getOrDefault(entry.getValue(), new ArrayList<Integer>());
			temp.add(entry.getKey());
			parentNodes.put(entry.getValue(), temp);
		}
		return parentNodes;
	}

	private static int bfs(int value, Map<Integer, ArrayList<Integer>> map) {
		int size = 0;
		int peek = 0;
		Queue<Integer> queue = new LinkedList<>();
		queue.add(value);
		size++;
		while (!queue.isEmpty()) {
			peek = queue.remove();
			ArrayList<Integer> temp = map.getOrDefault(peek, new ArrayList<Integer>());
			queue.addAll(temp);
			size = size + temp.size();
		}
		return size;
	}
}