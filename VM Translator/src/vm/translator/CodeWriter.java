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
                asmString += "//and\n";
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
                asmString += "//eq\n";
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
                asmString += "//eq\n";
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
    public static String WritePushPop (commandName command, String segment, int index){ 
        String asmString = "";
        switch(command.toString()){
            case "C_PUSH":
                if(segment.equals("constant")){
                    asmString += "//" + command + " " + segment + " " + index +"\n";
                    asmString += "@" + index + "\n";
                    asmString += "D=A\n";
                    asmString += "@SP\n";
                    asmString += "A=M\n";
                    asmString += "M=D\n";
                    asmString += "D=A+1\n";
                    asmString += "@SP\n";
                    asmString += "M=D\n";
                    
                }
                else if(segment.equals("local")){
                    asmString += "";
                }
                break;
            case "C_POP":
                
                break;
            default:
                asmString = "";
                break;
        }
        return asmString;
    }
}
