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
    public enum commandName{
        C_PUSH, C_POP, C_LABEL, C_IF, C_GOTO, C_FUNCTION, C_RETURN, C_CALL, C_ARITHMETIC;
    }
    public commandName commandType(){
        String commandString = this.removeExtraFormatting();
        commandName commandType = null;
        if(!commandString.equals("")){
            if(commandString.contains("push")){
            commandType = commandName.C_PUSH;
            }
            else if(commandString.contains("pop")){
                commandType = commandName.C_POP;
            }
            else if(commandString.contains("label")){
                commandType = commandName.C_LABEL;
            }
            else if(commandString.contains("if-goto")){
                commandType = commandName.C_IF;
            }
            else if(commandString.contains("goto") && !commandString.contains("if")){
                commandType = commandName.C_GOTO;
            }
            else if(commandString.contains("function")){
                commandType = commandName.C_FUNCTION;
            }
            else if(commandString.contains("return")){
                commandType = commandName.C_RETURN;
            }
            else if(commandString.contains("call")){
                commandType = commandName.C_CALL;
            }
            else{
                commandType = commandName.C_ARITHMETIC;
            }
            return commandType;
        }
        return null;
    }
    
    //returns arg1 
    public String arg1(){
        commandName commandType = this.commandType();
        String arg1String = this.removeExtraFormatting();
        //pull out the first arguement of selected cases
        if(commandType != null){
            switch(commandType){
                case C_PUSH:
                case C_POP:
                case C_CALL:
                case C_FUNCTION:
                    arg1String = arg1String.substring(arg1String.indexOf(" ") + 1, 
                            arg1String.indexOf(" ", arg1String.indexOf(" ") + 1));
                    break;
                case C_ARITHMETIC:
                    break;
                case C_LABEL:
                case C_GOTO:
                case C_IF:
                    arg1String = arg1String.substring(arg1String.indexOf(" ") + 1);
                    break;
                default:
                    arg1String = "";
                    break;
            }
        }
        //remove extra spaces even tho there should be none
        arg1String = arg1String.replace(" ", "");
        return arg1String;
    }
    
    //returns arg2 value
    public int arg2(){
        commandName commandType = this.commandType();
        String arg2String = this.removeExtraFormatting();
        int arg2Int;
        
        //select last arg from string
        if(commandType != null){
            switch(commandType){
                case C_PUSH:
                case C_POP:
                case C_FUNCTION:
                case C_CALL:
                    arg2String = arg2String.substring(arg2String.indexOf(" ", arg2String.indexOf(" ")+1) +1);
                    arg2String = arg2String.replace(" ", "");
                    break;
                default:
                    arg2String = "";
                    break;
            }
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
