/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package net.tutorit.cpharjoitus2;

/**
 *
 * @author Solja
 */
public class Person implements Named {
    
    private String name;

    public Person(String name) {
        this.name = name;
    }

    @Override
    public String getName() {
        return this.name;
    }

}
