/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package net.virkkunen.bookapp;

/**
 *
 * @author Solja
 */
public class CompanyCustomer implements Customer {

    @Override
    public void buyBook(Book b) {
        System.out.println("Company buys book " + b.getTitle() + " at price " + b.getPrice());
    }
    
}
