public class Main {


    public static void main(String args[]) {



final SimpleBST tree_a = new SimpleBST();
 tree_a.insert(72);tree_a.insert(50);tree_a.insert(59);
 tree_a.insert(51);tree_a.insert(68);

 final SimpleBST tree_b = new SimpleBST();
 tree_b.insert(59);tree_b.insert(72);tree_b.insert(50);
 tree_b.insert(68);tree_b.insert(51);

 final boolean similar = tree_a.similar(tree_b);
 System.out.println(similar ? "Similar" : "Not similar");
 final SimpleTreeWriter writer = new SimpleTreeWriterImpl(System.out);
 SimpleBST.print(tree_a, writer);
 System.out.println();
 SimpleBST.print(tree_b, writer); 
 
 }}