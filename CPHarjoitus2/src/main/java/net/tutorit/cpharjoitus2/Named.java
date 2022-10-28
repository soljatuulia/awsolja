/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package net.tutorit.cpharjoitus2;

/**
 *
 * @author Solja
 */
@FunctionalInterface

public interface Named {
    
    String getName();
    
    default String getExtra() {
        return "Extra";
    }
       
    
}
