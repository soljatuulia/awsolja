/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package net.virkkunen.report;

import java.util.ArrayList;

/**
 *
 * @author Solja
 */
abstract class ReportBase<T> {

    private ArrayList<T> reports = new ArrayList<>();
    private Reporter reporter;
    
    public ReportBase(Reporter rep) {
        this.reporter = rep;
        addColumns(reporter);
    }
    
    public void addData(T reps) {
        reports.add(reps);
    }
    
    public void doReport() {
        reporter.beginReport();
        for (T t : reports) {
            printData(reporter, t);
        }
        reporter.endReport();
    }
    
    abstract protected void addColumns(Reporter reporter);
    
    abstract protected void printData(Reporter reporter, T t);
    
}
