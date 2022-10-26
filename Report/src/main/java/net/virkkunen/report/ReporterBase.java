
package net.virkkunen.report;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Solja
 */
abstract class ReporterBase implements Reporter {
    
    private List<ColumnDef> columnDef = new ArrayList<>();
    private int column = 0;
    private Formatter formatter;
    
    public ReporterBase(Formatter formatter) {
        this.formatter = formatter;
    }  
    
    public void addColumn(String title, int width) {
        columnDef.add(new ColumnDef(title, width));        
    }

    private PrintWriter out = null;

// muokattava, käyttää formatter.begin    
    protected void printColumns() {
        if (out == null) return;
        out.println(formatter.begin(columnDef));
    }   
    
    private List<String> dataRow = new ArrayList<>();
    
// muokattava, käyttää formatter.row 
    public void printData(String str) {
        if (out == null) return;
        dataRow.add(str);
        column++;
//       out.print(pad(str,columnDef.get(column).getWidth()));
        
        if (column >= columnDef.size()){
            column = 0;
            out.println(formatter.row(columnDef, dataRow));
            dataRow = new ArrayList<>();
        }
    }

// muokattava?    
    public void printData(int number) {
        printData(""+number);
    }


    public void beginReport() {
        out = getWriter();
        printColumns();
    }    


    public void endReport() { 
        out.println(formatter.end(columnDef));
        out.flush();
        closeWriter(out);
    }
    
    abstract protected PrintWriter getWriter();
    
    abstract protected void closeWriter(PrintWriter pw);
    
}
