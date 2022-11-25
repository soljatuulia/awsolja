/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package net.tutorit.checkpoint6.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import javax.annotation.PostConstruct;
import net.tutorit.checkpoint6.employees.Employee;
import net.tutorit.checkpoint6.employees.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

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
        dropCreate(con,"employee","(id int primary key not null auto_increment,name varchar(32), employee_id varchar(32), superior_id varchar(32))");
        try(Statement stm=con.createStatement()){
            stm.addBatch("insert into employee values(null,'Tuomas','tuomas',null)");
            stm.addBatch("insert into employee values(null,'Simeoni','simo','tuomas')");
            stm.addBatch("insert into employee values(null,'Lauri','late','tuomas')");
            stm.addBatch("insert into employee values(null,'Eero','eero',null)");
            stm.addBatch("insert into employee values(null,'Juhani','jussi','eero')");
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
        readExternal();
    }
    
    private void readExternal(){
        System.out.println("Tänne olisi hyvä toteuttaa se JSON-tiedoston lukeminen");
    }
    
}
