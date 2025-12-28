package il.ac.telhai.ds.trees;
	
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.fail;

import org.junit.Test;

public class TestAVLRankTree {

	AVLRankTree<Integer> avlRankTree;

	@Test
	public void buildAVLTree() {
		AVLRankTree<Integer> avlRankTree = setUp();

		String s = inOrder(avlRankTree);
		assertEquals(s, " 0  2  4  6  8  10  11  12  14  16  18 ");
		checkTreeStructure(avlRankTree);
	}

	private AVLRankTree<Integer> setUp() {
		AVLRankTree<Integer> avlRankTree = new AVLRankTree<Integer>(11);
		for (int i = 0; i < 10; i++) {
			int k = 2 * i;
			avlRankTree = avlRankTree.add(k);
		}
		return avlRankTree;
	}

	private void checkTreeStructure(AVLRankTree<Integer> avlRankTree) {
		assertEquals(avlRankTree.getValue(), Integer.valueOf(6));

		assertEquals(avlRankTree.getLeft().getValue(), Integer.valueOf(2));
		assertEquals(avlRankTree.getRight().getValue(), Integer.valueOf(12));

		assertEquals(avlRankTree.getLeft().getLeft().getValue(), Integer.valueOf(0));
		assertEquals(avlRankTree.getLeft().getRight().getValue(), Integer.valueOf(4));
		assertEquals(avlRankTree.getRight().getLeft().getValue(), Integer.valueOf(10));
		assertEquals(avlRankTree.getRight().getRight().getValue(), Integer.valueOf(16));

		assertEquals(avlRankTree.getRight().getLeft().getLeft().getValue(),  Integer.valueOf(8));
		assertEquals(avlRankTree.getRight().getLeft().getRight().getValue(), Integer.valueOf(11));
		assertEquals(avlRankTree.getRight().getRight().getLeft().getValue(), Integer.valueOf(14));
		assertEquals(avlRankTree.getRight().getRight().getRight().getValue(), Integer.valueOf(18));
	}

	private String inOrder(AVLRankTree<Integer> tree) {
		StringBuilder sb = new StringBuilder();

		if (tree.getLeft() != null) {
			sb.append(inOrder(tree.getLeft()));
		}
		sb.append(" ");
		sb.append(tree.getValue());
		sb.append(" ");
		if (tree.getRight() != null) {
			sb.append(inOrder(tree.getRight()));
		}
		return sb.toString();
	}

	@Test
	public void testSingleRotateLeft() {
		AVLRankTree<Integer> tree = new AVLRankTree<Integer>(0);
		tree = tree.add(10);
		tree = tree.add(20);
		testTree(tree);
	}

	@Test
	public void testSingleRotateRight() {
		AVLRankTree<Integer> tree = new AVLRankTree<Integer>(20);
		tree = tree.add(10);
		tree = tree.add(0);
		testTree(tree);
	}

	@Test
	public void testDoubleRotateLeftRight() {
		AVLRankTree<Integer> tree = new AVLRankTree<Integer>(20);
		tree = tree.add(0);
		tree = tree.add(10);
		testTree(tree);
	}

	@Test
	public void testDoubleRotateRightLeft() {
		AVLRankTree<Integer> tree = new AVLRankTree<Integer>(10);
		tree = tree.add(20);
		tree = tree.add(0);
		testTree(tree);
	}

	private void testTree(AVLRankTree<Integer> tree) {
		assertEquals(tree.getValue(), Integer.valueOf(10));
		assertEquals(tree.getLeft().getValue(), Integer.valueOf(0));
		assertEquals(tree.getRight().getValue(), Integer.valueOf(20));
	}

	@Test
	public void testRank() {
		AVLRankTree<Integer> avlRankTree = setUp();
		avlRankTree = avlRankTree.add(16);		
		assertEquals(6, avlRankTree.rank(11));
		assertEquals(11, avlRankTree.rank(18));
		assertEquals(0, avlRankTree.rank(0));
		assertEquals(2, avlRankTree.rank(4));
		assertEquals(8, avlRankTree.rank(14));
		assertEquals(8, avlRankTree.rank(14));
		assertEquals(3, avlRankTree.rank(5));
		assertEquals(12, avlRankTree.rank(20));
		assertEquals(0, avlRankTree.rank(-1));
		assertEquals(9, avlRankTree.rank(16));
		
		
	}

	@Test
	public void testNumInRange() {
		AVLRankTree<Integer> avlRankTree = setUp();
		assertEquals(10, avlRankTree.numInRange(0,18));
		assertEquals(3, avlRankTree.numInRange(6,11));
		assertEquals(6, avlRankTree.numInRange(4,14));
	}

	@Test
	public void testSelect() {
		AVLRankTree<Integer> avlRankTree = setUp();
		assertEquals(11, (int)avlRankTree.select(6));
		assertEquals(18, (int)avlRankTree.select(10));
		assertEquals(0, (int)avlRankTree.select(0));
		assertEquals(10, (int)avlRankTree.select(5));
		assertEquals(16, (int)avlRankTree.select(9));
		try {
			avlRankTree.select(30);
			fail("should not work");
		}
		catch (Exception e) {
		}
	}
}