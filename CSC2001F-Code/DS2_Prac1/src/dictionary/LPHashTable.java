package dictionary;
import java.util.List;
/**
 * Simple hash table implementation of Dictionary using linear probing.
 * 
 * @author Stephan Jamieson 
 * @version 24/4/2015
 */
public class LPHashTable extends AbstractHashTable {

    /**
     * Create an LPHashTable with DEFAULT_SIZE table.
     */ 
    public LPHashTable() { super(); }
    
    /**
     * Create an LPHashTable with the given default size table.
     */
    public LPHashTable(int size) { super(size); }    
    
    protected int findIndex(String word) {
	// Implementation of findIndex() required here.
        int index = super.hashFunction(word);
        while(super.table[index]!=null && !super.table[index].getWord().equals(word)){
            index++;
            if (index == super.size()){
                index = 0;
            }
            super.incProbeCount();
        }
        return index;
    }

}
