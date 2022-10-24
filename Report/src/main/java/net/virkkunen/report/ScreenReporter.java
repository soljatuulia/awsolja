
package net.virkkunen.report;

import java.util.ArrayList;

/**
 *
 * @author Solja
 */
public class ScreenReporter {
    
    private ArrayList<ColumnDef> columnDef = new ArrayList<>();
    // private int curCol = 0; -- te counteri, jos ehdit!colump
    
    public ScreenReporter() {
        
    }
    
    public void addColumn(String title, int width) {
        columnDef.add(new ColumnDef(title, width));
    }
    
    public void printData(String name) {        
        System.out.print(name);
        for(ColumnDef column : columnDef){
            columnWidth(column.getWidth()-name.length());
        }    
    }
    
    public void printData(int age) {
        System.out.print(age);
        for(ColumnDef column : columnDef){
            String str = Integer.toString(age);  
            int size = str.length();  
            columnWidth(column.getWidth()-size);
        }
        System.out.println(" ");
    }
    
    public void printColumns() {
        for(ColumnDef column : columnDef){
            System.out.print(column.getTitle());
            columnWidth(column.getWidth()-column.getTitleLength());
        }
        System.out.println(" ");
    }
    
    private void columnWidth(int width) {
        int i = 0;
        while (i < width) {
            System.out.print(" ");
            i++;
        }
    }
    
    
}

