/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package net.tutorit.checkpoint2;

/**
 *
 * @author Solja
 */
public interface Priced {

    double getPrice();

    default String getName() {
        return "Default";
    }
    
}
