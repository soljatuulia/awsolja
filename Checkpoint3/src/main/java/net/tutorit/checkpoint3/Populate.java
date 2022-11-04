/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package net.tutorit.checkpoint3;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 *
 * @author jyrki
 */
@Component
public class Populate {
    // Koska Populate-luokka on tällä kertaa springin beani,
    // voidaan konfiguraatio hakea spring datan konfiguraatiosta.....
    @Value("${spring.datasource.url}")
    String url;
    @Value("${spring.datasource.username}")
    String user;
    @Value("${spring.datasource.password}")
    String psw;
    
    public Connection getConnection(){
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
        dropCreate(con,"car","(id int primary key not null auto_increment,make varchar(32), deploymentdate date)");
        dropCreate(con,"passanger","(id int primary key not null auto_increment, car_id int,name varchar(32), psgtype varchar(32))");       
        try(Statement stm=con.createStatement()){
            stm.addBatch("insert into car values(null,'Blechfire Runabout','1952-03-13')");
            stm.addBatch("insert into car values(null,'Batmobil','1938-06-28')");
            stm.addBatch("insert into car values(null,'DeLorean','1982-09-03')");
            stm.executeBatch();
            stm.close();
        }
        catch(SQLException ex){
            System.out.println("Virhe luodessa class-taulua");
            ex.printStackTrace();
        }
        try(Statement stm=con.createStatement()){
            stm.addBatch("insert into passanger values(null,1,'Aku','ankka')");
            stm.addBatch("insert into passanger values(null,1,'Iines','ankkatar')");
            stm.addBatch("insert into passanger values(null,1,'Tupu','ankka')");
            stm.addBatch("insert into passanger values(null,1,'Hupu','ankka')");
            stm.addBatch("insert into passanger values(null,1,'Lupu','ankka')");
            stm.addBatch("insert into passanger values(null,2,'Batman','super')");
            stm.addBatch("insert into passanger values(null,2,'Robin','apuri')");
            stm.addBatch("insert into passanger values(null,null,'Roope','ankka')");
            stm.addBatch("insert into passanger values(null,null,'Hannu','hanhi')");
            stm.addBatch("insert into passanger values(null,3,'Marty','ihminen')");
            stm.addBatch("insert into passanger values(null,3,'Emmet','ihminen')");
            stm.executeBatch();
            stm.close();
        }
        catch(SQLException ex){
            System.out.println("Virhe luodessa class-taulua");
            ex.printStackTrace();
        }
    }
    
    
    
    public void init(){
        Connection con=getConnection();
        if (con==null){
            System.out.println("Ei saatu tietokantayhteyttä!!!!!!!!!!!!!");
            return;
        }
        createTables(con);
        try{
            con.close();
        }
        catch(SQLException ex){
            ex.printStackTrace();
        }
    }
    
    static private Populate inst;
    public Populate(){
        inst=this;
    }
    
}
