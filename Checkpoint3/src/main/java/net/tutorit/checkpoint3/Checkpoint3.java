/*

    Tee ensimmäiseksi yksi buildi, jotta riippuvuudet latautuvat
    - Oikeanpuoleinen klikki projektin nimen päällä + Build
    - Suorita sovellus. Saatat joutua asettamaan main-luokan:
        - oikeanpuolenen klikki projektin päällä + Properties + Run, Main class

    Seuraavaksi joudut selvittelemään miksi sovellus ei toimi (tietokantayhteyden konfiguraatio).
    Älä hämmenny vaan etsi oikea kohde.

    Jdbc.java -tiedoston tehtävät on suoritettava käyttäen JDBC-tekniikkaa
    Spring.java -tiedoston tehtävät on suoritettava käyttäen Spring Data JDBC-tekniikkaa

    Huomioi, että tehtävissä käytettävät taulut rakennetaan uudelleen jokaisella
    suorituskerralla.

    Suorituksen päätteeksi kopioi sovelluksen tulosteet vastaukseksi Canvakseen
    Muista myös ladata sovellus omaan GitHub-repositoryysi (git add, git commit, git push)
    **************************************************************************************
*/

package net.tutorit.checkpoint3;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

/**
 *
 * @author solja
 */
@SpringBootApplication
public class Checkpoint3 {

    @Bean
    public CommandLineRunner springStart(Jdbc jdbc,Spring spring,Populate populate){
        return args -> {
            System.out.println("Sovellus on käynnistynyt");
            populate.init();
            jdbc.jdbcMain();
            spring.springMain();
            System.out.println("Kopioi sovelluksen tulosteet vastaukseksi Canvakseen sekä vie projekti omaan GitHub-repositoryysi");
        };
    }
    
    public static void main(String[] args) {
        SpringApplication.run(Checkpoint3.class, args);
    }
}
