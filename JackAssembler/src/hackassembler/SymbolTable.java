/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hackassembler;

import java.util.HashMap;

/**
 * Benjamin Gillmore
 * 6/21/18
 * Symbol Table implementation to store and translate mem locations from labels and variables 
 */

public final class SymbolTable {
    private final HashMap<String, Integer> st;
    //constructor (idk this is good convention to have predefineds in the constructor)
    public SymbolTable(){
        st = new HashMap<>();
        this.addEntry("SP", 0);
        this.addEntry("LCL", 1);
        this.addEntry("ARG", 2);
        this.addEntry("THIS", 3);
        this.addEntry("THAT", 4);
        this.addEntry("R0", 0);
        this.addEntry("R1", 1);
        this.addEntry("R2", 2);
        this.addEntry("R3", 3);
        this.addEntry("R4", 4);
        this.addEntry("R5", 5);
        this.addEntry("R6", 6);
        this.addEntry("R7", 7);
        this.addEntry("R8", 8);
        this.addEntry("R9", 9);
        this.addEntry("R10", 10);
        this.addEntry("R11", 11);
        this.addEntry("R12", 12);
        this.addEntry("R13", 13);
        this.addEntry("R14", 14);
        this.addEntry("R15", 15);
        this.addEntry("SCREEN", 16384);
        this.addEntry("KBD", 24576);
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
