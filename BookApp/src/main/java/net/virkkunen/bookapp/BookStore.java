
package net.virkkunen.bookapp;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.ListIterator;
import java.util.stream.Collectors;

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
    
    public void showList() {
        // Prints all books
        ListIterator litr = null;
        litr = books.listIterator();

	while(litr.hasNext()){
	System.out.println(litr.next());
	      }
    }
    
    List<Book> showList(String author) {
        List<Book> ret = books.stream()
                .filter (t -> (t.getAuthor().equals(author)))
                .collect(Collectors.toList());
        return ret;
    }
    
    public void sortByTitle() {
        System.out.println("Sorted by title:");
        books.sort((a,b) -> a.getTitle().compareTo(b.getTitle()));
        for(Book b:books){
            System.out.println(b);
        }
    }
    
    public void sortByAuthor() {
        System.out.println("Sorted by author:");
        books.sort((a,b) -> a.getAuthor().compareTo(b.getAuthor()));
        for(Book b:books){
            System.out.println(b);
        }
    }
    
    public void sort(Comparator comp) {
        Collections.sort(books, Book.getCompByName());
    }
    
    public void print(double minPrice) {
        /*
        Only print books more expensive that minPrice , but they should be
        printed in of their title 
        */
    }
}
}