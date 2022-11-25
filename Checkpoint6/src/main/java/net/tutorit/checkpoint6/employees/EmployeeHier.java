/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package net.tutorit.checkpoint6.employees;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Solja
 */
public class EmployeeHier {

    private Integer id;
    private String name;
    private String employeeId;
    @JsonIgnore    
    private String superiorId;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private ArrayList<EmployeeHier> subordinates;
    private List<Superior> superiors = new ArrayList();    
    
    public EmployeeHier() {
        
    }

    public EmployeeHier(String n,String ... names){
        this.name=n;
        for(String superiorName:names){
            superiors.add(new Superior(superiorName));
        }
    }
    
    public EmployeeHier(Employee e) {
        this.id = e.getId();
        this.name = e.getName();
        this.superiorId = e.getSuperiorId();
        this.employeeId = e.getEmployeeId();
    }
    
    public void addSubordinate(EmployeeHier subordinate) {
        if (subordinates == null) {
            subordinates = new ArrayList<EmployeeHier>(); 
        } 
            
        subordinates.add(subordinate);         
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

    /**
     * @return the subordinates
     */
    public ArrayList<EmployeeHier> getSubordinates() {
        return subordinates;
    }

    /**
     * @param subordinates the subordinates to set
     */
    public void setSubordinates(ArrayList<EmployeeHier> subordinates) {
        this.subordinates = subordinates;
    }

    /**
     * @return the superiors
     */
    public List<Superior> getSuperiors() {
        return superiors;
    }

    /**
     * @param superiors the superiors to set
     */
    public void setSuperiors(List<Superior> superiors) {
        this.superiors = superiors;
    }
    
}
