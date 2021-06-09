package task7;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;

public class LargestTree {

	public static void main(String args[]) {

		Map<Integer, Integer> map = new LinkedHashMap<>();
		map.put(1, 2);
		map.put(3, 4);
		map.put(2, 5);
		map.put(4, 5);
		map.put(6, 7);
		map.put(0, 2);
		
		map.put(11, 12);
		map.put(13, 14);
		map.put(12, 18);
		map.put(14, 18);
		map.put(16, 17);
		map.put(10, 12);
		System.out.println(largestTree(map));

	}

	public static Integer largestTree(final Map<Integer, Integer> immediateParent) {
		if (immediateParent == null || immediateParent.isEmpty()) {
			throw new IllegalArgumentException();
		}
		Map<Integer, Integer> res = new HashMap<>();
		for (Entry<Integer, Integer> entry : immediateParent.entrySet()) {
			int key = entry.getKey();
			int parent=findParentOfChild(immediateParent,key);
			if (res.containsKey(parent))
				res.put(parent, res.get(parent) + 1);
			else
				res.put(parent, 1);
		}
		int maxNodes=Integer.MIN_VALUE;
		int resultParent=-1;
		for(int parent: res.keySet()) {
			if(res.get(parent)>maxNodes) {
				maxNodes=res.get(parent);
				resultParent=parent;
			} else if(res.get(parent)==maxNodes) {
				resultParent=Math.min(resultParent, parent);
			}
		}
		return resultParent;
	}

	private static int findParentOfChild(Map<Integer, Integer> immediateParent, int child) {
		if (!immediateParent.containsKey(child))
			return child;
		return findParentOfChild(immediateParent, immediateParent.get(child));
	}
}
