/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package HashTables;

import java.io.*;

/**
 *
 * @author staff
 */
public class QuadraticProbing {
    int defaultarraysize = 5;
    String [] myarray = new String[defaultarraysize];
    
    // A naive hash fuunction implementation
    public static int hashVal(String key, int tablesize)
    {
        int hashIndex = 0;
        int temp = 0;
        
		for (int i = 0; i< key.length(); i++){
		   /** Convert string (key) into a natural number **/
		   temp = 1 * (temp + (int)key.charAt(i)); 
		}
		/** compute index in hash table **/
		hashIndex = temp % tablesize; 
		return hashIndex;
    }
        /**
	 * method that performs linear probing resolution
	 */
	public int findPos(String soughtKey, int tableSize)
	{       
                int i = 1;
		int soughtPos = hashVal(soughtKey,tableSize);
		while (myarray[soughtPos]!=null){
			soughtPos = soughtPos + (i*i);
			soughtPos = soughtPos % tableSize;
		}
		return soughtPos;
	}       
        /**
	 * Add elements to the hash table (Linear probing
	 */
	public String add(String newKey,int newtableSize)
	{
		int currentPos = findPos(newKey,newtableSize);
		return myarray[currentPos] = newKey;
	}
        
        /* Searching the hash table for an item */ 
        
	public int findKey(String soughtKey, int tableSize)
	{
                int i = 1;
                int soughtPos = hashVal(soughtKey,tableSize);
		while (myarray[soughtPos]!= soughtKey){
			soughtPos = soughtPos + (i*i);
			soughtPos = soughtPos % tableSize;
		}
		return soughtPos;
	}
        
        // method to facilitate outputing list
	public void outputTable( )
	{
		for(int i=0; i<myarray.length; i++){
			if (myarray[i] != null)
				{
					System.out.println("Hash["+i+"]: "+myarray[i]);
				}
			else{
				System.out.println("Hash["+i+"]: NULL");
			}
		}
	}
        
        public void display(int keyfound)
        {
                  System.out.println("Hash["+keyfound+"]: "+myarray[keyfound]);
        }

	/* main method example */
        
        public static void main(String[] args) throws IOException{
		  QuadraticProbing table = new QuadraticProbing();
		  int tablesize = 5;
		  InputStreamReader inp = new InputStreamReader(System.in); 
		  BufferedReader br = new BufferedReader(inp);
		  table.add("Lory",tablesize);
		  table.add("Bob",tablesize);  
		  table.add("Corie",tablesize);
                  table.add("April", tablesize);
		  table.outputTable( ); 
		  System.out.println("Search Hash Table ---- ");
                  int keyfound1 = table.findKey("Bob",tablesize);
                  table.display(keyfound1);
	  }   
    
}
