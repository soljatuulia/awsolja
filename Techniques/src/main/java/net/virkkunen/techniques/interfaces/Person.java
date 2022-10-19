/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package net.virkkunen.techniques.interfaces;

/**
 *
 * @author Solja
 */
public class Person implements Worker,Comparable {
    
    private String name = "Solja";
    private int age = 1;
    
    public Person() {
        
    }
    
    public Person(String name, int age) {
        this.name = name;
        this.age = age;
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
    
    @Override
    public String toString() {
        return this.name + " on " + this.getAge() + " vuotta vanha";
    }
    
    @Override
    public boolean equals(Object o){
        System.out.println("equals");
        if (o.getClass()!=this.getClass()) return false;
        Person p=(Person)o;
        if (!this.name.equals(p.getName())) return false;
        return true;
    }
    
    @Override
    public int hashCode(){
        System.out.println("hashCode");
        return name.hashCode();
    }

    @Override
    public int compareTo(Object o) {
        Person p = (Person)o;
        return this.name.compareTo(p.name);
    }

    /**
     * @return the age
     */
    public int getAge() {
        return age;
    }

    /**
     * @param age the age to set
     */
    public void setAge(int age) {
        this.age = age;
    }
    
    
}
