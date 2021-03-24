import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/**
 * Utility procedures for binary tree structures.
 * 
 * @version 25/2/2015
 */
public class TreeUtils {
        
    /**
     * Determine whether one tree node structure is similar (has the same structure) as another.
     */
    public static boolean similar(BinaryTreeNode treeStructOne, BinaryTreeNode treeStructTwo) {
		// Base Case: Both nodes have no children --> return false
      if (treeStructOne.hasLeft() == false && treeStructTwo.hasLeft() == false 
            && treeStructOne.hasRight() == false && treeStructTwo.hasRight() == false){ 
            return true;
      }
      // Base Case: Subtrees are not similar --> return false
      else if ((treeStructOne.hasLeft() ^ treeStructTwo.hasLeft()) || (treeStructOne.hasRight() ^ treeStructTwo.hasRight())){
         return false;
      } 
      // Check the next subtree
      else {
         return (similar(treeStructOne.getLeft(), treeStructTwo.getLeft()) 
                  && similar(treeStructOne.getRight(),treeStructTwo.getRight()));
      }
    }
    
    /**
     * Obtain a list containing the root node of the given structure i.e. tNode itself.
     */
    public static List<BinaryTreeNode> levelZero(BinaryTreeNode tNode) {
        // Your code here
        List<BinaryTreeNode> nodeList = new ArrayList<BinaryTreeNode>();
        nodeList.add(tNode);
		  return nodeList;
    }
    
    
    /**
     * Given a list of nodes, obtain the next level. 
     * 
     * <p>
     * If the tree structure is incomplete, <code>BinaryTreeNode.EMPTY_NODE</code> is inserted as a place holder for each
     * missing node.
     * </p>
     */
    public static List<BinaryTreeNode> nextLevel(List<BinaryTreeNode> level) {
      List<BinaryTreeNode> nextLevelList = new ArrayList<BinaryTreeNode>();
		for (BinaryTreeNode node: level){
         if (!node.hasLeft()){
            nextLevelList.add(BinaryTreeNode.EMPTY_NODE);
         } else {
            nextLevelList.add(node.getLeft());
         }
         if (!node.hasRight()){
            nextLevelList.add(BinaryTreeNode.EMPTY_NODE);
         } else {
            nextLevelList.add(node.getRight());
         }
      }
		return nextLevelList;
    }
    
    /**
     * Determine whether node is a place holder i.e. <code>node==BinaryTreeNode.EMPTY_NODE</code>
     */
    public static boolean isPlaceHolder(BinaryTreeNode node) {
		if (node == BinaryTreeNode.EMPTY_NODE){
         return true;
      } else {
		   return false;
      }
    }
    
}
