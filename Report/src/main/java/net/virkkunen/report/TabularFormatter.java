
package net.virkkunen.report;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Solja
 */
public class TabularFormatter implements Formatter {
    
    protected ArrayList<ColumnDef> columnDef = new ArrayList<>();
    protected List<String> dataRow = new ArrayList<>();

    private String pad(String s, int l){
        String format = "%-"+l+"s";
        String result = String.format(format, s).substring(0,l);
        return result;
    }      
    
    public String begin(List<ColumnDef> defs) {
        String first = "";
        for(ColumnDef c : columnDef)
            first += pad(c.getTitle(),c.getWidth());
        return first;
    }    

    public String end(List<ColumnDef> defs) {
        return "";
    }

    public String row(List<ColumnDef> defs, List<String> data) {
        String row = "";
        for (int i = 0; i < defs.size(); i++) {
            row += pad(data.get(i),defs.get(i).getWidth());
        }
        return row;
//            silmukoidaan molemmat läpi (defs ja data)
    }
    
    
    
}
