/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package net.virkkunen.bandsweb.resource;

import jakarta.annotation.Resource;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.Response;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.sql.DataSource;
import net.virkkunen.bandsweb.entities.Author;
import net.virkkunen.bandsweb.entities.Book;

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
    
    @GET
    @Produces("application/json")
    @Path("{id}")
    public Response getAuthor(@PathParam("id") int id){
        try{
            Author a=new Author();
            Connection con=myds.getConnection();
            Statement stm=con.createStatement();
            ResultSet rs=stm.executeQuery("SELECT * FROM author WHERE id="+id);
            if(rs.next()){
                a.setFirstName(rs.getString("firstname"));
                a.setLastName(rs.getString("lastname"));
                a.setId(rs.getInt("id"));
            }
            else a=null;
            rs.close();
            stm.close();
            con.close();
            if (a!=null) return Response.ok(a).build();
        }
        catch(Exception ex){
            ex.printStackTrace();
        }
        return Response.status(Response.Status.NOT_FOUND).build();
    }
    

    @GET
    @Produces("application/json")
    @Path("{id}/books")
    public List<Book> getBooks(@PathParam("id") int id){
        ArrayList<Book> bl=new ArrayList<>();
        try{
            Connection con=myds.getConnection();
            Statement stm=con.createStatement();
            ResultSet rs=stm.executeQuery("SELECT * FROM book WHERE author_id="+id);
            while(rs.next()){
                Book b=new Book();
                b.setId(rs.getInt("id"));
                b.setTitle(rs.getString("title"));
                bl.add(b);
            }
            rs.close();
            stm.close();
            con.close();
        }
        catch(Exception ex){
            ex.printStackTrace();
        }
        return bl;
    }    
    
}
