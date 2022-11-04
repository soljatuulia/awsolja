/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package net.tutorit.cpharjoitus3;

import java.sql.Date;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;

/**
 *
 * @author jyrki
 */
public class Student {
    
    @Id
    private Integer id;
    private Integer classId; // class_id
    private String name;
    @Column("evaldate")
    private Date evalDate; //evaldate

    public Student(){
    }
    
    public Student(String name,int classId,Date evalDate){
        this.name=name;
        this.classId=classId;
        this.evalDate=evalDate;
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
     * @return the classId
     */
    public Integer getClassId() {
        return classId;
    }

    /**
     * @param classId the classId to set
     */
    public void setClassId(Integer classId) {
        this.classId = classId;
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
     * @return the evalDate
     */
    public Date getEvalDate() {
        return evalDate;
    }

    /**
     * @param evalDate the evalDate to set
     */
    public void setEvalDate(Date evalDate) {
        this.evalDate = evalDate;
    }
    
    public String toString(){
        return "("+id+") "+name+", "+classId+", "+evalDate;
    }
}
