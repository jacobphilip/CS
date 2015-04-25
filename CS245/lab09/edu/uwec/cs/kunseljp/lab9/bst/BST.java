
package edu.uwec.cs.kunseljp.lab9.bst;

import java.util.LinkedList;
import java.util.Queue;

// Binary Search Tree implementation
public class BST {

	// Nested class to hold tree nodes
	class TNode {

		public Integer nodeValue;
		public TNode left;
		public TNode right;
		public TNode prev;

		public TNode(Integer item) {
			nodeValue = item;
			left = null;
			right = null;
			prev = null;
		}

		public TNode(Integer item, TNode left, TNode right, TNode prev) {
			nodeValue = item;
			this.left = left;
			this.right = right;
			this.prev = prev;
		}

		public String toString() {
			return nodeValue + "";
		}

		public boolean hasRight() {
			boolean result = false;
			if (this.right != null) {
				result = true;
			}
			return result;
		}

		public boolean hasLeft() {
			boolean result = false;
			if (this.left != null) {
				result = true;
			}
			return result;
		}
	}

	private TNode root;

	// Construct an empty BST
	public BST() {
		root = null;
	}

	public boolean contains(Integer t) {
		boolean result;

		// Start at the root
		TNode current = root;

		// Keep going until we reach the end of the tree (null) or
		// until we find a node that is equal to the target
		while ((current != null) && (!current.nodeValue.equals(t))) {

			if (current.nodeValue.compareTo(t) > 0) {
				current = current.left;
			} else {
				current = current.right;
			}
		}
		if (current == null) {
			result = false;
		} else {
			result = true;
		}

		return result;
	}

	public void insert(Integer t) {
		TNode newNode = new TNode(t);

		if (root == null) {
			root = newNode;
		} else {
			TNode current = root;
			boolean done = false;
			while (!done) {

				if (current.nodeValue.compareTo(t) > 0) {
					if (current.left == null) {
						current.left = newNode;
						newNode.prev = current;
						done = true;
					} else {
						current = current.left;
					}

				} else {
					if (current.right == null) {
						current.right = newNode;
						newNode.prev = current;
						done = true;
					} else {
						current = current.right;
					}
				}
			}
		}
	}

	public void delete(Integer t) {
		TNode current = root;
		boolean matchFound = false;

		if (current == null) {
			System.out.println("The tree is empty.");
		} else {
			while (!matchFound) {
				if ((current != null) && (current.nodeValue.compareTo(t) == 0)) {

					// Delete a Leaf Node
					if ((current.hasRight() == false) && (current.hasLeft() == false)) {
						if (current.prev.right.nodeValue.compareTo(t) == 0) {
							current.prev.right = null;
						} else if (current.prev.left.nodeValue.compareTo(t) == 0) {
							current.prev.left = null;
						}
					}

					// Delete a Node with a single right Leaf Node
					if ((current.hasRight() == true) && (current.hasLeft() == false)) {
						if (current.prev.right.nodeValue.compareTo(t) == 0) {
							current.prev.right = current.right;
						} else if (current.prev.left.nodeValue.compareTo(t) == 0) {
							current.prev.left = current.right;
						}
					}

					// Delete a Node with a single left Leaf Node
					if ((current.hasRight() == false) && (current.hasLeft() == true)) {
						if (current.prev.right.nodeValue.compareTo(t) == 0) {
							current.prev.right = current.left;
						} else if (current.prev.left.nodeValue.compareTo(t) == 0) {
							current.prev.left = current.left;
						}
					}

					// Delete a Node with two Children
					if ((current.hasRight() == true) && (current.hasLeft() == true)) {
						TNode successor = current.right;
						while (successor.hasLeft()) {
							successor = successor.left;
						}

						if (successor.prev != current) {
							if (successor.hasRight()) {
								successor.prev.left = successor.right;
							} else {
								successor.prev.left = null;
							}
						} else {
							if (successor.hasRight()) {
								successor.prev.right = successor.right;
							} else {
								successor.prev.right = null;
							}
						}

						if ((current.prev.right != null)
								&& (current.prev.right.nodeValue.compareTo(t) == 0)) {
							current.prev.right = successor;
						} else if ((current.prev.left != null)
								&& (current.prev.left.nodeValue.compareTo(t) == 0)) {
							current.prev.left = successor;
						}

						successor.left = current.left;
						successor.right = current.right;
						successor.prev = current.prev;
					}
					matchFound = true;
				} else if ((t.compareTo(current.nodeValue) < 0)) {
					current = current.left;
				} else if ((t.compareTo(current.nodeValue) > 0)) {
					current = current.right;
				}
			}

		}

	}

	// This is a debugging utility.
	// It simply displays all the nodes at each level, but doesn't show which
	// ones
	// are corrected to which parents. You will need to use the debugger to
	// inspect
	// that information if needed for debugging.
	public void displayTree() {
		// Doesn't show links between parent and child nodes
		if (root == null) {
			System.out.println("Tree is empty");
		} else {
			Queue<TNode> q = new LinkedList<TNode>();
			Queue<Integer> levelQ = new LinkedList<Integer>();
			q.add(root);
			levelQ.add(0);
			int currentLevel = 0;

			while (!q.isEmpty()) {
				TNode current = q.remove();
				Integer level = levelQ.remove();

				if (currentLevel != level) {
					System.out.print("\n");
					currentLevel++;
				}
				System.out.print(current.nodeValue + " ");

				// if a left child exists, insert it in the queue
				if (current.left != null) {
					q.add(current.left);
					levelQ.add(level + 1);
				}
				// if a right child exists, insert next to its sibling
				if (current.right != null) {
					q.add(current.right);
					levelQ.add(level + 1);
				}
			}
		}
		System.out.print("\n");
	}

}