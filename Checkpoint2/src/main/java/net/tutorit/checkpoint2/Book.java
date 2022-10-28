/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package net.tutorit.checkpoint2;

/**
 *
 * @author Solja
 */
public class Book {
    
    private String title;
    private int pages;

    public Book(String t) {
        title = t;
    }
    
    public Book (int p) {
        pages = p;
    }

    void print() {
        System.out.println("In a hole in the ground there lived a hobbit");
    }

    public void setTitle(String t) {
        this.title = t;
    }
    
    public String getTitle() {
        return title;
    }

    public int getPages() {
        return pages;
    }

    public void setPages(int p) {
        pages = pages;
    }
    
    public String toString() {
        return title;
    }
    
}
