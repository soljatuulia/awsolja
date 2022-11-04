package net.tutorit.checkpoint3;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 *
 * @author jyrki
 */
@Component
public class Jdbc {
    // Populate-luokka on nyt Spring-bean, joka siis voidaan injektoida tässä
    // Huomaa, että getConnection ei ole enää staattinen metodi.
    // Jos siis haluat käyttää Populate-luokan getConnection:ia, nitn se tehdään vähän erilaisella tapaa
    // Mikäli populate-beanin käyttö tuntuu vaikealta, joudut toteuttamaan tähän luokkaan oman getConnection-apumetodin

    @Autowired
    Populate pop;

    private void extra(){
        // Jätä tämä aivan viimeiseksi....
        // Listaa autot ja tieto siitä, vieläkö siihen voidaan ottaa uusi matkustaja
        // Kaikien autojen maksimimatkustajamäärä on 5
        System.out.println("Lisätehtävä yritetty suorittaa");
        try{
            Connection con=pop.getConnection();
            String sql="SELECT c.make,COUNT(*) as pas FROM passanger p,car c WHERE p.car_id=c.id GROUP BY c.make ORDER BY pas DESC;"; 
            PreparedStatement stm=con.prepareStatement(sql);
            ResultSet rs=stm.executeQuery();
            while(rs.next()){
                System.out.print(rs.getString("make")+", ");
                System.out.print(rs.getString("pas")+" matkustajaa");
                if (rs.getString("pas").equals("0") || rs.getString("pas").equals("1")
                    || rs.getString("pas").equals("2") || rs.getString("pas").equals("3")
                        || rs.getString("pas").equals("4")){
                    System.out.println(", kyytiin mahtuu lisää matkustajia");
                } else {
                    System.out.println(", auto on täynnä");
                }
            }
            stm.close();
            con.close();
        }
        catch(SQLException ex){
            ex.printStackTrace();
        }        
    }
    
    private void listAllWithCars(){
        System.out.println("Kaikki matkustajat autoineen paitsi .....");
        // Tulosta kaikki Passangerit nimen ja tyypin mukaisessa järjestyksessä
        // mukana myös auton auton tietoja (merkki ja käyttöönottopäivä)
        // Rajaa haku kuitenkin koskemaan vain 1.1.1950 jälkeen käyttöönotettuja autoja
        // Jalankulkijoiden (autoa ei asetettu) pitää olla mukana listauksessa
        // Esim:
        // Hannu,hanhi,ei ajoneuvoa
        // Hupu,ankka,Blechfire Runabout,1952-03-13
        // jne
        try{
            Connection con=pop.getConnection();
            String sql="SELECT p.name,p.psgtype,c.make,c.deploymentdate FROM passanger p left join car c on(p.car_id=c.id) WHERE c.deploymentdate>'1950-01-01' OR c.deploymentdate is null ORDER BY p.name,p.psgtype"; // tietoa kahdesta taulukosta!
            PreparedStatement stm=con.prepareStatement(sql);
            ResultSet rs=stm.executeQuery();
            while(rs.next()){
                System.out.print(rs.getString("name")+", ");
                System.out.print(rs.getString("psgtype")+", ");
                System.out.print(rs.getString("make")+", ");
                System.out.println(rs.getDate("deploymentdate"));
            }
            stm.close();
            con.close();
        }
        catch(SQLException ex){
            ex.printStackTrace();
        }
    }
    
    private void listPedestrians(){
        System.out.println("Jalankulkijat");
        // Listaa jalankulkijoiden nimet (autoa ei ole asetettu) aakkosjärjestyksessä
        try{
            Connection con=pop.getConnection();
            String sql="SELECT p.name FROM passanger p WHERE car_id is null ORDER BY name";
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
    
    private void changeType(Passanger p, String newPassangerType){
        // Vaihda annetun matkustajan tyyppi
        // Talleta muutos tietokantaan
        try{
            String sql="SELECT * FROM passanger where id=?";
            Connection con=pop.getConnection();
            PreparedStatement stm=con.prepareStatement(sql,ResultSet.TYPE_FORWARD_ONLY,ResultSet.CONCUR_UPDATABLE);
            stm.setInt(1, p.getId());
            ResultSet rs=stm.executeQuery();
            Passanger passanger=null;
            if (rs.next()){
                rs.updateString("psgtype",newPassangerType);
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
    
    private Passanger getPassanger(int id){
        // Palauta id:tä vastaava Passanger-objekti
        Passanger p = null;
        try{
            String sql="SELECT * FROM passanger where id=?";
            Connection con=pop.getConnection();
            PreparedStatement stm=con.prepareStatement(sql);
            stm.setInt(1, id);
            ResultSet rs=stm.executeQuery();
            if (rs.next()){
                p = new Passanger(rs.getString("name"),rs.getInt("car_id"),rs.getString("psgtype")); // konstruktoria myötäillen 
                p.setId(rs.getInt("id"));
            }
            rs.close();
            stm.close();
            con.close();
            return p;
        }
        catch(SQLException ex){
            ex.printStackTrace();
        }        
        return null;
    }
    
    public void jdbcMain(){
        System.out.println("Jdbc-luokan testaus alkaa");
        Passanger p=getPassanger(6);
        System.out.println("Haettiin 6: "+p);
        changeType(p,"ihminen");
        if (p!=null) System.out.println(p.getName()+" tyyppi vaihtui: "+getPassanger(6));
        listPedestrians();
        listAllWithCars();
        extra();
        System.out.println("Jdbc-luokan testaus loppuu");
    }
}
