/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package net.tutorit.checkpoint3;

import java.sql.Date;
import org.springframework.data.relational.core.mapping.Column;

/**
 *
 * @author jyrki
 */
public class Car {
    
    private Integer id;
    private String make;
    @Column("deploymentdate")
    private Date deploymentDate; //deploymentdate
    
    public String getMake(){
        return "vielä vähän kesken";
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

    /**
     * @return the deploymentDate
     */
    public Date getDeploymentDate() {
        return deploymentDate;
    }

    /**
     * @param deploymentDate the deploymentDate to set
     */
    public void setDeploymentDate(Date deploymentDate) {
        this.deploymentDate = deploymentDate;
    }
}
