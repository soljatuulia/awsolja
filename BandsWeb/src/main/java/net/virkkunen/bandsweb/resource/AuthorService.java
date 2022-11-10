/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package net.virkkunen.bandsweb.resource;

import jakarta.annotation.Resource;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.sql.DataSource;
import net.virkkunen.bandsweb.entities.Author;

/**
 *
 * @author Solja
 */
@Path("author")
public class AuthorService {
    
    @Resource(lookup="jdbc/books")
    private DataSource myds;
    
    @GET
    @Produces("application/json")
    public List<Author> getAllAuthors() {
        ArrayList<Author> al = new ArrayList<>();

        try {
            Connection con = myds.getConnection();
            Statement stm = con.createStatement();
            ResultSet rs = stm.executeQuery("SELECT * FROM author;");
            while (rs.next()) {
                Author a = Author.fromResultSet(rs);
                al.add(a);
            } 
            rs.close();
            stm.close();
            con.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        
        return al;
    }
    
}
