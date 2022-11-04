/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package net.tutorit.checkpoint3;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 *
 * @author jyrki
 */
@Component
public class Spring {
    
    @Autowired
    PassangerRepository prep;
    
    public void listEverything(){
        System.out.println("Listataan kaikki");
        // Esimerkki tiedoston lopussa
        List<PassangersAndCars> pclist=prep.listAll();
                for(PassangersAndCars pc: pclist){
                    System.out.println(pc);
                }         
    }
    
    public Car getCarOf(int passangerId){
        // Palauta kyseisen matkustajan auto
        return prep.findCar(passangerId);
             //return new Car();
    }
    
    public void listAllPeople(){
        System.out.println("Kaikki ihmiset");
        // Listaa kaikki ihmiset (psgtype) nimenmukaisessa järjestyksessä
        List<Passanger> plist=prep.listByType();
                for(Passanger p: plist){
                    System.out.println(p.getName());
                }                
    }
    
    public void addPassanger(Passanger p){
        // Lisää matkustaja tietokantaan
        prep.save(p);              
    }
    
    public void springMain(){
        System.out.println("Spring-luokan testaus alkaa");
        Passanger p=new Passanger("Alfred",null,"ihminen");
        addPassanger(p);
        System.out.println("Lisättiin: "+p);
        listAllPeople();
        Car c=getCarOf(10);
        System.out.println("Matkustajan 10 auto on "+c.getMake());
        listEverything();
    }
}
/*
listEverything esimerkki (Jalankulkijoita ei siis tarvitse olla mukana):
Blechfire Runabout
    Aku,ankka
    Hupu,ankka
    Iines,ankkatar
    Lupu,ankka
    Tupu,ankka    
Batmobil  
    Batman,super
    Robin,apuri
DeLorean          
    Emmet,ihminen
    Marty,ihminen
*/