/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package net.virkkunen.report;

/**
 *
 * @author Solja
 */
public interface Reporter {
    
    void beginReport();
    void endReport();
    void addColumn(String title, int width);
    void printData(String data);
    void printData(int data);
    void printColumns();
}
