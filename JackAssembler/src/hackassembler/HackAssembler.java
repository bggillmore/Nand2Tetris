/*
 * Benjamin Gillmore
 * 6/21/18
 * Hack assembler based on the book Nand2Tetris.
 */
package hackassembler;
import java.util.Scanner;
import java.io.*;

public class HackAssembler {
    //create global scanner object
    static Scanner console = new Scanner(System.in);
    
    public static void main(String[] args) throws IOException {
        //declare variables
        String fileName, binFile, currentLine;
        int count = 0, symNumber = 0;
        boolean secondPass = false;
        
        //read input file and create reader
        System.out.print("Enter name of assembly file: ");
        fileName = console.next();
        
        File asmFile = new File(fileName);
        Scanner inFile = new Scanner(asmFile);
        
        //create output file and writer
        System.out.print("Enter name of output file (existing files will be over writen): ");
        binFile = console.next();
        
        FileWriter fw = new FileWriter(binFile, false);
        PrintWriter outFile = new PrintWriter(fw);
        
        //create symbol table for mapping labels
        SymbolTable symTable = new SymbolTable();
        
        //itterate through each line and start to parse
        while(inFile.hasNext()){
            currentLine = inFile.nextLine();
            Parser thisLine = new Parser(currentLine);
            
            //cleans input and breaks down what type of instruction it is
            if(!thisLine.removeExtraFormatting().equals("")){
                switch(thisLine.commandType()){
                    case 0://labels
                        if(!secondPass){//only operate on L commands if on first pass
                            symTable.addEntry(thisLine.symbol(), count);
                        }
                        break;
                        
                    case 1://A commands
                        if(secondPass){ // only operate on A commands if on second pass
                           if(thisLine.isNumeric()){ //prints the numeric A instructions
                                int binInt = Integer.parseInt(thisLine.symbol());
                                outFile.print("0" + Code.toBinString(binInt, 15));
                                outFile.println();
                            }
                            else if(symTable.contains(thisLine.symbol())){ //prints the references to line numbers from labels
                                outFile.println("0" + 
                                Code.toBinString(symTable.getAddress(thisLine.symbol()), 15));
                            } 
                            else{ //adds variables to symtable and prints their mem location
                                symTable.addEntry(thisLine.symbol(), 16+symNumber);
                                symNumber++;
                                outFile.println(0 + 
                                        Code.toBinString(symTable.getAddress(thisLine.symbol()), 15));
                            }
                        }
                        count++; //only inc the line count if its not a comment and not a label
                        break;
                        
                    case 2://C commands
                        if(secondPass){ //only operate on c commands on second pass
                            outFile.print("111");
                            outFile.print(Code.comp(thisLine.comp()));
                            outFile.print(Code.dest(thisLine.dest()));
                            outFile.print(Code.jump(thisLine.jump()));
                            outFile.println();
                        }
                        count++; //only inc the line count if its not a comment and not a label
                        break;
                        
                }
            }
            //resets the scanner by creating a new one, resets the line count
            //and moves on to second pass.
            if(!inFile.hasNext() && !secondPass){
                secondPass = true;
                count = 0;
                inFile.close();
                inFile = new Scanner(asmFile);
            }
        }
        inFile.close();
        outFile.close();
        System.exit(0);
        
    }//end main
}//end class
