/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package net.virkkunen.booksweb.entities;

import jakarta.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Solja
 */
@XmlRootElement // minimi, mikä tarvitaan, jotta henkilöitä voidaan liikuttaa myös xml-muodossa
public class Person {
    private int id=1;
    private String name="Jussi";
    private String email="nimi@joku.com";

    public Person() {
        
    }
    
    public Person(int id,String name,String email){
        this.id=id;
        this.name=name;
        this.email=email;
    }
    
    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param email the email to set
     */
    public void setEmail(String email) {
        this.email = email;
    }
}
