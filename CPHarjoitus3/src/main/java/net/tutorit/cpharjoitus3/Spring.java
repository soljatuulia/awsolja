/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package net.tutorit.cpharjoitus3;

import java.sql.Date;
import java.time.LocalDate;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 *
 * @author jyrki
 */

 /*
  Joudut siis toteuttamaan repositoryn ja käyttämään dependency-injectionia,
  jotta repository tulee tänne saataville.
  */
@Component
public class Spring {
    
    @Autowired
    StudentRepository studentRepo;
    public static Spring theInstance;
    
    public Spring(){
        theInstance=this;
    }    

    private void report2(){
        // Sama kuin alla, mutta sorttaa ja filtteröi vastausjoukko tässä
        // Käytä kokoelman streamejä....
        // Listaa ensin vain Anssin-oppilaat evaldate-järjestyksessä
        //  tai kaikki joiden evaldate<15.10 luokka järjestyksessä....
        List<StudentReport> srlist2=studentRepo.listAll2();
        srlist2.stream()
                .filter(a -> a.getTeacher().equals("Anssi"))
                .sorted(Comparator.comparing(StudentReport::getEvaldate))
                .forEach(System.out::println);        
        srlist2.stream()
                .filter(a -> a.getEvaldate()<"2022-10-15")
    }    
    
    private void report(){
        // Katso ohje tämän tiedoston lopusta
        // Vaatii StudentReport-luokan avuksi
        System.out.println("Tulosta raportti tämän tiedoston lopussa olevan ohjeen mukaan");
        List<StudentReport> srlist=studentRepo.listAll();
                for(StudentReport sr: srlist){
                    System.out.println(sr);
                }            
    }
    
    private void evalAfterOct15(){
        // Tulosta niiden oppilaiden nimi, joiden arviointiäivä on 15.10 jälkeen
        System.out.println("Tulosta näytölle ne oppilaat, joiden evaldate on 15.10 jälkeen");
        List<Student> slist=studentRepo.evalAfter();
                for(Student s: slist){
                    System.out.println(s.getName());
                }        
    }
    
    private Student getStudent(int id){
        Student s=null; // voi poistaa
        // Hae ja palauta id:tä vastaava oppilas
        s=studentRepo.findById(id).get();
        return s;
    }

    private void changeName(int id,String name){
        // Vaihda kyseisen oppilaan nimi
        Optional<Student> sSolja=studentRepo.findById(id);
        if (sSolja.isPresent()){
            System.out.println("Student: "+sSolja.get());
            Student s=sSolja.get();
            s.setName(name);
            studentRepo.save(s);
        }        
    }
    
    private int addStudent(Student s){
        // Lisää parametrinä tullut oppilas tietokantaan
        // Palauta sen primary key
        studentRepo.save(s);         
        return s.getId(); // jos pitää palauttaa objekti --> tähän s
    }
    
    public void springMain(){
        System.out.println("Spring-luokan testaus alkaa");
        Student s1=new Student("Venla",1,Date.valueOf("2022-10-21"));
        Student s2=new Student("Aino",2,Date.valueOf("2022-10-13"));
        int p1=addStudent(s1);
        int p2=addStudent(s2);
        System.out.println("Haettiin oppilas 10: "+getStudent(10));
        System.out.println("Haettiin oppilas "+p1+": "+getStudent(p1));
        System.out.println("Haettiin oppilas "+p2+": "+getStudent(p2));
        evalAfterOct15();
        report();
        System.out.println("Report2:");
        report2();
        changeName(1,"Pekka");
        System.out.println("Spring-luokan testaus loppuu");
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