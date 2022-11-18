/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package net.virkkunen.springweb.entities;

import java.sql.Date;

/**
 *
 * @author Solja
 */
public class Car {
    
    private Integer id;
    private String make;
//    @Column("deploymentdate")
//    private Date deploymentDate; //deploymentdate
    
    public String getMake(){
        if (make==null) {
            return "ei ajoneuvoa";
        } else {
            return make;
        }
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
     * @param make the make to set
     */
    public void setMake(String make) {
        this.make = make;
    }

}
