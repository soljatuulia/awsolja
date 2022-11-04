/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package net.virkkunen.booksspring;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 *
 * @author Solja
 */
@Component
public class BooksAndAuthors {

    @Autowired
    BookRepository bookRepo;
    @Autowired
    AuthorRepository authorRepo;
    public static BooksAndAuthors theInstance;
    
    public BooksAndAuthors() {
        
    }
    
}
