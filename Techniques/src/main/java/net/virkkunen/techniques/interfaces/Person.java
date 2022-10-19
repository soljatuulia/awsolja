/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package net.virkkunen.techniques.interfaces;

/**
 *
 * @author Solja
 */
public class Person implements Worker {
    
    private String name;
    
    public Person(String name) {
        this.name = name;
    }
    
    @Override
    public void pay(double amount) {
        System.out.println(this.name + " is payed " + amount + " EUR and " +
                amount * 0.25 + " as social security fees");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
