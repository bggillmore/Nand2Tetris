/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hackassembler;

/**
 * Benjamin Gillmore
 * 6/21/18
 * This is the code module that translates part of the assembly language into binary
 */
public class Code {
    
    //converts the inputted dest string to binary, if dest is unknown it returns an empty string
    public static String dest(String destString){
        switch(destString){
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
                destString = "000";
                break;
        }
        return destString;
    }
    
    //converts the inputted comp string to binary, if unknown it returns an empty string.
    public static String comp(String compString){
        switch(compString){
            case "0":
                compString = "0101010";
                break;
            case "1":
                compString = "0111111";
                break;
            case "-1":
                compString = "0111010";
                break;
            case "D":
                compString = "0001100";
                break;
            case "A":
                compString = "0110000";
                break;
            case "!D":
                compString = "0001101";
                break;
            case "!A":
                compString = "0110001";
                break;
            case "-D":
                compString = "0001111";
                break;
            case "-A":
                compString = "0110011";
                break;
            case "D+1":
                compString = "0011111";
                break;
            case "A+1":
                compString = "0110111";
                break;
            case "D-1":
                compString = "0001110";
                break;
            case "A-1":
                compString = "0110010";
                break;
            case "D+A":
                compString = "0000010";
                break;
            case "D-A":
                compString = "0010011";
                break;
            case "A-D":
                compString = "0000111";
                break;
            case "D&A":
                compString = "0000000";
                break;
            case "D|A":
                compString = "0010101";
                break;
            case "M":
                compString = "1110000";
                break;
            case "!M":
                compString = "1110001";
                break;
            case "-M":
                compString = "1110011";
                break;
            case "M+1":
                compString = "1110111";
                break;
            case "M-1":
                compString = "1110010";
                break;
            case "D+M":
                compString = "1000010";
                break;
            case "D-M":
                compString = "1010011";
                break;
            case "M-D":
                compString = "1000111";
                break;
            case "D&M":
                compString = "1000000";
                break;
            case "D|M":
                compString = "1010101";
                break;
            default:
                compString = "";
                break;
        }
        return compString;
    }
    
    //converts the inputted jump string to binary, if unknown it returns an empty string
    public static String jump(String jumpString){
        switch(jumpString){
            case "JGT":
                jumpString = "001";
                break;
            case "JEQ":
                jumpString = "010";
                break;
            case "JGE":
                jumpString = "011";
                break;
            case "JLT":
                jumpString = "100";
                break;
            case "JNE":
                jumpString = "101";
                break;
            case "JLE":
                jumpString = "110";
                break;
            case "JMP":
                jumpString = "111";
                break;
            default:
                jumpString = "000";
                break;
        }
        return jumpString;
    }
    
    //converts integer(arg 1) to binary string of selected length(arg 2)
    public static String toBinString(int binInt, int binStringLength){
        String binString;
        binString = Integer.toBinaryString(binInt);
        //add "0"'s to front of bin string if length is less than the given
        while(binString.length() < binStringLength){
            binString = "0" + binString;
        }
        return binString;
    }
}
