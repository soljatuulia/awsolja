/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package net.tutorit.assessment1.entities;

import jakarta.xml.bind.annotation.XmlRootElement;
import java.sql.ResultSet;
 
/**
 *
 * @author jyrki
 */
@XmlRootElement
public class Product {
    
    //@Id
    private int id;
    //@Column("product_name")
    private String productName; //product_name
    private double price;

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
     * @return the productName
     */
    public String getProductName() {
        return productName;
    }

    /**
     * @param productName the productName to set
     */
    public void setProductName(String productName) {
        this.productName = productName;
    }

    /**
     * @return the price
     */
    public double getPrice() {
        return price;
    }

    /**
     * @param price the price to set
     */
    public void setPrice(double price) {
        this.price = price;
    }
    
    static public Product fromResultSet(ResultSet rs){
        try{
            Product p=new Product();
            p.setId(rs.getInt("id"));
            p.setProductName(rs.getString("product_name"));
            p.setPrice(rs.getDouble("price"));
            return p;
        }
        catch(Exception ex){
            System.out.println("******************* Tuotteen luonti epäonnistui");
        }
        return null;
    }    
}
