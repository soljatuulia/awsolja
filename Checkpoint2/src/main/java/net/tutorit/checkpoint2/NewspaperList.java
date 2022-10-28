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
public class NewspaperList {
    private ArrayList<Newspaper> listing=new ArrayList<>();
    
    public void add(Newspaper p){
        listing.add(p);
    }
    
    public void listThem(){
        System.out.println("Newspapers");
        for(Newspaper p:listing){
            System.out.println(p.getDescription());
        }
    }
}
