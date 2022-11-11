/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package net.tutorit.assessment1.ejb;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.Resource;
import jakarta.ejb.Singleton;
import jakarta.ejb.Startup;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import javax.sql.DataSource;

/**
 *
 * @author jyrki
 */
@Singleton
@Startup
public class DBCreator {
    @Resource(lookup="jdbc/books")
    private DataSource myds;


    @PostConstruct
    public void init(){
        try{
            Connection con=myds.getConnection();
            createTables(con);
            con.close();
        }
        catch(Exception ex){
            System.out.println("*************** VIRHE ******************");
        }
    }


    private void dropCreate(Connection con,String table,String create){
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
    
    private void createTables(Connection con){
        dropCreate(con,"manufacturer","(id int primary key not null auto_increment,name varchar(32))");
        dropCreate(con,"product","(id int primary key not null auto_increment, manufacturer_id int, product_name varchar(32), price double)");       
        try(Statement stm=con.createStatement()){
            stm.addBatch("insert into manufacturer values(null,'Lenovo')");
            stm.addBatch("insert into manufacturer values(null,'HP')");
            stm.addBatch("insert into manufacturer values(null,'Acer')");
            stm.executeBatch();
            stm.close();
        }
        catch(SQLException ex){
            System.out.println("Virhe luodessa class-taulua");
            ex.printStackTrace();
        }
        try(Statement stm=con.createStatement()){
            stm.addBatch("insert into product values(null,1,'Thinkpad',1230.43)");
            stm.addBatch("insert into product values(null,2,'Elitebook',639.99)");
            stm.addBatch("insert into product values(null,1,'Yoga',1020.10)");
            stm.executeBatch();
            stm.close();
        }
        catch(SQLException ex){
            System.out.println("Virhe luodessa class-taulua");
            ex.printStackTrace();
        }
    }
    

}
