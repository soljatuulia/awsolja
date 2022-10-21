
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
    private int copies = 0;
    private YearMonth published;
    
    public Book() {
        
    }
    
    public Book(String title, String author, double price, int copies, YearMonth published) {
        if (title!=null && !title.isEmpty()) this.title=title;
        if (author!=null && !author.isEmpty()) this.author=author;
        if (price >= 0) this.price = price;
        if (copies > 0) this.copies = copies;
        try {
            if (published.isBefore(YearMonth.now())) {
                this.published = published;
            }
        } catch (Exception e) {
            System.out.println("Publishing date is not in the past.");
        }
    }
    
    
    
    public String toString() {
        return this.title + " by " + this.author + " (" + this.price + " €) " + this.getCopies() + " copies, published " + this.getPublished();
    }

    public YearMonth getPublished() {
        return published;
    }

    public void setPublished(YearMonth published) {
        try {
            if (published.isBefore(YearMonth.now())) {
                this.published = published;
            }
        } catch (Exception e) {
            System.out.println("Publishing date is not in the past.");
        }        
    }

    /**
     * @return the copies
     */
    public int getCopies() {
        return copies;
    }

    /**
     * @param copies the copies to set
     */
    public void setCopies(int copies) {
        this.copies = copies;
    }
            
    
    
}
