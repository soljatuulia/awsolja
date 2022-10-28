/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package net.tutorit.checkpoint2;

/**
 *
 * @author jyrki
 */
public class Printer {
    private String name;
    private int pagesPerMinute;
    
    public Printer(String n, int p){
        name=n;
        pagesPerMinute=p;
    }
    
    public String toString(){
        return name+" prints "+pagesPerMinute+" pages per minute";
    }
}
