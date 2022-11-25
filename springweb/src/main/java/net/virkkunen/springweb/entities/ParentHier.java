/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package net.virkkunen.springweb.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import java.util.ArrayList;

/**
 *
 * @author Solja
 */
public class ParentHier {
    
    private Integer id;
    @JsonIgnore //json-muotoiluun
    private Integer parentId;
    private String name;
    @JsonInclude(Include.NON_NULL)
    private ArrayList<ParentHier> children; //alkuperäisestä luokasta puuttui Children-kokoelma, se lisättiin tänne. (Koska puuttuu tietokannasta ja sinne ei haluta koskea?)
    
    public ParentHier() {
        
    }
    
    public ParentHier(Parent p) {
        this.id = p.getId();
        this.parentId = p.getParentId();
        this.name = p.getName();
    }
    
    public void addChild(ParentHier child) {
        if (children==null) {
            children = new ArrayList<ParentHier>(); //jos ei vielä ole children-listaa, luodaan sellainen
        } 
            
        children.add(child); //lisätään objekti/lapsi listalle
        
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
     * @return the parentId
     */
    public Integer getParentId() {
        return parentId;
    }

    /**
     * @param parentId the parentId to set
     */
    public void setParentId(Integer parentId) {
        this.parentId = parentId;
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
     * @return the children
     */
    public ArrayList<ParentHier> getChildren() {
        return children;
    }

    /**
     * @param children the children to set
     */
    public void setChildren(ArrayList<ParentHier> children) {
        this.children = children;
    }
    
}
