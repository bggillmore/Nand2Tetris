/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vm.translator;

import vm.translator.Parser.commandName;

/**
 *
 * @author Graham
 */
public class CodeWriter {
    //Writes the asmbely code that is the translation of the given arithmatic command
    public static String writeArithmetic(String arthString){
        String asmString; 
        
        //one for each type of command
        switch (arthString) {
            case "add":
                asmString = "D=D+A";
                break;
            case "sub":
                asmString = "D=D-A";
                break;
            case "and":
                asmString = "D&A";
                break;
            case "neg":
                asmString = "-A";
                break;
            case "not":
                asmString = "!A";
                break;
            case "eq":
                //do something, place holder for now
                asmString = "eq";
                break;
            case "gt":
                //do something, place holder for now
                asmString = "gt";
                break;
            case "lt":
                //do something, place holder for now
                asmString = "lt";
                break;
            default:
                asmString = "";
                break;
        }
        return asmString;
    }
    
    //Writes the assembly code that is the translation of the given command, 
    //where command is one of the two enumerated values: C_PUSH or C_POP. 
    public static String WritePushPop (commandName command, String segment, int index){ 
        String asmString = "";
        switch(command.toString()){
            case "C_PUSH":
                if(segment.equals("constant")){
                    asmString = "D=A\n" + "@" + index;
                }
                break;
            case "C_POP":
                asmString = "A=D";
                break;
            default:
                asmString = "";
                break;
        }
        return asmString;
    }
}
