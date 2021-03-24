import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import org.junit.Test;
/*
* JUnit test class for BinaryTreeNode
*
* @author Stephan Jamieson
* @version 16/2/2016
*/
public class TestBinaryTreeNode {

	
	@Test
	public void testSingleNodeConstuctor() {
		BinaryTreeNode node = new BinaryTreeNode(3);
		assertEquals(node.hasLeft(),false);
		assertEquals(node.hasRight(), false);
		assertEquals(node.getItem(), (Integer)3);
		assertEquals(node.getHeight(), (Integer)1);
		assertEquals(node.getLargest(),(Integer)3);		
		
		try {
			node = new BinaryTreeNode(null);
		}
		catch (AssertionError assErr) {
			// Test passed.
			return;
		}
	}


	@Test
	public void testSetGetLeft() {
		final BinaryTreeNode root = new BinaryTreeNode(3);
		final BinaryTreeNode left = new BinaryTreeNode(5);
		root.setLeft(left);
		assertEquals(root.hasLeft(),true);
		assertEquals(root.getLeft(), left); 
		assertEquals(root.hasRight(),false);
		assertEquals(root.getHeight(), (Integer)2);
		assertEquals(root.getLargest(), (Integer)5);

		// Require 'java -ea' to enable assertions for this part of test. 
		try {
			root.getRight();
		}
		catch (AssertionError assErr) {
			// Test passed.
			return;
		}
	}

	
	@Test
	public void testSetGetRight() {
		final BinaryTreeNode root = new BinaryTreeNode(3);	
		final BinaryTreeNode right = new BinaryTreeNode(7);
		root.setRight(right);
		assertEquals(root.hasRight(),true);
		assertEquals(root.getRight(), right); 		
		assertEquals(root.hasLeft(),false);
		assertEquals(root.getHeight(), (Integer)2);
		assertEquals(root.getLargest(), (Integer)7);

		// Require 'java -ea' to enable assertions for this part of test. 
		try {
			root.getLeft();
		}
		catch (AssertionError assErr) {
			// Test passed.
			return;
		}
	}
	
	@Test
	public void testSetLeftOfEmpty() {
		final BinaryTreeNode root = BinaryTreeNode.EMPTY_NODE;
		final BinaryTreeNode leaf = new BinaryTreeNode(4);
		try {
			root.setLeft(leaf);
		}
		catch (AssertionError assErr) {
			// Test passed.
			return;
		}
	}
	
	@Test
	public void testSetRightOfEmpty() {
		final BinaryTreeNode root = BinaryTreeNode.EMPTY_NODE;
		final BinaryTreeNode leaf = new BinaryTreeNode(4);
		try {
			root.setRight(leaf);
		}
		catch (AssertionError assErr) {
			// Test passed.
			return;
		}
	}
	
	@Test
	public void testLargestHeight() {
		final BinaryTreeNode root = new BinaryTreeNode(3);	
		final BinaryTreeNode right = new BinaryTreeNode(5);
		root.setRight(right);
		BinaryTreeNode left = new BinaryTreeNode(7);
		root.setLeft(left);
		right.setLeft(new BinaryTreeNode(11));
		assertEquals(root.getHeight(), (Integer)3);
		assertEquals(root.getLargest(), (Integer)11);
	}
}