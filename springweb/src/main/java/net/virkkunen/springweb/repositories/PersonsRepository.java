/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package net.virkkunen.springweb.repositories;

import java.util.List;
import net.virkkunen.springweb.entities.Author;
import net.virkkunen.springweb.entities.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

/**
 *
 * @author Solja
 */
public interface PersonsRepository extends JpaRepository<Person,Integer> {

    @Query("SELECT p FROM Person p")
    List<Person> findFiltered(String filt);
    
}
