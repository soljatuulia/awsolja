/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package net.tutorit.assessment1.resource;

import jakarta.annotation.Resource;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
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
    @Resource(lookup="jdbc/books")
    private DataSource myds;
    /*
    Sinun täytyy saada tietoantayhteys muodostettua, 
    jotta getAll-metodi voi palauttaa products-taulukosta löytyvät tuotteet.
    */
    
    @GET
    @Produces("application/json")    
    public List<Product> getAll(){
        ArrayList<Product> pl=new ArrayList<>();
        try{
            // Tähän tietokantahaku ja vastauksen antaminen
            // Product-luokan lopusta löytyvä staattinen metodi saattaa auttaa....
            Connection con = myds.getConnection();
            Statement stm = con.createStatement();
            ResultSet rs = stm.executeQuery("SELECT * FROM product");
            while(rs.next()){
                Product p = Product.fromResultSet(rs);
                pl.add(p);
            }
            rs.close();
            stm.close();
            con.close();
        }
        catch(Exception ex){
            System.out.println("***********************Virhe");
            ex.printStackTrace();
        }
        return pl;
    }
}
