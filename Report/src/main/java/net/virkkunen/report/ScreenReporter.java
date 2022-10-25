
package net.virkkunen.report;

import java.io.PrintWriter;
/**
 *
 * @author Solja
 */
public class ScreenReporter extends ReporterBase {
    
    protected PrintWriter getWriter(){
        return new PrintWriter(System.out);
    }

    protected void closeWriter(PrintWriter pw){
    }

}

