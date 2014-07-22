package com.maeiei.red_black_trees;

public class RedBlackNode {

	private RedBlackNode right;

	private RedBlackNode left;

	private RedBlackNode parent;

	private boolean color;

	public RedBlackNode getRight() {
		return right;
	}

	public void setRight(RedBlackNode right) {
		this.right = right;
	}

	public RedBlackNode getLeft() {
		return left;
	}

	public void setLeft(RedBlackNode left) {
		this.left = left;
	}

	public RedBlackNode getParent() {
		return parent;
	}

	public void setParent(RedBlackNode parent) {
		this.parent = parent;
	}

	public boolean isColor() {
		return color;
	}

	public void setColor(boolean color) {
		this.color = color;
	}
}
