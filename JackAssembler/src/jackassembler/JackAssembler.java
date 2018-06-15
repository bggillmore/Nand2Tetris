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
                outFile.println(thisLine.dest());
            }
            
            
        }
        inFile.close();
        outFile.close();
        System.exit(0);
        
    }//end main
}//end class
