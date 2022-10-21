
package net.virkkunen.bookapp;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Solja
 */
public class BookStore {
    
    private ArrayList<Book> books = new ArrayList<>();
    
    public BookStore() {
        
    }
    
    public void add(Book book){
        // If already has the same book should just increase the number of copies
        if(books.contains(book)) {
            book.setCopies(book.getCopies()+1);
        } else {
            books.add(book);
        }           
    }
    
    List<Book> showList() {
        // Prints all books
        return books;
    }
    
    public int listSize() {
        return books.size();
    }
    
}
