package task6;

import static org.junit.Assert.assertNotEquals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BinarySearchTree {
	static class BST {
		private Node root;

		public BST() {
			this.root = new Node();
		}

		public void put(int value) {
			put(value, root);
		}

		private void put(int value, Node node) {
			if (node.val == null) {
				node.val = value;
			} else {
				if (value < node.val) {
					if (node.left == null) {
						node.left = new Node();
					}
					put(value, node.left);
				} else {
					if (node.right == null) {
						node.right = new Node();
					}
					put(value, node.right);
				}
			}
		}

		public boolean contains(int value) {
			return contains(value, root);
		}

		private boolean contains(int value, Node node) {
			if (node == null || node.val == null) {
				return false;
			} else {
				if (value == node.val) {
					return true;
				} else if (value < node.val) {
					return contains(value, node.left);
				} else {
					return contains(value, node.right);
				}
			}
		}

		public List<Integer> inOrderTraversal() {
			final ArrayList<Integer> acc = new ArrayList<>();
			inOrderTraversal(root, acc);
			return acc;
		}

		private void inOrderTraversal(Node node, List<Integer> acc) {
			if (node == null) {
				return;
			}
			inOrderTraversal(node.left, acc);
			acc.add(node.val);
			inOrderTraversal(node.right, acc);

		}

		private static class Node {
			Integer val;
			Node left;
			Node right;
		}
	}

	public static void testBST() {
		final BST searchTree = new BST();
		searchTree.put(3);
		searchTree.put(1);
		searchTree.put(2);
		searchTree.put(5);
		assertFalse(searchTree.contains(0));
		assertTrue(searchTree.contains(1));
		assertFalse(searchTree.contains(9));
		assertTrue(searchTree.contains(5));
		assertFalse(searchTree.contains(6));
		assertEquals(Arrays.asList(1, 2, 3, 5), searchTree.inOrderTraversal());
		assertNotEquals(Arrays.asList(3, 1, 2, 5), searchTree.inOrderTraversal());
	}

	private static void assertFalse(boolean rez) {
		if (rez) {
			throw new RuntimeException("Test failed");
		} else {
			System.out.println("Test passed");
		}
	}

	private static void assertTrue(boolean rez) {
		if (!rez) {
			throw new RuntimeException("Test failed");
		} else {
			System.out.println("Test passed");
		}
	}

	private static void assertEquals(List<Integer> expected, List<Integer> result) {
		if (!expected.equals(result)) {
			System.out.println(String.format("Test failed \"%s\" not equeals to \"%s\"", expected, result));
		} else {
			System.out.println("Test passed");
		}
	}

	public static void main(String[] args) {
		testBST();
	}
}