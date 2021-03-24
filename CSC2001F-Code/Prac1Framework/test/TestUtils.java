import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintStream;
//
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;
/**
* Simple utilities to facilitate JUnit testing.
*
* @author Stephan Jamieson
* @version 20/2/2016	
*/
public class TestUtils {

	/**
	* Create a SimpleBST tree using the comma separated values in the given string.
	*/
	public static SimpleBST makeTree(final String data) {
        final Scanner scanner = new Scanner(data).useDelimiter("\\s*,\\s*");
		
        final SimpleBST tree = new  SimpleBST();
        
        while (scanner.hasNextInt() ){
            tree.insert(scanner.nextInt());
        }
		return tree;
	}
		
	/**
	* Create a binary search tree structure of BinaryTreeNode objects using the comma separated 
	* values in the given string. (i.e. A SimpleBST encapsulates such a structure. This method
	* permits such structures to be constructed for test purposes. 
	*/
	public static BinaryTreeNode makeNodeStructure(final String data) {
        final Scanner scanner = new Scanner(data).useDelimiter("\\s*,\\s*");
		
        BinaryTreeNode root=null;
		
        while (scanner.hasNextInt() ){
            root = TestUtils.insert(root, scanner.nextInt());
        }
		return root;
	}		

	/**
	* Compare two text files for equivalence.
	*/
	public static boolean check(final String testFile, final String oracleFile) throws IOException {
			final BufferedReader inTest = new BufferedReader(new FileReader(testFile));
			final BufferedReader inOracle = new BufferedReader(new FileReader(oracleFile));
		
			String testLine = inTest.readLine();
			String oracleLine = inOracle.readLine();
			while (testLine!=null && oracleLine!=null && testLine.equals(oracleLine)) {
				testLine = inTest.readLine();
				oracleLine = inOracle.readLine();
			}
			inTest.close();
			inOracle.close();
			return testLine==null&&oracleLine==null; 		
	}
		
	
    private static BinaryTreeNode insert(final BinaryTreeNode root, final Integer item) {
		if (root==null) {
			return new BinaryTreeNode(item);
		}
        else if (item<root.getItem()) {
            if (root.hasLeft()) {
                TestUtils.insert(root.getLeft(), item);
            }
            else {
                root.setLeft(new BinaryTreeNode(item));
            }
        }
        else {
            if (root.hasRight()) {
                TestUtils.insert(root.getRight(), item);
            }
            else {
                root.setRight(new BinaryTreeNode(item));
            }
        }
		return root;
    }
	
}