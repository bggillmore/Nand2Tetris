/*
 * Benjmain Gillmore
 * 6/25/18
 * VM Translator based on the book Nand2Tetris chapter 7
 */

package vm.translator;

import java.io.File;
import java.io.FileWriter;
import java.io.FilenameFilter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class VMTranslator {

    /**
     * @param args the command line arguments
     */
    
    static Scanner console = new Scanner(System.in);
    public static void main(String[] args) throws IOException {
        //variable declaration
        String path, binFile, thisLine;
        
        //get *.vm files from path
        path = System.getProperty("user.dir");
        File folder = new File(path);
        
        /* The next 6 lines i dont fully get. I know im creating a list of all
         * the files in the Folder but i do not quite understand how the filter
         * works. I should read up on these FileFilters to understand better.
         * https://stackoverflow.com/questions/5751335/using-file-listfiles-with-filenameextensionfilter
         */
        File[] fileList = folder.listFiles(new FilenameFilter(){
            @Override
            public boolean accept(File folder, String name){
                return name.toLowerCase().endsWith(".vm");
            }
        });
        
        //get name of output file
        System.out.print("Enter name of file to write to (existing data will be overwritten: ");
        binFile = console.next();
        
        //create scanner to read input files and printer to print output file
        Scanner inFile;
        FileWriter fw = new FileWriter(binFile, false);
        PrintWriter outFile = new PrintWriter(fw);
        
        //for each file create new scanner and begine to parse
        for(File file : fileList){
            inFile = new Scanner(file);
            while(inFile.hasNext()){
                thisLine = inFile.nextLine();
                Parser currentLine = new Parser(thisLine);
                //thisLine = currentLine.commandType();
                //thisLine = currentLine.removeExtraFormatting();
                //thisLine = currentLine.arg1();
                //thisLine = currentLine.arg2();
                if(!thisLine.equals("")){
                    if(currentLine.commandType()!= null){
                        switch(currentLine.commandType()){
                            case C_ARITHMETIC:
                                outFile.println(CodeWriter.writeArithmetic(currentLine.arg1()));
                                break;
                            case C_PUSH:
                            case C_POP:
                                outFile.println(CodeWriter.WritePushPop(currentLine.commandType(), currentLine.arg1(), currentLine.arg2()));
                                break;
                            default:
                                break;
                                
                        }
                    }
                }
            }

        }
        outFile.close();
        System.exit(0);
        
    }//end main
}//end class
