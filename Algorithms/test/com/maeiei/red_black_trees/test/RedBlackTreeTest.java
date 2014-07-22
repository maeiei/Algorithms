package com.maeiei.red_black_trees.test;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import com.maeiei.red_black_trees.RedBlackNode;
import com.maeiei.red_black_trees.RedBlackTree;

public class RedBlackTreeTest {
	@Test
	public void test() {
		RedBlackNode min = new RedBlackNode(1);
		RedBlackNode root = new RedBlackNode(2);
		RedBlackNode max = new RedBlackNode(3);
		RedBlackTree tree = new RedBlackTree(root);

		tree.insert(min);
		tree.insert(max);
		List<Integer> treeList = tree.getListOfTree();
		for (int i = 1; i < treeList.size(); i++) {
			Assert.assertTrue(treeList.get(i - 1) <= treeList.get(i));
		}
	}
}
