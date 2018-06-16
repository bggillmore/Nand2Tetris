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
        
        //itterate through each line and start to parse
        count=0;
        while(inFile.hasNext()){
            currentLine = inFile.nextLine();
            
            Parser thisLine = new Parser(currentLine);
            
            if(!thisLine.removeExtraFormatting().equals("")){
                //outFile.println(thisLine.removeExtraFormatting());
                switch(thisLine.commandType()){
                    case 0://labels
                        break;
                    case 1://A commands
                        if(thisLine.isNumeric()){
                            int binInt = Integer.parseInt(thisLine.symbol());
                            outFile.print("0" + Code.toBinString(binInt, 15));
                            outFile.println();
                        }
                        break;
                    case 2://C commands
                        outFile.print("111");
                        outFile.print(Code.comp(thisLine.comp()));
                        outFile.print(Code.dest(thisLine.dest()));
                        outFile.print(Code.jump(thisLine.jump()));
                        outFile.println();
                        break;
                }
            }

        }
        inFile.close();
        outFile.close();
        System.exit(0);
        
    }//end main
}//end class
