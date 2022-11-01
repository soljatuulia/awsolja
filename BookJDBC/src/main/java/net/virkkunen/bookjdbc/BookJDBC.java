/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package net.virkkunen.bookjdbc;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Solja
 */
public class BookJDBC {
    
    static void showResultSet(ResultSet rs) {
        try {
            ResultSetMetaData rmd=rs.getMetaData();
            for(int i=1;i<=rmd.getColumnCount();i++){
                System.out.print(rmd.getColumnName(i));
                if (i==rmd.getColumnCount()) System.out.println();
                else System.out.print(", ");
            }
            while(rs.next()){
                for(int i=1;i<=rmd.getColumnCount();i++){
                    System.out.print(rs.getString(i));
                    if (i==rmd.getColumnCount()) System.out.println();
                    else System.out.print(", ");
                }
            }        
        } catch (SQLException ex) {
            ex.printStackTrace();
        }        
    }
    
    static void getAllAuthors() {
        try {
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/books","librarian","test123");
            Statement stm = con.createStatement();
            ResultSet rs = stm.executeQuery("SELECT * from author");
            showResultSet(rs);
//            while(showResultSet().next()) {
//                System.out.println(rs.getString(2));
//            }
            rs.close();
            stm.close();
            con.close();
        }
        catch(SQLException ex) {
            ex.printStackTrace();
        }
    }  
    
    public static void main(String[] args) {
        BookDAO bdao = new BookDAO();
        Book b1 = bdao.get(3);
        System.out.println("Book 1: " + b1);
        
        List<Book> bl = bdao.getAll();
        for (Book b : bl) {
            System.out.println(b);
        }
        
        //getAllAuthors();
//        AuthorDAO dao=new AuthorDAO();
//        
//        Author a=dao.get(3);
//        dao.getBooks(a);
//        System.out.println(a.getLastName()+"'s books:");
//        for (Book b : a.getBooks()) {
//            System.out.println(b.getTitle());
//        }
////        System.out.println("Author 1: "+a);
//        
////        Author a1 = new Author("Elena", "Ferrante", Date.valueOf("1943-04-05"), null);
////        dao.create(a1);
//
//        Author b = dao.getAuthorOfBook(3);
//        System.out.println("Author 2:"+b);
//        
//        List<Author> authors = dao.getAll();
//        for (Author ax : authors) {
//            System.out.println(ax);
//        }
        
        

    }
}
