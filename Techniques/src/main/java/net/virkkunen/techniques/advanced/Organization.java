/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package net.virkkunen.techniques.advanced;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author jyrki
 */
public class Organization {
    private int id;
    private int parentId;
    private String name;
    private List<Organization> children=new ArrayList<>();
    private List<Person> persons=new ArrayList();

    
    public Organization(String n,String ... names){
        this.name=n;
        for(String personName:names){
            persons.add(new Person(personName));
        }
    }
    
    public Organization(String name,int id,int parentId){
        this.name=name;
        this.id=id;
        this.parentId=parentId;
    }
    
    public void addChild(Organization o){
        children.add(o);
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
    public List<Organization> getChildren() {
        return children;
    }

    /**
     * @param children the children to set
     */
    public void setChildren(List<Organization> children) {
        this.children = children;
    }

    /**
     * @return the persons
     */
    public List<Person> getPersons() {
        return persons;
    }

    /**
     * @param persons the persons to set
     */
    public void setPersons(List<Person> persons) {
        this.persons = persons;
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
     * @return the parentId
     */
    public int getParentId() {
        return parentId;
    }

    /**
     * @param parentId the parentId to set
     */
    public void setParentId(int parentId) {
        this.parentId = parentId;
    }
}
