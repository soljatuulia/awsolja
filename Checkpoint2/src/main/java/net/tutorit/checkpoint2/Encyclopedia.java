/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package net.tutorit.checkpoint2;

/**
 *
 * @author Solja
 */
public class Encyclopedia extends Book {

    public Encyclopedia(int p) {
        super(p);
    }

    public void setTitle(String t) {
        t = "Encyclopedia Britannica";
    }
    
    public String getTitle() {
        return "Encyclopedia Britannica";
    } 

    void print() {
        System.out.println(getTitle() + " has " +getPages() + " pages");
    }  
       
}
