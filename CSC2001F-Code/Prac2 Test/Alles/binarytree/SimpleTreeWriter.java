package binarytree;
import java.io.PrintStream;
import binarytree.LinkedBinaryTree;
import binarytree.Node;
import binarytree.Position;
/**
 * An implementation of BinaryTreeWriter. </br>
 * To illustrate the intended output format, assume we have a BinarySearchTree 
 * containing the values 14, 10, 12, 6, 22, 16:</br>
 * <pre>
 * |  
 * |__14
 *    |  
 *    |__22
 *    |  |__
 *    |  |  
 *    |  |__16
 *    |     |__
 *    |     |__
 *    |  
 *    |__10
 *       |  
 *       |__12
 *       |  |__
 *       |  |__
 *       |  
 *       |__6
 *          |__
 *          |__
 * </pre>
 * This tree has a root value of 14, root's right hand child has the value 22, it's left hand child has the
 * value 10...</br>
 * Children are printed below the parent.</br>
 * The right child is printed before the left.</br>
 *
 * @author Stephan Jamieson 
 * @version 2/3/2016
 */
public class SimpleTreeWriter<E> implements BinaryTreeWriter<E> {

   private PrintStream stream;
    /**
     * Create a SimpleTreeWriter that outputs to the given PrintStream.
     */
    public SimpleTreeWriter(PrintStream p) { this.setDestination(p); }
    
    /**
     * Set the destination PrintStream.
     */
    public void setDestination(PrintStream p) { 
		// Your code here
      this.stream = p;
	}
    
    /**
     * Print the given tree.
     */
     String prefix = "";
    public void print(BinaryTree<E> t) {
		// Your code here
      if (t.isEmpty()){
         stream.print("|\n|__");
      } else {
         Position<E> root = t.root();
         stream.print("|\n|");
         printPosition(t, root);
      }
      
    } 
    public void printPosition(BinaryTree<E> t, Position<E> root){
      stream.print(prefix + "\n" + prefix + "__" + t.getContent(root) + "\n");
      if (t.hasRight(root)){
         prefix += "**|";
         Position<E> rootR = (t.getRight(root));
         printPosition(t, rootR);
      } else {
         prefix += "**|";
         stream.print(prefix + "__\n");
      }
        if (t.hasLeft(root)){
        // prefix += "  ";
        // prefix = prefix.substring(0,prefix.length()-3) + "--}";
         Position<E> rootL = (t.getLeft(root));
         printPosition(t, rootL);
        // prefix =  "--}" + prefix.substring(0,prefix.length()-3) ;
       // stream.print(prefix + " r\n");
      }else{
        // prefix += "  ";
        // prefix = prefix.substring(0,prefix.length()-3) + "--}";
         stream.print(prefix + "__\n");  
       //  stream.print(prefix + " p\n");
      }
      if (prefix.length() >2){
         prefix = prefix.substring(0,prefix.length()-3) ;
       //  stream.print(prefix + " q\n");
      }
    }
    
    /**
     * Print the given tree.
     
    public void print(BinaryTree<E> t) {
		// Your code here
      if (t.isEmpty()){
         stream.print("|\n|__");
      } else {
         Position<E> position = t.root();      
         stream.print("|\n|__"+ t.getContent(position) +"\n");
         if (t.hasRight(position)){ 
            Position<E> rightEndParent = printRight(position, t, "   ");
         } else if (t.hasLeft(position)){
            stream.print("   |__\n");
            printLeft(position, t, "   ");
         }
      }
    } 
    int root = 0;
    public Position<E> printRight(Position<E> position, BinaryTree<E> t, String prefix){
      //print complete right branch
      do {
         stream.print(prefix + "|\n");
         Position<E> rightPos = t.getRight(position);
         stream.print(prefix + "|__" + t.getContent(rightPos) + "\n");
         position = rightPos;
         prefix += "|   ";
      } 
      while (t.hasRight(position));
     
      //Print empty nodes of right branch
      stream.print(prefix + "|__\n");
      Position<E> parentPos = position;
      
      //Iterate up from leaf to node with left child
      while (parentPos != null && root != 1) {
         if (t.isRoot(parentPos)){
            root++;
         }
         if (t.hasLeft(parentPos)){
          //  stream.print("print left " + t.getContent(parentPos) + "\n");
            String prefixL = prefix.substring(0,prefix.length()-3);
            printLeft(parentPos, t, prefixL);
         }else{
            if (!t.isLeaf(parentPos)){
               prefix = prefix.substring(0,prefix.length()-3);
            }  
            stream.print(prefix + "__\n");
         }
         Position<E> tempPos = t.getParent(parentPos);
         parentPos = tempPos;
     //    stream.print("2" + t.getContent(parentPos) + "\n");
      }
      return(parentPos);
    }
    public Position<E> printLeft(Position<E> position, BinaryTree<E> t, String prefix){
      String add = "";
      if (t.isRoot(position)){
         prefix = "   ";
         add = "|";
      }
      do {
         stream.print(prefix + add + "\n");
         Position<E> leftPos = t.getLeft(position);
         stream.print(prefix + add + "__" + t.getContent(leftPos) + "\n");
         prefix =  prefix + "   ";
         if (t.hasRight(leftPos)){
         //   stream.print("print right \n");
            printRight(leftPos, t, prefix);
         } else {
            stream.print(prefix + "|__\n");
         }
         position = leftPos;
      } 
      while (t.hasLeft(position));
      stream.print(prefix + "|__\n");
      return (t.getParent(position));
    }
    */
}