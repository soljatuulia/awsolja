/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package net.virkkunen.bandsweb.entities;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Solja
 */
public class Author {
 
    private int id;
    private String firstName;
    private String lastName;

    
    static public Author fromResultSet(ResultSet rs) {
       
        try {
            Author a = new Author();     
            a.setId(rs.getInt("id"));
            a.setFirstName(rs.getString("firstname"));
            a.setLastName(rs.getString("lastname"));
            return a;
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        
        return null;
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
