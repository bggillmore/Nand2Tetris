/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jackassembler;
import java.util.Scanner;
import java.io.*;

public class JackAssembler {
    //create global scanner object
    static Scanner console = new Scanner(System.in);
    
    public static void main(String[] args) throws IOException {
        String fileName, binFile, currentLine;
        int count;
        //read input file and reader
        System.out.print("Enter name of assembly file: ");
        fileName = console.next();
        
        File asmFile = new File(fileName);
        Scanner inFile = new Scanner(asmFile);
        
        //create output file and writer
        System.out.print("Enter name of outputfile (existing files will be over writen): ");
        binFile = console.next();
        
        FileWriter fw = new FileWriter(binFile, false);
        PrintWriter outFile = new PrintWriter(fw);
        
        //create symbol table for mapping labels
        SymbolTable symTable = new SymbolTable();
        
        //itterate through each line and start to parse
        count=0;
        while(inFile.hasNext()){
            currentLine = inFile.nextLine();
            
            Parser thisLine = new Parser(currentLine);
            if(!thisLine.removeExtraFormatting().equals("")){
                //outFile.println(thisLine.removeExtraFormatting());
                switch(thisLine.commandType()){
                    case 0://labels
                        symTable.addEntry(thisLine.symbol(), count);
                        //outFile.println(symTable.getAddress(thisLine.symbol()));
                        break;
                    case 1://A commands
                        if(thisLine.isNumeric()){ //prints the numeric A instructions
                            int binInt = Integer.parseInt(thisLine.symbol());
                            outFile.print("0" + Code.toBinString(binInt, 15));
                            outFile.println();
                        }
                        else if(symTable.contains(thisLine.symbol())){ //prints the references to line numbers from labels
                            outFile.println("0" + 
                                    Code.toBinString(symTable.getAddress(thisLine.symbol()), 15)+ thisLine.symbol());
                        }
                        //NOTES!!!
                        /* you need to make a two pass assembler because if you reerence a label
                         * before you use it your symbol table will not contain the correct symbol.
                         * 1st pass: only add labels to table
                         * 2nd pass: do everything else but leave counter as is. You can use the last line number as your
                         * 1st variable space. That or copy what the book examples did. 
                         * you also need to figure out register addressing and hard code their values in.
                         */
                        count++; //only inc the line count if its not a comment and not a label
                        break;
                    case 2://C commands
                        outFile.print("111");
                        outFile.print(Code.comp(thisLine.comp()));
                        outFile.print(Code.dest(thisLine.dest()));
                        outFile.print(Code.jump(thisLine.jump()));
                        outFile.println();
                        count++; //only inc the line count if its not a comment and not a label
                        break;
                }
            }
        }
        inFile.close();
        outFile.close();
        System.exit(0);
        
    }//end main
}//end class
