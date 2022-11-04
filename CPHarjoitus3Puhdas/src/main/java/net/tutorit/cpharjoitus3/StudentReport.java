/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package net.tutorit.cpharjoitus3;

import java.time.LocalDate;
import org.springframework.data.annotation.Id;

/**
 *
 * @author Solja
 */
public class StudentReport {
    
    @Id
    private Integer id;
    private String name;
    private LocalDate evaldate;
    private String classname;
    private String teacher;
    
    //oppilaan nimi, arviointipäivä, luokannimi ja opettajan nimi

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
     * @return the evaldate
     */
    public LocalDate getEvaldate() {
        return evaldate;
    }

    /**
     * @param evaldate the evaldate to set
     */
    public void setEvaldate(LocalDate evaldate) {
        this.evaldate = evaldate;
    }

    /**
     * @return the classname
     */
    public String getClassname() {
        return classname;
    }

    /**
     * @param classname the classname to set
     */
    public void setClassname(String classname) {
        this.classname = classname;
    }

    /**
     * @return the teacher
     */
    public String getTeacher() {
        return teacher;
    }

    /**
     * @param teacher the teacher to set
     */
    public void setTeacher(String teacher) {
        this.teacher = teacher;
    }
}
