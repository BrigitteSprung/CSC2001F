package binarysearchtree;
import binarytree.LinkedBinaryTree;
import binarytree.Node;
import binarytree.Position;
//
import java.util.Comparator;

/**
 * A linked implementation of  BinarySearchTree.
 * 
 * @author Stephan Jamieson
 * @version 2/3/2016
 */
public class LinkedBST<E> extends LinkedBinaryTree<E> implements BinarySearchTree<E> {

    /**
     * Create a new BSTNode containing the given element.</br>
     * Methods that create nodes MUST use this.</br> 
     * This method overrides that in LinkedBinaryTree.</br>
     * Subclasses of this class must override it.
     */
    @Override
    protected BSTNode<E> makeNode(E element) {
        return new BSTNode<E>(this, element);
    }
    
    @SuppressWarnings("unchecked")
    /**
     * Convenience method for obtaining the BSTNode associated with a given position.
     */
    protected BSTNode<E> getNode(Position<E> p) { 
        assert(p.getOwner()==this);
        return (BSTNode<E>)p; 
    }
  
    // Comparator used to order nodes.
    private Comparator<E> comparator;

    /**
     * Create a new LinkedBST that orders its elements using the given Comparator.
     */
    public LinkedBST(Comparator<E> comparator) { 
        super();
        this.comparator=comparator; 
    }
    
    /**
     * Obtain the Comparator used by this LinkedTree to order its elements.
     */
    public Comparator<E> getComparator() { return comparator; }
        
    @Override
    /**
     * Obtain the position of the node containing the given element.</br>
     * If the element is not within the tree then the position of the leaf at which the search ended is returned.</br>
     * If the tree is empty then null is returned.
     */
    public Position<E> find(E element) {
        if (this.isEmpty()) {
            return null;
        }
        else {
            BSTNode<E> node = getNode(root());
            while (true) {
                final int test = comparator.compare(element, node.getContent());
                if (test==0||test<0&&!node.hasLeft()||test>0&&!node.hasRight()) {
                    return node;
                }
                else {
                    node = test<0&&node.hasLeft() ? node.getLeft() : node.getRight();
                }
            }        
        }    
    }
    
    /**
     * Inserts the given element in the tree and returns the position of the new node.</br>
     * If an instance of element is already in the tree then this method overwrites it with the given value. (Useful when implementing a map.)
     */
    public Position<E> insert(E element){
        if (this.isEmpty()) {
            this.setRoot(makeNode(element));
            return root();
        }
        else {
            final Position<E> position = find(element);        
            final BSTNode<E> node = getNode(position);
            final int compResult = comparator.compare(element, position.getContent());

            if (compResult==0) {
                node.setContent(element);
                return position;
            }
            else {
                final BSTNode<E> leaf = makeNode(element);
                leaf.setParent(node);
                
                if (compResult<0) {
                    node.setLeft(leaf);
                }
                else {
                    node.setRight(leaf);
                }
                return leaf;
            }
        }   
    }
    
    /**
     * Locate and remove the given element from the tree, returning the position of its parent or <code>null</code> if root.
     */
    public Position<E> delete(E element){
		// Your code here
      Position<E> position = find(element);
		return null;
    }

    
    /**
     * Perform a single rotation of the node at position p (i.e. rotate the node at position p above its parent.)and return the new position of the parent </br>
     * Requires that position p does not refer to the root.
     */
    public Position<E> rotate(Position<E> p){
		// Your code here
      final BSTNode<E> pNode = getNode(p);
      BSTNode<E> parent = pNode.getParent();
      BSTNode<E> leftChild = pNode.getLeft();
      BSTNode<E> rightChild = pNode.getRight();
      final int compResult = comparator.compare(parent.getContent(), pNode.getContent());
      if (compResult<0){
      // p is the right child
         pNode.setLeft(parent);
         parent.setRight(leftChild);
      } else {
      // p is the left child
         pNode.setRight(parent);
         parent.setLeft(rightChild);
      }
		return parent;
    }

    /**
     * Apply the tri-node restructuring algorithm at position p, returning the position of the new (sub) tree root.</br>
     * Requires that position p has a grandparent.
     */   
    public Position<E> restructure(Position<E> x){
		// Your code here
      BSTNode<E> xNode = getNode(x);
      BSTNode<E> y = xNode.getParent();
      BSTNode<E> z = y.getParent();
      
      final int XY = comparator.compare(xNode.getContent(), y.getContent());
      final int XZ = comparator.compare(xNode.getContent(), y.getContent());
      final int YZ = comparator.compare(y.getContent(), z.getContent());
      
      BSTNode<E> a;
      BSTNode<E> b;
      BSTNode<E> c;
      
      if (XZ>0 && XY<0){
         a=z;
         b=xNode;
         c=y;
      }
       else if (XZ<0 && XY>0){
         a=y;
         b=xNode;
         c=z;
      }
      else if (YZ>0 && XY>0){
         a=z;
         b=y;
         c=xNode;
      }
      else {
         a=xNode;
         b=y;
         c=z;
      }
      if (this.isRoot(z)){
         // uh?
         this.setRoot(b);
         b.setParent(null);
      }else{
         //if stuff then make stuff
         BSTNode<E> parent = z.getParent();
         final int compResult = comparator.compare(parent.getContent(), z.getContent());
      if (compResult<0){
      // p is the right child
         makeRightChild(parent, b);
      } else {
      // p is the left child
         makeLeftChild(parent, b);
      }

      }
      
      BSTNode<E> leftie = b.getLeft();
      final int lx = comparator.compare(leftie.getContent(), x.getContent());
      final int ly = comparator.compare(leftie.getContent(), y.getContent());
      final int lz = comparator.compare(leftie.getContent(), z.getContent());
      if(lz==0 && ly==0 && lz==0){
         makeRightChild(a, leftie);
      }
      BSTNode<E> rightie = b.getRight();
      final int rx = comparator.compare(rightie.getContent(), x.getContent());
      final int ry = comparator.compare(rightie.getContent(), y.getContent());
      final int rz = comparator.compare(rightie.getContent(), z.getContent());
      if(rz==0 && ry==0 && rz==0){
         makeLeftChild(c, rightie);
      }
      makeRightChild(b,a);
      makeLeftChild(b,c);
      
		return b;
    }
    public void makeLeftChild(BSTNode<E> x, BSTNode<E> y){
      x.setLeft(y);
      y.setParent(x);
    }
    public void makeRightChild(BSTNode<E> x, BSTNode<E> y){
      x.setRight(y);
      y.setParent(x);
    }


}
