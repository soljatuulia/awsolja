/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package net.tutorit.checkpoint2;

/**
 *
 * @author Solja
 */
abstract public class TVBase {

    private String name;
    
    public TVBase(String name) {
        this.name = name;
    }
    
    public void print() {
        System.out.println(this.name + ", " + toString());
    }
    
}
