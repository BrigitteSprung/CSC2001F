/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dictionary;

import java.util.List;

/**
 *
 * @author Brigitte
 */
public class QPHashTable extends AbstractHashTable {
    /**
     * Create an QPHashTable with DEFAULT_SIZE table.
     */ 
    public QPHashTable() { super(); }
    
    /**
     * Create an QPHashTable with the given default size table.
     */
    public QPHashTable(int size) { super(size);}  
    
    
    protected int findIndex(String word) {
	// Implementation of findIndex() required here.
        int index = super.hashFunction(word);
        int i = 1;
        while(super.table[index]!=null && !super.table[index].getWord().equals(word)){
            index += i*i;
            i++;
            if (index >= super.size()){
                index = index - super.size();
            }
            super.incProbeCount();
            if (getProbeCount()>tableSize()){
                return -1;
            }
        }

        return index;
    }
 
}
