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
        String arg1String = this.currentLine;
        switch(commandType){
            case "C_PUSH":
                arg1String = arg1String.substring(arg1String.indexOf(" ") + 1, arg1String.indexOf(" ", arg1String.indexOf(" ") + 1));
                break;
            case "C_POP":
                arg1String = arg1String.substring(arg1String.indexOf(" ") + 1, arg1String.indexOf(" ", arg1String.indexOf(" ") + 1));
                break;
            case "C_ARITHMITIC":
                break;
            default:
                arg1String = "";
                break;
        }
        return arg1String;
    }
    
}
