/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package net.tutorit.cpharjoitus1;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 *
 * @author jyrki
 */
public class Company {
    
    static final ArrayList<Person> employees = new ArrayList<>();
    private String name;
    
    public Company(String name) {
        this.name = name;
    }
    
    public void addEmployee(Person p) {
        employees.add(p);
    }
    
    public void addEmployee(String name, LocalDate startDate) {
        employees.add(new Person(name, startDate));
    }
    
    public void addEmployee(String name, LocalDate startDate, LocalDate endDate) {
        employees.add(new Person(name, startDate, endDate));
    }
    
    List<Person> getAll() {
        employees.sort((a,b) -> {
            return a.getName().compareTo(b.getName());
        });
        return employees;
    }
    
    public String getEmployeeInfo(String name) {
        for (Person p : employees) {
            if (p.getName().equals(name)) {
                if (p.getEndDate() == null) return p.getName() + " aloitti " + p.getStartDate() + " ja työsuhde jatkuu vielä";
                    return p.getName() + " aloitti " + p.getStartDate() + " ja lopetti " + p.getEndDate();
                }
            }
            return name + " ei ole työntekijärekisterissä";
        }
    }

    List <Person> getStillEmployed

    void exportEmployees(String fn) {
        try(PrintWriter fw=new PrintWriter(fn)) {
            for(Person p: employees){
                String s=this.getEmployeeInfo(p.getName());
                fw.println(s);
            }
            fw.close();
        }
        catch(IOException ioex){
            System.out.println("Virhe kirjoitettaess "+ioex.getMessage());
        }
    }        
    
    List <Person> getStillEmployed() {
        
    }
    

}
