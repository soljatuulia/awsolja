/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package net.virkkunen.booksspring;

import java.util.List;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author Solja
 */
public interface AuthorRepository extends CrudRepository<Author,Integer> {
    
    @Query("SELECT * from author WHERE concat(lastname,' ',firstname) like concat('%', concat(:namePart, '%'))")
    List<Author> findNameContains(String namePart);
            
    @Query("SELECT * FROM book WHERE author_id=:authorId")
    List<Book> findBooks(Integer authorId);
    
}
