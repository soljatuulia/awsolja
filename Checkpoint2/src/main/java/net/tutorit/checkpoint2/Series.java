/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package net.tutorit.checkpoint2;

/**
 *
 * @author Solja
 */
public class Series extends TVBase {
    
    private int episodes;

    public Series(String name, int episodes) {
        super(name);
        this.episodes = episodes;
    }
    
    public String toString() {
        return this.episodes + " episodes";
    }
    
}
