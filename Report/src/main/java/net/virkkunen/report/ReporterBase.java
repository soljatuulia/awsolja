/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
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
abstract class ReporterBase implements Reporter {
    
    protected ArrayList<ColumnDef> columnDef = new ArrayList<>();
    protected int column = 0;
    private PrintWriter out = null;


    @Override
    public void addColumn(String title, int width) {
        columnDef.add(new ColumnDef(title, width));        
    }

    public void printColumns() {
        if (out == null) return;
        for(ColumnDef c : columnDef){
            out.print(pad(c.getTitle(),c.getWidth()));
        }
        out.println();
    }   
    
    public void printData(String str) {
        ColumnDef cd = columnDef.get(column);
        out.print(pad(str,columnDef.get(column).getWidth()));
        column++;
        if (column >= columnDef.size()){
            column = 0;
            out.println();
        }
    }
    
    public void printData(int number) {
        printData(""+number);
    }
    
    public void beginReport() {
        out = getWriter();
        printColumns();
    }    
       
    public void endReport() { 
        out.flush();
        out.close();
    }

    private String pad(String s, int l){
        String format = "%-"+l+"s";
        String pad = String.format(format, s).substring(0,l);
        return pad;
    }
    
    abstract protected PrintWriter getWriter();
    
    abstract protected void CloseWriter(PrintWriter pw);
    
}
