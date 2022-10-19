
package net.virkkunen.bookapp;

import java.time.YearMonth;

/**
 *
 * @author Solja
 */
public class Book {
    
    private String title = "No title";
    private String author = "No author";
    private double price = 0;
    private int numCopies = 0;
    private YearMonth published;
    
    public Book() {
        
    }
    
    public void setTitle(String title) {
        if (title == null) {
            return;
        }
        
        if (title.isBlank()) {
            return;
        }
        
        this.title = title;
    }
    
}
