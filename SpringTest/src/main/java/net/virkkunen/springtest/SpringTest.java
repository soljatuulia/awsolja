/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package net.virkkunen.springtest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 *
 * @author Solja
 */
@SpringBootApplication
public class SpringTest {

    @Bean
    public CommandLineRunner executedWhenLoaded(Util u, UsingUtil uu) {
        return args -> {
            System.out.println("Now we are running");
            u.sayHello();
            System.out.println("Now we're using util");
            uu.doWork();
        };
    }
    
    public static void main(String[] args) {
        System.out.println("Hello Spring Boot!");
        SpringApplication.run(SpringTest.class, args);
        
    }
}
