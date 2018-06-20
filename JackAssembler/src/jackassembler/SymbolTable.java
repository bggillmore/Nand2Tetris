/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jackassembler;

import java.util.HashMap;

/**
 *
 * @author Graham
 * 
 */

public class SymbolTable {
    private final HashMap<String, Integer> st;
    //constructor (idk if its necesarry to do this way but seems like a good convention)
    public SymbolTable(){
        st = new HashMap<>();
    }
    
    //adds entries into hash map
    public void addEntry(String symbol, int address){
        st.put(symbol, address);
    }
    
    //returns true if symbol table contains given symbol, false if not
    public Boolean contains(String symbol){
        return st.containsKey(symbol);
    }
    
    //returns int address of given symbol
    public int getAddress(String symbol){
        return st.get(symbol);
    }
}
