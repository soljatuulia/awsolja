/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package net.virkkunen.bookjdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Solja
 */
public class BookDAO {
    
    private Connection getConnection() throws SQLException {
        try {    
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/books","librarian","test123");
            return con;
       
        } catch (SQLException ex) {    
            ex.printStackTrace();
        } return null;
    }
    
    private Book bookFromResultSet(ResultSet rs) {
        try {
            Book b = new Book();
            b.setId(rs.getInt("id"));
            b.setAuthorId(rs.getInt("author_id"));
            b.setTitle(rs.getString("title"));
            return b;
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return null;
    }    
    
    /* CRUDit myöhemmäksi */
    
    public Book get(int id) {
        // prepared statement
        try {
            Connection con = getConnection();
            String sql = "Select * from book where id=?";
            PreparedStatement stm = con.prepareStatement(sql);
            stm.setInt(1, id);
            ResultSet rs = stm.executeQuery();
            Book b = null;
            if (rs.next()) {
                b = bookFromResultSet(rs);
            }
            rs.close();
            stm.close();
            con.close();
            return b;
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        
        return null;
    }
    
    public List<Book> getAll() {
        // statement (ei prepared)
        ArrayList<Book> booklist = new ArrayList<>();
        try {
            Connection con = getConnection();
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * from book ORDER BY title");
            while (rs.next()) {
                booklist.add(bookFromResultSet(rs));
            }
            rs.close();
            stmt.close();
            con.close();
            // return booklist;
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return booklist;
    }
    
    public Book create(Book b) {
        // prepared statement
        try {
            Connection con = getConnection();
            String sql = "INSERT INTO book (title) VALUES (?)";
            PreparedStatement stm = con.prepareStatement(sql);
            stm.setString(1, b.getTitle());
            int rowsAffected = stm.executeUpdate(); // päivitetään!
            ResultSet keys = stm.getGeneratedKeys(); // kysytään erikseen, mitä kaikkia primary keyta lisättiin
            if (keys.next()) {
                
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return null;
    }
    
    public Book update(Book b) {
        return null;
    }
    
    public boolean delete(int id) {
        return false;
    }
    
    public Author getAuthorOfBook(int book) {
        return new AuthorDAO().getAuthorOfBook(book);
    }    
    
    public List<Book> getBooksOfAuthor(int author_id) {
        ArrayList<Book> bl=new ArrayList<>();
        try{
            Connection con=getConnection();
            String sql="SELECT * FROM book WHERE author_id=?";
            PreparedStatement stm=con.prepareStatement(sql);
            stm.setInt(1, author_id);
            ResultSet rs=stm.executeQuery();
            while(rs.next()){
                bl.add(bookFromResultSet(rs));
            }
            stm.close();
            con.close();
        }
        catch(SQLException ex){
            ex.printStackTrace();
        }
        return bl;
    }
    
    public void getAuthor(Book book) {
        // reads the author of the book and places it to the author field
        book.setAuthor(getAuthorOfBook(book.getId()));
    }
    
}
