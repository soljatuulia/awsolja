
package net.tutorit.checkpoint1;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 *
 * @author Solja
 */
public class Transaction {
    
    private double amount;
    private LocalDate date;
    
    public Transaction(double amount, LocalDate date) {
        this.amount = amount;
        this.date = date;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }
        
}
