/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package net.tutorit.cpharjoitus2;

/**
 *
 * @author Solja
 */
public class Product implements Named {

    private String product;
    
    public Product(String product) {
        this.product = product;
    }

    @Override
    public String getName() {
        return this.product;
    }
    
    public String getExtra() {
        return this.product;
    }
    
}
