import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/**
 * Simple Tree Writer
 * 
 * @author Brigitte Sprung
 * @version 02/03/2016
 */
 public class SimpleTreeWriterImpl implements SimpleTreeWriter{
 
   private PrintStream stream;
   private BinaryTreeNode root;
   
   public SimpleTreeWriterImpl(){
      this.stream=null;
      this.root = null;
   }
   public SimpleTreeWriterImpl(PrintStream stream){
      this.stream = stream;
   }
   /**
     * Set the PrintStream object to be used for output. 
     */
    public void setDestination(PrintStream stream){
      this.stream = stream;
    }
    
    /**
     * Print a textual representation of the given tree structure to the PrintStream object
     * specified with <code>setDestination</code>.
     */
    public void write(BinaryTreeNode tree){
      List<BinaryTreeNode> row = TreeUtils.levelZero(tree);
      int height = tree.getHeight();
      int level = 0;
      
      
      while (level < height){
         String output = "";   
         int leadingSpace = (int)((Math.pow(2,height-level)-1)/2);
         int interSpace = (int)(Math.pow(2,height-level)-1);
         // Add leading space
         for (int i=0;i<leadingSpace;i++){
            output += "**";
         }
         for (BinaryTreeNode node: row){
            String onode = "";
            if (TreeUtils.isPlaceHolder(node)){
               output += "xx";
            } else {
            if (node.getItem()<10){
               onode = "0" + node.getItem();
            } else {
               onode = node.getItem() + "";
            }
            output += onode;
            }
            for (int i=0;i<interSpace;i++){
               output += "--";
            }
         }
         stream.print("Level: " + level + " LS: " + leadingSpace + " IS: " + interSpace);
         stream.println(output);
         level++;
         List<BinaryTreeNode> newRow = TreeUtils.nextLevel(row);
         row.clear();
         for (BinaryTreeNode node:newRow){
            row.add(node);
         }
      }
      stream.close();
    }
 }