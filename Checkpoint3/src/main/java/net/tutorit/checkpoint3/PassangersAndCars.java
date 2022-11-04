/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package net.tutorit.checkpoint3;

import java.sql.Date;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;

/**
 *
 * @author Solja
 */
public class PassangersAndCars {
    
    @Id
    private Integer id;
    @Column("car_id")
    private Integer carId; //car_id
    private String name;
    @Column("psgtype")
    private String passangerType; //psgtype
    private String make;
    @Column("deploymentdate")
    private Date deploymentDate; //deploymentdate

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
     * @return the carId
     */
    public Integer getCarId() {
        return carId;
    }

    /**
     * @param carId the carId to set
     */
    public void setCarId(Integer carId) {
        this.carId = carId;
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
     * @return the passangerType
     */
    public String getPassangerType() {
        return passangerType;
    }

    /**
     * @param passangerType the passangerType to set
     */
    public void setPassangerType(String passangerType) {
        this.passangerType = passangerType;
    }

    /**
     * @return the make
     */
    public String getMake() {
        return make;
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
