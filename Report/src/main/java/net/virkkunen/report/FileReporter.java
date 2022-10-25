
package net.virkkunen.report;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Solja
 */
public class FileReporter extends ReporterBase {
   
    private String fileName;
    private PrintWriter out;
    
//    public FileReporter() {
//        
//    }
//    
    public FileReporter(String fileName) {
        this.fileName = fileName;
    }
    
    protected PrintWriter getWriter(){
        try { 
            return new PrintWriter(new FileWriter(fileName));
            } catch (Exception e) {
                System.out.println("Epäonnistui.");
            }
        return null;
    }

    @Override
    protected void CloseWriter(PrintWriter pw) {
        
    }
    
}

