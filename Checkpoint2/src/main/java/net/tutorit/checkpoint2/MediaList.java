/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package net.tutorit.checkpoint2;

import java.util.ArrayList;

/**
 *
 * @author Solja
 */
abstract public class MediaList<T> {
    
    private ArrayList<T> media =new ArrayList<>();
    
    public void add(T m){
        media.add(m);
    }
    
    abstract public String getAll(T med);
    
    public void listThem() {
        System.out.println("Newspapers");        
        for (T c : media) {
            System.out.println(getAll(c));
        }
    }
    
    public void showPool() {
        System.out.println("Printers");
        for (T c : media) {
            System.out.println(getAll(c));
        }
    }
    
}
