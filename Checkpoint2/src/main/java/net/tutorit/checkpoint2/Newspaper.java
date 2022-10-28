/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package net.tutorit.checkpoint2;

/**
 *
 * @author jyrki
 */
public class Newspaper {
    private String name;
    private double price;
    
    public Newspaper(String n, double p){
        name=n;
        price=p;
    }
    
    public String getDescription(){
        return name+" costs "+price+" EUR";
    }
}
