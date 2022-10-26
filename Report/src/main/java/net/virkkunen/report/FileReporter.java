
package net.virkkunen.report;

import java.io.FileWriter;
import java.io.PrintWriter;

/**
 *
 * @author Solja
 */
public class FileReporter extends ReporterBase {
   
    private String fileName;
       
    public FileReporter(Formatter formatter, String fileName) {
        super(formatter);
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

    protected void closeWriter(PrintWriter pw) {
        pw.close();
    }
    
}

