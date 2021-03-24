/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package HashTables;


public class SeparateChain {
   private class Node // defined the node
	{
		private String item;
		private Node next;
		
		public Node(String newItem, Node linkValue)
		{
			item = newItem;
			next = linkValue;
		}
	} // end of Node inner class
	
	int defaultarraysize = 5; // Default size of hash table
	private String [] myarray = new String[defaultarraysize];

	Node[] hash; // hash table pointers that each points to a list of nodes
	
	public SeparateChain ( )
	{
		// Creates a new empty hash table  
		hash = new Node[myarray.length]; // creates an array of SIZE for the hash keys
		for(int i=0; i<myarray.length; i++){
			hash[i] = null;   // hash table entry is initialized to point to null
		}
	}

	public int computehash (String key, int tableSize)
	{
		int hashIndex = 0;
		int temp = 0;
		for (int i = 0; i< key.length(); i++){
			/** Convert string (key) into a natural number **/
			temp = 1 * (temp + (int)key.charAt(i)); /**radix-37 notation**/
		}
		/** compute index in hash table **/
			hashIndex = temp % tableSize; /**Not good if hash table is large**/
		return hashIndex;
	}
	
	public void addtoHashTable(String itemName, int tableSize)
	{ // adding a node into the hash table
	  // Principle of addition -- like adding to head of linked list
			int target = computehash(itemName, tableSize);
			hash[target] = new Node(itemName, hash[target]);
	}
	
	// method to facilitate outputing list
	public void outputList()
	{
		for(int i=0; i<myarray.length; i++){
		Node position = hash[i];
                if (position == null){
                    System.out.println("Hash["+i+"]: NULL");
                }
                else{
		while (position != null)
			{
				System.out.println("Hash["+i+"]:"+position.item);
				position = position.next;
			}
                 }
		}
	}
	public static void main(String[] args)
	 {  
		int tablesize = 5;
		SeparateChain table = new SeparateChain();
		table.addtoHashTable("April",tablesize);
		table.addtoHashTable("Bob",tablesize);  
		table.addtoHashTable("Corie",tablesize);
                table.addtoHashTable("Corie",tablesize);
		table.outputList();
		System.out.println("-----------------------------------");
	 } 
}
