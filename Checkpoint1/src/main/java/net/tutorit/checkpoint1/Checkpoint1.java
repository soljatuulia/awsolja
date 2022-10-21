/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package net.tutorit.checkpoint1;

import java.time.LocalDate;
import java.time.LocalDateTime;

/* ARVIOINTIPERUSTEET
Läpipääsyyn: (=1pt)
    - vähintään yksi päivämäärätehtävistä toteutettu oikein
    - rajapintatehtävä on toteutettu oikein
    - pankkitehtävä vähintäänkin listaa kaikki tapahtumat

Tavoitetaso (=2pt)
    - Kaikki tehtävät suoritettu, mutta voi olla vielä pikkuisen viilattavaa ja paranneltavaa

Täydellinen suoritus (=3pt)
    - Kaikki tehtävät on suoritettu käyttäen erinomaisia ratkaisuja
    - Ratkaisuissa mukana piirteitä, joita ei (ainakaan syvällisesti) viikon aikana keritty läpi käydä
*/


/**
 *
 * @author jyrki
 */
public class Checkpoint1 {
    /*
    Koodia kannattaa lukea alhaalta ylöspäin
    */
    
    /*
        Seuraava funktio pitäisi saada toimimaan.
        Joudut siis tekemään vielä pari luokkaa
    */
    static void bankingTester(){
    /*    
        // Pankkitili: Tilinomistaja ja alkusaldo
        Account acc=new Account("Tiina Tilinolmistaja",5250);
        // Tehdään uusia tapahtumia tilille
        acc.transaction(-214.23,LocalDate.of(2022, 2, 18));
        acc.transaction(-14.11,LocalDate.of(2022, 2, 20));
        acc.transaction(-11.20,LocalDate.of(2022, 2, 25));
        acc.transaction(3212.98,LocalDate.of(2022, 2, 27));
        acc.transaction(-15.90,LocalDate.of(2022, 3, 1));
        acc.transaction(-232.21,LocalDate.of(2022, 3, 7));
        // Haetaan helmikuun tapahtumat
        List<Transaction> transactions=acc.getTransactionsOf(2022,2);
        // Jos ylläoleva tuntuu mahdottomalta, niin tyydyttävästi kelpaa myös
        // List<Transaction> transactions=acc.getAll();
        System.out.println("Helmikuun 2022 tapahtumat");
        for(Transaction t:transactions){
           System.out.println(t.getDate().toString()+", "+t.getAmount());
           // Yllä oleva riittää. Lisäpistemahdollisuus jos tuloste tulee fiksusti toteutettuna
           // Muodossa "Otto 20.2.2022, -14.11"
           // Kutsumalla System.out.println(t.getDescription());
        }
        // Viedään tilitapahtumat tiedostoon
        // Tiedoston alkuun tilinomistaja sekä alkusaldo
        // Lisäpisteitä loppusaldon esittämisestä
        // Tilitapahtumat omille riveilleen halutulla tapaa muotoiltuna
        acc.export("tapahtumat.txt");
    */
    }
    
    /*
    Laajenna koodia siten, että saat alla olevat kaksi metodia toimimaan
    */
    /*
    static void weSellStuff(Merchandise merch){
        System.out.println("Nyt myydään "+merch.getName()+" hintaan "+merch.getPrice());
    }
    */
    static void shopTester(){
        /*
        Television tv=new Television("LG televisio",2000);
        Microwave mw=new Microwave("Philips mikroaaltouuni",400);
        weSellStuff(tv);
        weSellStuff(mw);
        */
    }
    static boolean isWorkingHours(LocalDateTime dt){
        // Palauta onko annettu päiväys työaikaa (Ma-Pe, 9:00-17:00)
        return false;
    }
    
    static LocalDate firstMondayOfNextMonth(){
        // Palauta seuraavan kuukauden ensimmäisen maanantain päivämäärä.
        return null;
    }
    
    static LocalDate greetingsFromNY(){
        String dateString="5/6/23";
        /* 
            Amerikkalainen tietojärjestelmä antaa sinulle päivämäärän ylläkuvattuna merkkijonona.
            Palauta LocalDate-objekti, joka kuvaa samaa päivämäärää.
            Aikavyöhykkeitä ei tarvitse miettiä.
        */
        return null;        
    }
    
    public static void main(String[] args) {
        System.out.println("Tervetuloa testaamaan osaamistasi!");
        System.out.println("Kopioi lopuksi tulosteet tästä eteenpäin canvakseen vastaukseksi_________");
        System.out.println("New Yorkin päivä: "+greetingsFromNY());
        System.out.println("Seuraavan kuukauden ensimmäinen maanantai: "+firstMondayOfNextMonth());
        System.out.println("Onko työaikaa 1: "+isWorkingHours(LocalDateTime.of(2022,11,12,9,20)));
        System.out.println("Onko työaikaa 2: "+isWorkingHours(LocalDateTime.of(2022,11,10,8,20)));
        shopTester();
        bankingTester();
        System.out.println("Tätä ei enää tarvitse kopioida_________");
        System.out.println("Mutta kopioi toiseen canvaksen vastauskenttään tuottamasi tapahtumat.txt:n sisältö");
    }
}
