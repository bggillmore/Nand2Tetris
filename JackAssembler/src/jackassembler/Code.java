/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jackassembler;

/**
 *
 * @author Graham
 */
public class Code {
    private String currentLine;
    
    //constructors
    public Code(){
        this("");
    }
    public Code(String currentLine){
        this.currentLine = currentLine;
    }
    
    //setters and getters
    public void setCurrentLine(String currentLine){
        this.currentLine = currentLine;
    }
    public String getCurrentLine(){
        return this.currentLine;
    }
    
    public static String dest(String destString){
        switch(destString){
            case "null":
                destString = "000";
                break;
            case "M":
                destString = "001";
                break;
            case "D":
                destString = "010";
                break;
            case "MD":
                destString = "011";
                break;
            case "A":
                destString = "100";
                break;
            case "AM":
                destString = "101";
                break;
            case "AD":
                destString = "110";
                break;
            case "AMD":
                destString = "111";
                break;
            default:
                destString = "";
                break;
        }
        return destString;
    }
}
