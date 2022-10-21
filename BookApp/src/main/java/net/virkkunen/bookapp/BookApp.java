
package net.virkkunen.bookapp;

import java.time.Month;
import java.time.YearMonth;

/**
 *
 * @author Solja
 */
public class BookApp {

    public static void main(String[] args) {
        
        BookStore bookstore = new BookStore();
        Book book1 = new Book("Hobbit", "Tolkien", 12.40, 6, YearMonth.of(2000, 12));
        Book book2 = new Book("Kirja", "Kirjailija Kirjanen", 32.99, 2, YearMonth.of(2022, 9));
        
        bookstore.add(book1);
        bookstore.add(book2);
        
        System.out.println(bookstore.showList());
    }
}
