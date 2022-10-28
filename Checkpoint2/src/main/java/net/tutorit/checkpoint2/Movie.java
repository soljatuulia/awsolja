/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package net.tutorit.checkpoint2;

/**
 *
 * @author Solja
 */
public class Movie extends TVBase {

    private int length;
    
    public Movie(String name, int length) {
        super(name);
        this.length = length;
    }


    public String toString() {
        return "duration " + this.length + " minutes";
    }

}
