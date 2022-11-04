/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package net.virkkunen.booksspring;

import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author Solja
 */
public interface BookRepository extends CrudRepository<Book,Integer> {
    
    @Query("SELECT a.* FROM author a, book b WHERE a.id=b.author_id AND b.id=:bookId;")
    Author findAuthor(Integer bookId);
            
    // toimii ilmankin, koska kysely kohdistuu yhteen merkkijonoon @Query("SELECT * FROM book WHERE title like '%:titleContains%'")
    Book findByTitle(String titleContains);
    
}
