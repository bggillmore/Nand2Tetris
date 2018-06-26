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
        
        //get path from user
        System.out.println("Enter the path of the containing folder.");
        System.out.print("Enter 'c' for current dir: ");
        path = console.next();
        
        if(path.equals("c")){
            path = System.getProperty("user.dir");
        }
        
        //get *.vm files from path
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
                
                outFile.println(thisLine);
            }

        }
        outFile.close();
        System.exit(0);
        
    }//end main
}//end class
