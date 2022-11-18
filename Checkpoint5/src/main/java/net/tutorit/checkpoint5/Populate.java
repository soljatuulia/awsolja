/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package net.tutorit.checkpoint5;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import javax.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 *
 * @author jyrki
 */
@Component
public class Populate {
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
        dropCreate(con,"painting","(id int primary key not null auto_increment,name varchar(32), artist varchar(32))");
        try(Statement stm=con.createStatement()){
            stm.addBatch("insert into painting values(null,'Mona Lisa','Leonardo Da Vinci')");
            stm.addBatch("insert into painting values(null,'Tähtikirkas yö','Vincent Van Gogh')");
            stm.addBatch("insert into painting values(null,'Muiston pysyvyys','Salvador Dali')");
            stm.addBatch("insert into painting values(null,'Impressio auringonnoususta','Claude Monet')");
            stm.addBatch("insert into painting values(null,'Vanha kitaristi','Pablo Picasso')");
            stm.executeBatch();
            stm.close();
        }
        catch(SQLException ex){
            System.out.println("Virhe luodessa class-taulua");
            ex.printStackTrace();
        }
    }
    
    
    @PostConstruct
    public void init(){
        System.out.println("Luodaan taulu");
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
    
}
