/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hackassembler;

/**
 * Benjamin Gillmore
 * 6/21/2018
 * This parser module breaks up lines of assembly code into its individual parts.
 */
public class Parser {
    private String currentLine;
    
    //constructers
    public Parser(){
        this("");
    }
    public Parser(String currentLine){
        this.currentLine = currentLine;
    }
    
    //setters and getters
    public void setCurrentLine(String newLine){
        this.currentLine = newLine;
    }
    public String getCurrentLine(){
        return this.currentLine;
    }
    
    //returns command type to main function in form of integer
    public int commandType(){
        int commandType = -1; //0 = L-Type, 1 = A-Type, 2 = C-Type
        
        //choose which instruction type current line is based on HACK asm syntax
        if(this.currentLine.indexOf("(") == 0){
            commandType = 0;
        }
        else if(this.currentLine.indexOf("@") == 0){
            commandType = 1;
        }
        else if(this.currentLine.contains("=") || this.currentLine.contains(";")){
            commandType = 2;
        }
        return commandType;
    }
    
    //removes comments from lines
    public String removeExtraFormatting(){
        String noFormatString = this.currentLine;
        if(this.currentLine.contains("//")){
            noFormatString = noFormatString.substring(0, noFormatString.indexOf("//"));
        }
        if(this.currentLine.contains(" ")){
            noFormatString = noFormatString.replace(" ", "");
        }
        if(this.currentLine.contains("\t")){
            noFormatString = noFormatString.replace("\t", "");
        }
        return noFormatString;
    }
    
    //returns the destination mnemonic from the line
    public String dest(){
        String destString = this.currentLine;
        if(this.commandType() == 2 && destString.contains("=")){
            destString =  destString.substring(0, destString.indexOf("="));
        }
        else{
            destString = "";
        }
        return destString;
    }
    
    //removes symbols from line and returns them
    public String symbol(){
        String symbolString = this.removeExtraFormatting();
        switch(this.commandType()){
            case 0: //remove label names from brckets
                symbolString = symbolString.substring(0,symbolString.indexOf(")"));
                symbolString = symbolString.substring(symbolString.indexOf("(") + 1);
                break;
            case 1: //remove label name after @ sign
                symbolString = symbolString.substring(symbolString.indexOf("@") + 1);
                if(symbolString.contains(" ")){
                    symbolString = symbolString.substring(0,symbolString.indexOf(" "));
                }
                break;
            default:
                symbolString = "";
                break;
        }
        return symbolString;
    }
    
    //removes the comp mnemonic and returns it
    public String comp(){
        String compString = this.removeExtraFormatting();
        if(this.commandType() == 2 && compString.contains("=")){
            compString = compString.substring(compString.indexOf("=")+1);
            return compString;
        }
        else if(this.commandType() == 2 && compString.contains(";")){
            compString = compString.substring(0, compString.indexOf(";"));
            return compString;
        }
        else{
            return "";
        }
    }
    
    //removes jump mnemonic and returns it
    public String jump(){
        String jmpString = this.removeExtraFormatting();
        if(this.commandType() == 2 && jmpString.contains(";")){
            jmpString = jmpString.substring(jmpString.indexOf(";")+1);
            return jmpString;
        }
        else{
            return "";
        }
    }
    
    //returns bool, true if string input is numeric false if not
    public boolean isNumeric(){
        String inputString = this.symbol();
        try{
            Integer.parseInt(inputString);
            return true;
        }
        catch(NumberFormatException e){
            return false;
        }
    }
}
