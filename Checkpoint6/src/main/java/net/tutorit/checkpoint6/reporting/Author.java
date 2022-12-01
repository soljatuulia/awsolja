/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package net.tutorit.checkpoint6.reporting;

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
//@XmlRootElement
//@NamedQueries({@NamedQuery(name="PersonsByName", query="SELECT p FROM Person p ORDER BY p.name"),})
public class Author {
    
    @Id @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer id;
    @Column(name="firstname")
    private String firstName;
    @Column(name="lastname")
    private String lastName;

    @Override
    public boolean equals(Object o){
        if (o.getClass() != Author.class ) return false; 
        Author other = (Author)o;
        if (this.getId() != other.id) return false;
        if (!this.firstName.equals(other.firstName)) return false;
        if (!this.lastName.equals(other.lastName)) return false;
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
     * @return the firstName
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * @param firstName the firstName to set
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * @return the lastName
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * @param lastName the lastName to set
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
        
}
