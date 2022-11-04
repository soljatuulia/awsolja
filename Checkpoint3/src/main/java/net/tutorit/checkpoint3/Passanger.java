/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package net.tutorit.checkpoint3;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;

/**
 *
 * @author jyrki
 */
public class Passanger {
    
    @Id
    private Integer id;
    @Column("car_id")
    private Integer carId; //car_id
    private String name;
    @Column("psgtype")
    private String passangerType; //psgtype
    
    public Passanger(){
    }
    
    public Passanger(String n, Integer c, String t){
        carId=c;
        name=n;
        passangerType=t;
    }
    
    /**
     * @return the Id
     */
    public Integer getId() {
        return id;
    }

    /**
     * @param Id the Id to set
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
    
    public String toString(){
        return id+","+name+","+carId+","+passangerType;
    }
}
