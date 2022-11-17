/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package net.virkkunen.springweb.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 *
 * @author Solja
 */
@Entity
public class Author {
    
    @Id @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer id;
    @Column(name="firstname")
    private String firstname;
    @Column(name="lastname")
    private String lastname;

    @Override
    public boolean equals(Object o){
        if (o.getClass() != Author.class ) return false; 
        Author other = (Author)o;
        if (this.getId() != other.id) return false;
        if (!this.firstname.equals(other.firstname)) return false;
        if (!this.lastname.equals(other.lastname)) return false;
        return true;
    }

    @Override
    public int hashCode () {
        return getId();
    }

    /**
     * @return the id
     */
    public Integer getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * @return the firstname
     */
    public String getFirstName() {
        return firstname;
    }

    /**
     * @param firstname the firstname to set
     */
    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    /**
     * @return the lastname
     */
    public String getLastname() {
        return lastname;
    }

    /**
     * @param lastname the lastname to set
     */
    public void setLastname(String lastname) {
        this.lastname = lastname;
    }
        
}
