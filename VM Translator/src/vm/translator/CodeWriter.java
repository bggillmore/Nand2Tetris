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
    //Static declaration of variables to keep track of automatic labeling
    //This is important because the jumps will automatically jump to the last
    //label defined with the same name instead of the closest label w/ given name.
    static int eqCounter = 0;
    static int gtCounter = 0;
    static int ltCounter = 0;
    //Writes the asmbely code that is the translation of the given arithmatic command
    public static String writeArithmetic(String arthString){
        String asmString = ""; 
        //one for each type of command
        switch (arthString) {
            case "add":
                asmString += "//add\n";
                asmString += "@SP\n";
                asmString += "A=M-1\n";
                asmString += "D=M\n";
                asmString += "A=A-1\n";
                asmString += "D=D+M\n";
                asmString += "M=D\n";
                asmString += "D=A+1\n";
                asmString += "@SP\n";
                asmString += "M=D\n";
                break;
            case "sub":
                asmString += "//sub\n";
                asmString += "@SP\n";
                asmString += "A=M-1\n";
                asmString += "D=M\n";
                asmString += "A=A-1\n";
                asmString += "D=M-D\n";
                asmString += "M=D\n";
                asmString += "D=A+1\n";
                asmString += "@SP\n";
                asmString += "M=D\n";
                break;
            case "and":
                asmString += "//and\n";
                asmString += "@SP\n";
                asmString += "A=M-1\n";
                asmString += "D=M\n";
                asmString += "A=A-1\n";
                asmString += "D=D&M\n";
                asmString += "M=D\n";
                asmString += "D=A+1\n";
                asmString += "@SP\n";
                asmString += "M=D\n";
                break;
            case "or":
                asmString += "//or\n";
                asmString += "@SP\n";
                asmString += "A=M-1\n";
                asmString += "D=M\n";
                asmString += "A=A-1\n";
                asmString += "D=D|M\n";
                asmString += "M=D\n";
                asmString += "D=A+1\n";
                asmString += "@SP\n";
                asmString += "M=D\n";
                break;
            case "neg":
                asmString += "//neg\n";
                asmString += "@SP\n";
                asmString += "A=M-1\n";
                asmString += "D=-M\n";
                asmString += "M=D\n";
                asmString += "D=A+1\n";
                asmString += "@SP\n";
                asmString += "M=D\n";
                break;
            case "not":
                asmString += "//not\n";
                asmString += "@SP\n";
                asmString += "A=M-1\n";
                asmString += "D=!M\n";
                asmString += "M=D\n";
                asmString += "D=A+1\n";
                asmString += "@SP\n";
                asmString += "M=D\n";
                break;
            case "eq":
                asmString += "//eq\n";
                asmString += "@SP\n";
                asmString += "A=M-1\n";
                asmString += "D=-M\n";
                asmString += "A=A-1\n";
                asmString += "D=D+M\n";
                asmString += "@SP\n";
                asmString += "M=M-1\n";
                asmString += "M=M-1\n";
                asmString += "@NEQ_JUMP_"+ eqCounter +"\n";
                asmString += "D;JNE\n";
                asmString += "D=-1\n";
                asmString += "@EQ_JUMP_"+ eqCounter +"\n";
                asmString += "D;JNE\n";
                asmString += "(NEQ_JUMP_"+ eqCounter +")\n";
                asmString += "D=0\n";
                asmString += "(EQ_JUMP_"+ eqCounter +")\n";
                asmString += "@SP\n";
                asmString += "A=M\n";
                asmString += "M=D\n";
                asmString += "@SP\n";
                asmString += "M=M+1\n";
                eqCounter++;
                break;
            case "gt":
                asmString += "//gt\n";
                asmString += "@SP\n";
                asmString += "A=M-1\n";
                asmString += "D=-M\n";
                asmString += "A=A-1\n";
                asmString += "D=D+M\n";
                asmString += "@SP\n";
                asmString += "M=M-1\n";
                asmString += "M=M-1\n";
                asmString += "@GT_JUMP_"+ gtCounter +"\n";
                asmString += "D;JGT\n";
                asmString += "D=0\n";
                asmString += "@NGT_JUMP_"+ gtCounter +"\n";
                asmString += "0;JMP\n";
                asmString += "(GT_JUMP_"+ gtCounter +")\n";
                asmString += "D=-1\n";
                asmString += "(NGT_JUMP_"+ gtCounter +")\n";
                asmString += "@SP\n";
                asmString += "A=M\n";
                asmString += "M=D\n";
                asmString += "@SP\n";
                asmString += "M=M+1\n";
                gtCounter++;
                break;
            case "lt":
                asmString += "//lt\n";
                asmString += "@SP\n";
                asmString += "A=M-1\n";
                asmString += "D=-M\n";
                asmString += "A=A-1\n";
                asmString += "D=D+M\n";
                asmString += "@SP\n";
                asmString += "M=M-1\n";
                asmString += "M=M-1\n";
                asmString += "@LT_JUMP_"+ ltCounter +"\n";
                asmString += "D;JLT\n";
                asmString += "D=0\n";
                asmString += "@NLT_JUMP_"+ ltCounter +"\n";
                asmString += "0;JMP\n";
                asmString += "(LT_JUMP_"+ ltCounter +")\n";
                asmString += "D=-1\n";
                asmString += "(NLT_JUMP_"+ ltCounter +")\n";
                asmString += "@SP\n";
                asmString += "A=M\n";
                asmString += "M=D\n";
                asmString += "@SP\n";
                asmString += "M=M+1\n";
                ltCounter++;
                break;
            default:
                asmString = "";
                break;
        }
        return asmString;
    }
    
    //Writes the assembly code that is the translation of the given command, 
    //where command is one of the two enumerated values: C_PUSH or C_POP. 
    public static String WritePushPop (commandName command, String segment, int index, String binFile){ 
        String asmString = "";
        switch(command.toString()){
            //all 8 segment options for Push
            case "C_PUSH":
                switch(segment){
                    case "constant":
                        asmString += "//push constant " + index +"\n";
                        asmString += "@" + index + "\n";
                        asmString += "D=A\n";
                        asmString += "@SP\n";
                        asmString += "A=M\n";
                        asmString += "M=D\n";
                        asmString += "@SP\n";
                        asmString += "M=M+1\n";
                        break;
                    case "local":
                        asmString += "//push local " + index +"\n";
                        asmString += "@" + index + "\n";
                        asmString += "D=A\n";
                        asmString += "@LCL\n";
                        asmString += "A=M+D\n";
                        asmString += "D=M\n";
                        asmString += "@SP\n";
                        asmString += "A=M\n";
                        asmString += "M=D\n";
                        asmString += "@SP\n";
                        asmString += "M=M+1\n";
                        break;
                        
                    case "argument":
                        asmString += "//push argument " + index +"\n";
                        asmString += "@" + index + "\n";
                        asmString += "D=A\n";
                        asmString += "@ARG\n";
                        asmString += "A=M+D\n";
                        asmString += "D=M\n";
                        asmString += "@SP\n";
                        asmString += "A=M\n";
                        asmString += "M=D\n";
                        asmString += "@SP\n";
                        asmString += "M=M+1\n";
                        break;
                        
                    case "this":
                        asmString += "//push this " + index +"\n";
                        asmString += "@" + index + "\n";
                        asmString += "D=A\n";
                        asmString += "@THIS\n";
                        asmString += "A=M+D\n";
                        asmString += "D=M\n";
                        asmString += "@SP\n";
                        asmString += "A=M\n";
                        asmString += "M=D\n";
                        asmString += "@SP\n";
                        asmString += "M=M+1\n";
                        break;
                    case "that":
                        asmString += "//push that " + index +"\n";
                        asmString += "@" + index + "\n";
                        asmString += "D=A\n";
                        asmString += "@THAT\n";
                        asmString += "A=M+D\n";
                        asmString += "D=M\n";
                        asmString += "@SP\n";
                        asmString += "A=M\n";
                        asmString += "M=D\n";
                        asmString += "@SP\n";
                        asmString += "M=M+1\n";
                        break;
                    case "temp":
                        asmString += "//push temp " + index +"\n";
                        asmString += "@R" + (index + 5) + "\n";
                        asmString += "D=M\n";
                        asmString += "@SP\n";
                        asmString += "A=M\n";
                        asmString += "M=D\n";
                        asmString += "@SP\n";
                        asmString += "M=M+1\n";
                        break;
                    case "pointer":
                        asmString += "//push pointer " + index +"\n";
                        asmString += "@R" + (index + 3) + "\n";
                        asmString += "D=M\n";
                        asmString += "@SP\n";
                        asmString += "A=M\n";
                        asmString += "M=D\n";
                        asmString += "@SP\n";
                        asmString += "M=M+1\n";
                        break;
                    case "static":
                        asmString += "//push static " + index +"\n";
                        asmString += "@" + binFile + "." + index + "\n";
                        asmString += "D=M\n";
                        asmString += "@SP\n";
                        asmString += "A=M\n";
                        asmString += "M=D\n";
                        asmString += "@SP\n";
                        asmString += "M=M+1\n";
                        break;
                    default:
                        asmString = "";
                        break;
                }
                break;
            //all 8 segment options for POP  
            case "C_POP":
                switch(segment){
                    case "constant":
                        //nothing?
                        break;
                    case "local":
                        asmString += "//pop local " + index +"\n";
                        asmString += "@LCL\n";
                        asmString += "D=M\n";
                        asmString += "@" + index + "\n";
                        asmString += "D=A+D\n";
                        asmString += "@R13\n";
                        asmString += "M=D\n";
                        asmString += "@SP\n";
                        asmString += "AM=M-1\n";
                        asmString += "D=M\n";
                        asmString += "@R13\n";
                        asmString += "A=M\n";
                        asmString += "M=D\n";
                        break;
                    case "argument":
                        asmString += "//pop argument " + index +"\n";
                        asmString += "@ARG\n";
                        asmString += "D=M\n";
                        asmString += "@" + index + "\n";
                        asmString += "D=A+D\n";
                        asmString += "@R13\n";
                        asmString += "M=D\n";
                        asmString += "@SP\n";
                        asmString += "AM=M-1\n";
                        asmString += "D=M\n";
                        asmString += "@R13\n";
                        asmString += "A=M\n";
                        asmString += "M=D\n";
                        break;
                    case "this":
                        asmString += "//pop this " + index +"\n";
                        asmString += "@THIS\n";
                        asmString += "D=M\n";
                        asmString += "@" + index + "\n";
                        asmString += "D=A+D\n";
                        asmString += "@R13\n";
                        asmString += "M=D\n";
                        asmString += "@SP\n";
                        asmString += "AM=M-1\n";
                        asmString += "D=M\n";
                        asmString += "@R13\n";
                        asmString += "A=M\n";
                        asmString += "M=D\n";
                        break;
                    case "that":
                        asmString += "//pop that " + index +"\n";
                        asmString += "@THAT\n";
                        asmString += "D=M\n";
                        asmString += "@" + index + "\n";
                        asmString += "D=A+D\n";
                        asmString += "@R13\n";
                        asmString += "M=D\n";
                        asmString += "@SP\n";
                        asmString += "AM=M-1\n";
                        asmString += "D=M\n";
                        asmString += "@R13\n";
                        asmString += "A=M\n";
                        asmString += "M=D\n";
                        break;
                    case "temp":
                        asmString += "//pop temp " + index +"\n";
                        asmString += "@R" + (index + 5) + "\n";
                        asmString += "D=A\n";
                        asmString += "@R13\n";
                        asmString += "M=D\n";
                        asmString += "@SP\n";
                        asmString += "AM=M-1\n";
                        asmString += "D=M\n";
                        asmString += "@R13\n";
                        asmString += "A=M\n";
                        asmString += "M=D\n";
                        break;
                    case "static":
                        asmString += "//pop static " + index +"\n";
                        asmString += "@" + binFile + "." + index + "\n";
                        asmString += "D=A\n";
                        asmString += "@R13\n";
                        asmString += "M=D\n";
                        asmString += "@SP\n";
                        asmString += "AM=M-1\n";
                        asmString += "D=M\n";
                        asmString += "@R13\n";
                        asmString += "A=M\n";
                        asmString += "M=D\n";
                        
                        break;
                    case "pointer":
                        asmString += "//pop pointer " + index +"\n";
                        asmString += "@R" + (index + 3) + "\n";
                        asmString += "D=A\n";
                        asmString += "@R13\n";
                        asmString += "M=D\n";
                        asmString += "@SP\n";
                        asmString += "AM=M-1\n";
                        asmString += "D=M\n";
                        asmString += "@R13\n";
                        asmString += "A=M\n";
                        asmString += "M=D\n";
                        break;
                    default:
                        asmString = "";
                        break;
                }
                break;
            default:
                asmString = "";
                break;
        }
        return asmString;
    }
}
