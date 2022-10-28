/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package net.tutorit.cpharjoitus2;

import java.util.ArrayList;

/**
 *
 * @author Solja
 * @param <T>
 */
public class CalcList<T> {
    
    protected ArrayList<T> calculations=new ArrayList<>();
    
    public void add(T t){
        calculations.add(t);
    }    
    
    
    
}
