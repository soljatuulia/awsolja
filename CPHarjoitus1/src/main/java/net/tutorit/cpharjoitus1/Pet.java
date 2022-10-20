/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package net.tutorit.cpharjoitus1;

/**
 *
 * @author Solja
 */
public class Pet {
    
    private String name;
    private String breed;
    
    public Pet(String name, String breed) {
        this.name = name;
        this.breed = breed;
    }
    
    public Pet(String name) {
        this.name = name;
    }
    
    public Pet() {
        
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBreed() {
        return breed;
    }

    public void setBreed(String breed) {
        this.breed = breed;
    }
    
}
