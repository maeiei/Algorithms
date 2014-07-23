package com.maeiei.red_black_trees;
public class RedBlackNode {
	public static final boolean RED = true;
	public static final boolean BLACK = false;
	public static final RedBlackNode NULLNODE = RedBlackNullNode.getInstance();
	public RedBlackNode() {
		this.color = BLACK;
	}
	public RedBlackNode(int value) {
		this.value = value;
		right = NULLNODE;
		left = NULLNODE;
		this.color = BLACK;
	}
	private int value;
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
	public boolean isRed() {
		return color == RED;
	}
	public boolean isBlack() {
		return color == BLACK;
	}
	public int getValue() {
		return value;
	}
	public void setValue(int value) {
		this.value = value;
	}
	public RedBlackNode getNullNode() {
		return RedBlackNullNode.getInstance();
	}
}
class RedBlackNullNode extends RedBlackNode {
	private static RedBlackNullNode NULLNODE = null;
	public static RedBlackNullNode getInstance() {
		if (NULLNODE == null) {
			NULLNODE = new RedBlackNullNode();
		}
		return NULLNODE;
	}
	private RedBlackNullNode() {
		this.setLeft(NULLNODE);
		this.setRight(NULLNODE);
		this.setParent(NULLNODE);
	}
}
