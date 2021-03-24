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
public class SCHashTable extends AbstractHashTable{
    protected ChainedEntry[] table;
    /**
     * Create an SCHashTable with DEFAULT_SIZE table.
     */ 
    public SCHashTable() { super(); }
    
    /**
     * Create an SCHashTable with the given default size table.
     */
    public SCHashTable(int size) { 
        this.table = new ChainedEntry[size];
        super.entries = 0;
    }    
    
    protected int findIndex(String word) {
	// Implementation of findIndex() required here.
        int index = super.hashFunction(word);
        if (table[index]==null){
            return -1;
        } else {
           return index; 
        }
        
    }
       @Override
    public boolean containsWord(String word) {
        int index = findIndex(word);
        if (index == -1){
            return false;
        } else {
        ChainedEntry entry = table[index];
            while (entry != null && !entry.getWord().equals(word)){
                entry = entry.getNext();
            }
            return entry == null;
        }
    }
    @Override
    public List<Definition> getDefinitions(String word) {
        if (containsWord(word)){
            ChainedEntry entry = table[findIndex(word)];
            while (entry != null && !entry.getWord().equals(word)){
                entry = entry.getNext();
            }
            if (entry == null){
                return null;
            } else {
                return entry.getDefinitions();
            }
        } else{
            return null;
        }
    }
    
    @Override
    public void insert(String word, Definition definition) {        
        int index = findIndex(word);
        if (index == -1){
            ChainedEntry entry = new ChainedEntry(word);
            entry.addDefinition(definition);
            table[index] = entry;
        } else {
            ChainedEntry nextEntry = table[index];
            ChainedEntry entry = new ChainedEntry(word, nextEntry);
            entry.addDefinition(definition);
        }
    }
}
