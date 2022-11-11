/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package net.tutorit.assessment1.resource;

import jakarta.annotation.Resource;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.sql.DataSource;
import net.tutorit.assessment1.entities.Product;

/**
 *
 * @author jyrki
 */
@Path("products")
public class ProductService {
    
    @GET
    public List<Product> getAll(){
        ArrayList<Product> pl=new ArrayList<>();
        try{
            // Tähän tietokantahaku ja vastauksen antaminen
            // Product-luokan lopusta löytyvä staattinen metodi saattaa auttaa....
        }
        catch(Exception ex){
            System.out.println("***********************Virhe");
            ex.printStackTrace();
        }
        return pl;
    }
}
