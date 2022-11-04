/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package net.tutorit.cpharjoitus3;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import static net.tutorit.cpharjoitus3.Populate.getConnection;
import org.springframework.stereotype.Component;

/**
 *
 * @author jyrki
 */
@Component
public class Jdbc {

    private void report2(int teacherId){
        // Tulosta kaikki annetun opettajan oppilaat eval-daten mukaisessa järjestyksessä
        // Anssi,Taina,2022-10-26
        try{
            Connection con=Populate.getConnection();
            String sql="SELECT c.teacher,s.name,s.evaldate FROM student s,class c WHERE c.id=s.class_id AND c.id=? ORDER BY evaldate"; // tietoa kahdesta taulukosta!
            PreparedStatement stm=con.prepareStatement(sql);
            stm.setInt(1, teacherId);
            ResultSet rs=stm.executeQuery();
            while(rs.next()){
                System.out.print(rs.getString("teacher")+", ");
                System.out.print(rs.getString("name")+", ");
                System.out.println(rs.getDate("evaldate"));
            }
            stm.close();
            con.close();
        }
        catch(SQLException ex){
            ex.printStackTrace();
        }        
    }    
    
    private void report(){
        // Katso ohje tämän tiedoston lopusta
        System.out.println("Tulosta raportti tämän tiedoston lopussa olevan ohjeen mukaan");
        // kopioi evalAfterOct15 pohjaksi
        try{
            Connection con=Populate.getConnection();
            String sql="SELECT s.name,s.evaldate,c.classname,c.teacher FROM student s, class c WHERE c.id=s.class_id ORDER BY c.teacher,s.name"; // tietoa kahdesta taulukosta!
            PreparedStatement stm=con.prepareStatement(sql);
            ResultSet rs=stm.executeQuery();
            while(rs.next()){
                System.out.print(rs.getString("name")+", ");
                System.out.print(rs.getDate("evaldate")+", ");
                System.out.print(rs.getString("classname")+", ");
                System.out.println(rs.getString("teacher"));
            }
            stm.close();
            con.close();
        }
        catch(SQLException ex){
            ex.printStackTrace();
        }
        
    }
    
    private void listStudentsOfTeacher(int teacherId){
        // SELECT s.name FROM student s, class c WHERE c.id=s.class_id AND s.class_id=1;
        try{
            Connection con=Populate.getConnection();
            String sql="SELECT s.name FROM student s, class c WHERE c.id=s.class_id AND s.class_id=?";
            PreparedStatement stm=con.prepareStatement(sql);
            stm.setInt(1, teacherId);
            ResultSet rs=stm.executeQuery();
            while(rs.next()){
                System.out.println(rs.getString("name"));
            }
            stm.close();
            con.close();
        }
        catch(SQLException ex){
            ex.printStackTrace();
        }
    }
    
    private void evalAfterOct15(){
        // Tulosta niiden oppilaiden nimi, joiden arviointiäivä on 15.10 jälkeen
        // select * from student where evaldate > '2022-10-15';

        System.out.println("Tulosta näytölle ne oppilaat, joiden evaldate on 15.10 jälkeen");
        try{
            Connection con=Populate.getConnection();
            String sql="SELECT * FROM student where evaldate > '2022-10-15'";
            PreparedStatement stm=con.prepareStatement(sql);
            ResultSet rs=stm.executeQuery();
            while(rs.next()){
                System.out.println(rs.getString("name"));
            }
            stm.close();
            con.close();
        }
        catch(SQLException ex){
            ex.printStackTrace();
        }
    }
    
    
    private Student getStudent(int id){
        Student s=null;
        // Hae ja palauta id:tä vastaava oppilas
        try{
            String sql="SELECT * FROM student where id=?";
            Connection con=Populate.getConnection();
            PreparedStatement stm=con.prepareStatement(sql);
            stm.setInt(1, id);
            ResultSet rs=stm.executeQuery();
            if (rs.next()){
                s = new Student(rs.getString("name"),rs.getInt("class_id"),rs.getDate("evaldate")); // konstruktoria myötäillen 
                s.setId(rs.getInt("id"));
            }
            rs.close();
            stm.close();
            con.close();
            return s;
        }
        catch(SQLException ex){
            ex.printStackTrace();
        }
        return null;
    }

    private void updateStudent(Student s){
        // Päivitä muutokset tietokantaan
        try{
            String sql="SELECT * FROM student where id=?";
            Connection con=Populate.getConnection();
            PreparedStatement stm=con.prepareStatement(sql,ResultSet.TYPE_FORWARD_ONLY,ResultSet.CONCUR_UPDATABLE);
            stm.setInt(1, s.getId());
            ResultSet rs=stm.executeQuery();
            Student student=null;
            if (rs.next()){
                rs.updateInt("class_id",s.getClassId());
                rs.updateString("name",s.getName());
                rs.updateDate("evaldate", s.getEvalDate());
                rs.updateRow();
            }
            rs.close();
            stm.close();
            con.close();
            
        }
        catch(SQLException ex){
            ex.printStackTrace();
        }
    }
    
    private int addStudent(Student s){
        // Lisää parametrinä tullut oppilas tietokantaan
        // Palauta sen primary key
        try{
            Connection con=Populate.getConnection(); // HUOM!!
            if (con==null) return 0;
            String sql="INSERT INTO student(name,class_id,evaldate) values(?,?,?)";
            PreparedStatement stm=con.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
            stm.setString(1, s.getName());
            stm.setInt(2, s.getClassId());
            stm.setDate(3, s.getEvalDate());
            int rowsAffected=stm.executeUpdate(); 
            ResultSet keys=stm.getGeneratedKeys(); // kysytään ResultSetiltä, mitä primary keyta sinne menikään
            if (keys.next()) {
                int id=keys.getInt(1);
                stm.close();
                keys.close();
                con.close();
                return id; // jos pitää palauttaa objekti --> tähän s
            }
            
            stm.close();
            con.close();
        }
        catch(SQLException ex){
            ex.printStackTrace();
        }
        return 0;
    }
    
    public void jdbcMain(){
        System.out.println("Jdbc-luokan testaus alkaa");
        Student s1=new Student("Untamo",1,Date.valueOf("2022-10-21"));
        Student s2=new Student("Alarik",2,Date.valueOf("2022-10-13"));
        int p1=addStudent(s1);
        int p2=addStudent(s2);
        System.out.println("Haettiin oppilas 10: "+getStudent(10));
        System.out.println("Haettiin oppilas "+p1+": "+getStudent(p1));
        System.out.println("Haettiin oppilas "+p2+": "+getStudent(p2));
        Student sm=getStudent(8);
        sm.setName("Muutettu");
        updateStudent(sm);
        listStudentsOfTeacher(1);
        evalAfterOct15();
        report();
        System.out.println("Report2:");
        report2(1);
        System.out.println("Jdbc-luokan testaus loppuu");
    }
}

/*
Tulostettava näytölle alla kuvatun kaltainen raportti
Raportissa rivien muotoilu ei ole tärkeä. 
Kelpaa vaikka ihan pilkulla erotellut arvot.
Päivämäärän muotoilu ei myöskään ole oleellinen seikka
Rivi voidaan siis esittää vaikka muodossa:
Kristian,6.10.2022,1B,Anssi

- Sarakkeina oppilaan nimi, arviointipäivä, luokannimi ja opettajan nimi
- Järjestys ensisijaisesti opettajan nimen mukaan, sitten oppilaan nimen mukaan


+----------+------------+-----------+---------+
| name     | evaldate   | classname | teacher |
+----------+------------+-----------+---------+
| Kristian | 2022-10-06 | 1B        | Anssi   |
| Mikko    | 2022-10-18 | 1B        | Anssi   |
| Reijo    | 2022-10-04 | 1B        | Anssi   |
| Sakari   | 2022-10-20 | 1B        | Anssi   |
| Solja    | 2022-10-22 | 1B        | Anssi   |
| Susanna  | 2022-10-24 | 1B        | Anssi   |
| Taina    | 2022-10-26 | 1B        | Anssi   |
| Taito    | 2022-10-28 | 1B        | Anssi   |
| Aapo     | 2022-10-12 | 1A        | Jyrki   |
| Henri    | 2022-10-10 | 1A        | Jyrki   |
| Joel     | 2022-10-08 | 1A        | Jyrki   |
| Kasperi  | 2022-10-14 | 1A        | Jyrki   |
| Kia      | 2022-10-16 | 1A        | Jyrki   |
| Monica   | 2022-10-02 | 1A        | Jyrki   |

*/