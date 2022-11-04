/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package net.tutorit.cpharjoitus3;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author jyrki
 */
public class Populate {
    static String url="jdbc:mysql://localhost:3306/books";
    static String user="librarian";
    static String psw="test123";

    public static  Connection getConnection(){
        try{
            Connection con=DriverManager.getConnection(url,user,psw);
            return con;
        }
        catch(SQLException ex){
            ex.printStackTrace();
        }
        return null;
    }
    
    private static void dropCreate(Connection con,String table,String create){
        try{
            Statement stm=con.createStatement();
            stm.execute("DROP TABLE "+table);
            stm.close();
        }
        catch(SQLException ex){
            System.out.println("Not dropped: "+table);
        }
        try{
            Statement stm=con.createStatement();
            stm.execute("CREATE TABLE "+table+create);
            stm.close();
        }
        catch(SQLException ex){
            System.out.println("Not created: "+table);
        }
    }
    
    private static void createTables(Connection con){
        dropCreate(con,"student","(id int primary key not null auto_increment,class_id int,name varchar(32), evaldate date)");
        dropCreate(con,"class","(id int primary key not null auto_increment, classname varchar(32), teacher varchar(32))");       
        try(Statement stm=con.createStatement()){
            stm.addBatch("insert into class values(null,'1A','Jyrki')");
            stm.addBatch("insert into class values(null,'1B','Anssi')");
            stm.executeBatch();
            stm.close();
        }
        catch(SQLException ex){
            System.out.println("Virhe luodessa class-taulua");
            ex.printStackTrace();
        }
        try(Statement stm=con.createStatement()){
            stm.addBatch("insert into student values(null,2,'Taito','2022-10-28')");
            stm.addBatch("insert into student values(null,2,'Susanna','2022-10-24')");
            stm.addBatch("insert into student values(null,1,'Kia','2022-10-16')");
            stm.addBatch("insert into student values(null,1,'Henri','2022-10-10')");
            stm.addBatch("insert into student values(null,2,'Kristian','2022-10-06')");
            stm.addBatch("insert into student values(null,2,'Mikko','2022-10-18')");
            stm.addBatch("insert into student values(null,1,'Kasperi','2022-10-14')");
            stm.addBatch("insert into student values(null,1,'Aapo','2022-10-12')");
            stm.addBatch("insert into student values(null,2,'Reijo','2022-10-04')");
            stm.addBatch("insert into student values(null,2,'Sakari','2022-10-20')");
            stm.addBatch("insert into student values(null,1,'Monica','2022-10-02')");
            stm.addBatch("insert into student values(null,2,'Solja','2022-10-22')");
            stm.addBatch("insert into student values(null,2,'Taina','2022-10-26')");
            stm.addBatch("insert into student values(null,1,'Joel','2022-10-08')");
            stm.executeBatch();
            stm.close();
        }
        catch(SQLException ex){
            System.out.println("Virhe luodessa class-taulua");
            ex.printStackTrace();
        }
    }
    
    static public void init(){
        System.out.println("Alustetaan tietokanta");
        Connection con=getConnection();
        if (con==null){
            System.out.println("Yhteyden muodostus epäonnistui");
            return;
        }
        createTables(con);
        try{
            con.close();
        }
        catch(Exception e){
            System.out.println("Yhteyden sulkeminen epäonnistui");
        }
    }
}
