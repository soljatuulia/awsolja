/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package net.virkkunen.springweb.repositories;

import java.util.List;
import net.virkkunen.springweb.entities.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.web.bind.annotation.GetMapping;

/**
 *
 * @author Solja
 */
public interface AuthorsRepository extends JpaRepository<Author,Integer> {
    
    //JPQL (voisi käyttää myös SQL-kieltä, jos lopussa native = true)
    @Query("SELECT a FROM Author a")
    List<Author> findFiltered(String filt);
            
}
