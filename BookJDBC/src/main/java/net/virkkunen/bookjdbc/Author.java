package net.virkkunen.bookjdbc;


import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Solja
 */
public class Author {
    
    private int id;
    private String firstName;
    private String lastName;
    private Date birthDate;
    private Date deathDate;
    private ArrayList<Book> books=null;

// soveltuvat konstruktorit    
    
    public Author(){
        
    }
    
    public Author(String fn, String ln, Date bd, Date dd) {
        this.firstName = fn;
        this.lastName = ln;
        this.birthDate = bd;
        this.deathDate = dd;
    }
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public Date getDeathDate() {
        return deathDate;
    }

    public void setDeathDate(Date deathDate) {
        this.deathDate = deathDate;
    }
    
    public String toString() {
        return "" + id + " " + firstName + " " + lastName + ", " + birthDate + "-" + deathDate;
    }

    /**
     * @return the books
     */
    public List<Book> getBooks() {
        return books;
    }

    /**
     * @param books the books to set
     */
    public void setBooks(List<Book> books) {
        this.books = books;
    }
    
}
