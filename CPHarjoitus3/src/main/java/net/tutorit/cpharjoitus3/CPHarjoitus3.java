/*
    Tee ensimmäiseksi yksi buildi, jotta riippuvuudet latautuvat
    - Oikeanpuoleinen klikki projektin nimen päällä + Build
    - Suorita sovellus. Saatat joutua asettamaan main-luokan:
        - oikeanpuolenen klikki projektin päällä + Properties + Run, Main class

    Seuraavaksi joudut selvittelemään miksi sovellus ei toimi (tietokantayhteyden konfiguraatio).
    Muista, että sovellusta käytetään kahdella tekniikalla, molemmilla on oma konfiguraationsa.

    Jdbc.java -tiedoston tehtävät on suoritettava käyttäen JDBC-tekniikkaa
    Spring.java -tiedoston tehtävät on suoritettava käyttäen Spring Data JDBC-tekniikkaa

    Huomioi, että tehtävissä käytettävät taulut rakennetaan uudelleen jokaisella
    suorituskerralla.
*/

package net.tutorit.cpharjoitus3;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

/**
 *
 * @author jyrki
 */
@SpringBootApplication
public class CPHarjoitus3 {

    @Bean
    public CommandLineRunner springStart(Jdbc jdbc,Spring spring){
        return args -> {
            System.out.println("Sovellus on käynnistynyt");
            Populate.init();
            //jdbc.jdbcMain();
            spring.springMain();
        };
    }
    
    public static void main(String[] args) {
        SpringApplication.run(CPHarjoitus3.class, args);
    }
}
