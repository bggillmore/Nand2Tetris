/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vm.translator;

/**
 *
 * @author Graham
 */
public class Parser {
    private String currentLine = "";
    
    //constructors
    public Parser(){
        this("");
    }
    public Parser(String currentLine){
        this.currentLine = currentLine;
    }
    
    //clears all comments, spaces, and tabs
    public String removeExtraFormatting(){
        String noFormatString = this.currentLine;
        /*if(noFormatString.contains(" ")){
            noFormatString = noFormatString.replace(" ", "");
        }*/
        if(noFormatString.contains("//")){
            noFormatString = noFormatString.substring(0, noFormatString.indexOf("//"));
        }
        if(noFormatString.contains("\t")){
            noFormatString = noFormatString.replace("\t", "");
        }
        return noFormatString;
    }
    
    //returns type of current command
    public String commandType(){
        String commandString = this.removeExtraFormatting();
        String commandType;
        if(!commandString.equals("")){
            if(commandString.contains("push")){
            commandType = "C_PUSH";
            }
            else if(commandString.contains("pop")){
                commandType = "C_POP";
            }
            else if(commandString.contains("label")){
                commandType = "C_LABEL";
            }
            else if(commandString.contains("if-goto")){
                commandType = "C_IF";
            }
            else if(commandString.contains("goto") && !commandString.contains("if")){
                commandType = "C_GOTO";
            }
            else if(commandString.contains("function")){
                commandType = "C_FUNCTION";
            }
            else if(commandString.contains("return")){
                commandType = "C_RETURN";
            }
            else if(commandString.contains("call")){
                commandType = "C_CALL";
            }
            else{
                commandType = "C_ARITHMITIC";
            }
            return commandType;
        }
        return "";
    }
    
    //returns arg1 
    public String arg1(){
        String commandType = this.commandType();
        String arg1String = this.removeExtraFormatting();
        //pull out the first arguement of selected cases
        switch(commandType){
            case "C_PUSH":
            case "C_POP":
            case "C_CALL":
            case "C_FUNCTION":
                arg1String = arg1String.substring(arg1String.indexOf(" ") + 1, 
                        arg1String.indexOf(" ", arg1String.indexOf(" ") + 1));
                break;
            case "C_ARITHMITIC":
                break;
            case "C_LABEL":
            case "C_GOTO":
            case "C_IF":
                arg1String = arg1String.substring(arg1String.indexOf(" ") + 1);
                break;
            default:
                arg1String = "";
                break;
        }
        //remove extra spaces even tho there should be none
        arg1String = arg1String.replace(" ", "");
        return arg1String;
    }
    
    //returns arg2 value
    public int arg2(){
        String commandType = this.commandType();
        String arg2String = this.removeExtraFormatting();
        int arg2Int;
        
        //select last arg from string
        switch(commandType){
            case "C_PUSH":
            case "C_POP":
            case "C_FUNCTION":
            case "C_CALL":
                arg2String = arg2String.substring(arg2String.indexOf(" ", arg2String.indexOf(" ")+1) +1);
                arg2String = arg2String.replace(" ", "");
                break;
            default:
                arg2String = "";
                break;
        }
        
        //convert to int, -99999 if null or empty
        if(arg2String != null && !arg2String.isEmpty()){
            arg2Int = Integer.parseInt(arg2String);
        }
        else{
            arg2Int = -99999; // this is to show if i somehow didnt select the correct characters from the string or 
                              // it was called incorrectly. it should never run because it should not be called on  
                              // any commands other than push pop function or call but if it does it should be obvious 
                              // to pick out considering it is out of the range on a 16 bit computer
        }
        return arg2Int;
    }
}
