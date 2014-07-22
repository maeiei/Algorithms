package com.maeiei.red_black_trees;

import java.util.ArrayList;
import java.util.List;

public class RedBlackTree {

	private RedBlackNode root;
	
	private List<Integer> resultList = new ArrayList<Integer>();

	public RedBlackTree(RedBlackNode root) {
		if (root.isRed())
			throw new IllegalArgumentException();
		this.root = root;
	}

	public void insert(RedBlackNode node) {
		RedBlackNode y = RedBlackNullNode.getInstance();
		RedBlackNode x = root;
		while (x != RedBlackNullNode.getInstance()) {
			y = x;
			if (node.getValue() < x.getValue())
				x = x.getLeft();
			else
				x = x.getRight();
		}
		node.setParent(y);
		if (y == RedBlackNullNode.getInstance())
			root = node;
		else if (node.getValue() < y.getValue())
			y.setLeft(node);
		else
			y.setRight(node);

		node.setParent(RedBlackNullNode.getInstance());
		node.setLeft(RedBlackNullNode.getInstance());
		node.setRight(RedBlackNullNode.getInstance());
		node.setColor(RedBlackNode.RED);
		insertFixup(node);
	}

	private void insertFixup(RedBlackNode node) {

	}

	public List<Integer> getListOfTree() {
		printTree(root);
		return resultList;
	}
	public void printTree(RedBlackNode node) {
		printTree(node.getLeft());
		resultList.add(node.getValue());
		printTree(node.getRight());
	}
}
