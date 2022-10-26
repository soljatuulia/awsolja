/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package net.virkkunen.report;

import java.util.List;

/**
 *
 * @author Solja
 */
public interface Formatter {
    
    String begin(List<ColumnDef> defs);
    String end(List<ColumnDef> defs);
    String row(List<ColumnDef> defs, List<String> data);

}
