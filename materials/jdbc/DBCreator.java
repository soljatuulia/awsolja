package jdbc;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

public class DBCreator {
    //public static String driver="org.apache.derby.jdbc.ClientDriver"; 
    public static String driver="com.mysql.cj.jdbc.Driver";
    public static String connectionString="jdbc:mysql://localhost:3306/";
    public static String dbName="crm";
    public static String userName="root";
    public static String password="kurssi";

    static public void main(String[] args){
        createDatabase();
        System.out.println("Database created, runnng some tests:");
        simpleQuery();
    }
    
    static public Connection getConnection()
    {
        try{
            Class.forName(driver);
            return DriverManager.getConnection(connectionString+dbName,userName,password);
        }
        catch(ClassNotFoundException cnfe){
            System.out.println("Driver "+driver+" not found!");
        }
        catch(SQLException se){
            System.out.println("Connection failed!");
            System.out.println(se.getMessage());
            se.printStackTrace();
        }
        return null;
    }
    
    private static void simpleQuery()
    {
        try{
            Class.forName(driver);
            Connection con=DriverManager.getConnection(connectionString+dbName, userName,password);
            
            DatabaseMetaData md=con.getMetaData();
            System.out.println("Using driver :"+md.getDriverName()+" version:"+md.getDriverVersion());
            System.out.println("JDBC-Version: "+md.getJDBCMajorVersion()+"."+md.getJDBCMinorVersion());

            Statement stm=con.createStatement();
            ResultSet rs=stm.executeQuery("SELECT * FROM CompanyPersons");
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
            rs.close();
            stm.close();
            
            con.close();
        }
        catch(ClassNotFoundException cnfe){
            cnfe.printStackTrace();
        }
        catch(SQLException sex){
            sex.printStackTrace();
        }
    }
   
    
    static public void createDatabase()
    {
        Connection con=getRootConnection();
        if (con==null) return;
        try (Statement stm=con.createStatement()){
            stm.execute("CREATE DATABASE "+dbName);
        }
        catch(SQLException ex){
            System.out.println("Cannot create database "+dbName);
            System.out.println(ex.getMessage());
        }
        try{
            con.close();
            con=getConnection();
        }
        catch(SQLException sex){
            sex.printStackTrace();
        }
        if (con==null){
            System.out.println("Connection to the database "+dbName+" failed");
            return;
        }
        try(Statement stm=con.createStatement()){
            stm.execute("DROP VIEW CompanyPersons");
        }
        catch(SQLException sex){
            System.out.println("Cannot drop view CompanyPersons");
        }
        try(Statement stm=con.createStatement()){
            stm.execute("DROP TABLE Person");
        }
        catch(SQLException sex){
            System.out.println("Cannot drop table Person");
        }
        try(Statement stm=con.createStatement()){
            stm.execute("DROP TABLE Company");
        }
        catch(SQLException sex){
            System.out.println("Cannot drop table Company");
        }
        String derbyPrimaryKeyDef="id INTEGER NOT NULL PRIMARY KEY GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1)";
        String mysqlPrimaryKeyDef="id int not null primary key auto_increment";
        String primaryKeyDef=driver.equals("com.mysql.cj.jdbc.Driver") ? mysqlPrimaryKeyDef : derbyPrimaryKeyDef;
        try (Statement stm=con.createStatement()) {
            stm.execute("CREATE TABLE Company("+primaryKeyDef+",name varchar(64),address varchar(64))");
        }
        catch(SQLException sex){
            System.out.println("Cannot create table Company");
        }
        try (Statement stm=con.createStatement()) {
            stm.execute("CREATE TABLE Person("+primaryKeyDef+",company_id int, name varchar(64),email varchar(64), contact_date date,FOREIGN KEY(company_id) REFERENCES Company(id))");
        }
        catch(SQLException sex){
            System.out.println("Cannot create table Person");
        }
        try (Statement stm=con.createStatement()) {
            stm.execute("create view CompanyPersons as SELECT c.*,p.id as person_id, p.name as person_name, p.email, p.contact_date FROM Company c left join Person p on (p.company_id=c.id)");
        }
        catch(SQLException sex){
            System.out.println("Cannot create view CompanyPersons");
        }
        try(Statement stm=con.createStatement()){
            stm.addBatch("INSERT INTO Company(name,address) values('Coders Unlimited Ltd','Code alley 6')");
            stm.addBatch("INSERT INTO Company(name,address) values('Testing Dudes','Bugstreet 4')");
            stm.addBatch("INSERT INTO Person(company_id,name,email,contact_date) values(1,'John Wayne','john@coders.com','2018-04-11')");
            stm.addBatch("INSERT INTO Person(company_id,name,email,contact_date) values(1,'Mike Monroe','mike@coders.com','2017-05-06')");
            stm.addBatch("INSERT INTO Person(company_id,name,email,contact_date) values(2,'Tim Dalton','tim@testers.net','2019-04-11')");
            stm.addBatch("INSERT INTO Person(company_id,name,email,contact_date) values(2,'Roger Moore','roger@testers.net','2020-09-21')");
            stm.executeBatch();
            stm.close();
            con.close();
        }
        catch(SQLException ex){
            ex.printStackTrace();
            return;
        }
    }

    static private Connection getRootConnection()
    {
        try{
            Class.forName(driver);
            String cs=connectionString;
            if (driver.equals("org.apache.derby.jdbc.ClientDriver")){
                cs+=dbName+";create=true";
            }
            return DriverManager.getConnection(cs,userName,password);
        }
        catch(ClassNotFoundException cnfe){
            System.out.println("Driver "+driver+" not found!");
        }
        catch(SQLException se){
            System.out.println("Connection failed!");
            System.out.println(se.getMessage());
        }
        return null;
    }
    
    
}
