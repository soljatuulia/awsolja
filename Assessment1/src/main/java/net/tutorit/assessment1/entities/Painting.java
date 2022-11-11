/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package net.tutorit.assessment1.entities;

import jakarta.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author jyrki
 */
@XmlRootElement
public class Painting {
    private int id;
    private String artist="";
    private String painting="";
    
    public Painting(){
    }
    
    public Painting(int id,String artist,String painting){
        this.id=id;
        this.artist=artist;
        this.painting=painting;
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

    /**
     * @return the painting
     */
    public String getPainting() {
        return painting;
    }

    /**
     * @param painting the painting to set
     */
    public void setPainting(String painting) {
        this.painting = painting;
    }
}
