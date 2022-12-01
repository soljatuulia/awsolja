/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package net.tutorit.checkpoint6.reporting;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 *
 * @author Solja
 */
@RestController
@RequestMapping("reporter")
public class ReporterController {
    
    @Autowired
    ReporterRepository repo;    
    // tänne EntityManager em; --> tutki! Jotta saadaan näppärästi kuvattua luokat. Tällöin ei tarvitse liittyä tiettyyn tauluun.
    
    @GetMapping("/authors")
    public Author[] getAuthors(RestTemplate rt) {
        Author[] al = rt.getForObject("http://localhost:8081/authors", Author[].class);
        return al;
    }  
    
    //@RequestMapping(value, produces,method)
}
