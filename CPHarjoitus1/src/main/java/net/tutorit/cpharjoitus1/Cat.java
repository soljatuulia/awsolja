/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package net.tutorit.cpharjoitus1;

/**
 *
 * @author Solja
 */
public class Cat implements Pet {
    
    private String name;
        
    public Cat(String name) {
        this.name = name;
    }

    @Override
    public String getBasicInfo() {
        return "Norjalainen metsäkissa " + this.name;
    }
    
}
