/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package net.tutorit.checkpoint2;

import java.util.ArrayList;

/**
 *
 * @author jyrki
 */
public class PrinterPool extends MediaList<Printer> {

    @Override
    public String getAll(Printer med) {
        return med.toString();
    }    
    
}
