/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package net.tutorit.checkpoint5.entities;

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
public class Painting {
    
    @Id @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private String artist;    
    
    public Painting() {
        
    }
    
    public Painting(Integer i, String n, String a) {
        this.id = i;
        this.name = n;
        this.artist = a;
    }

    @Override
    public boolean equals(Object o){
        if (o.getClass() != Painting.class ) return false; 
        Painting other = (Painting)o;
        if (this.getId() != other.id) return false;
        if (!this.name.equals(other.name)) return false;
        if (!this.artist.equals(other.artist)) return false;
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
     * @return the artist
     */
    public String getArtist() {
        return artist;
    }

    /**
     * @param artist the artist to set
     */
    public void setArtist(String artist) {
        this.artist = artist;
    }
    
}
