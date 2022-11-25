/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package net.tutorit.checkpoint6.employees;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 *
 * @author jyrki
 */
@Entity
public class Employee {
    @Id @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private String employeeId;
    private String superiorId;

    public Employee(){}
    
    public Employee(String name,String employeeId){
        this.name=name;
        this.employeeId=employeeId;
    }

    public Employee(String name,String employeeId,String superiorId){
        this.name=name;
        this.employeeId=employeeId;
        this.superiorId=superiorId;
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
     * @return the employeeId
     */
    public String getEmployeeId() {
        return employeeId;
    }

    /**
     * @param employeeId the employeeId to set
     */
    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
    }

    /**
     * @return the superiorId
     */
    public String getSuperiorId() {
        return superiorId;
    }

    /**
     * @param superiorId the superiorId to set
     */
    public void setSuperiorId(String superiorId) {
        this.superiorId = superiorId;
    }
}
