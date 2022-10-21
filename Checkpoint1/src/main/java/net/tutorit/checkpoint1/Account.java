
package net.tutorit.checkpoint1;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Solja
 */
public class Account {
    
    private String name;
    private double amount;
    private ArrayList<Transaction> transactions = new ArrayList<>();
    
    public Account(String name, double amount) {
        this.name = name;
        this.amount = amount;                
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }
    
    public void transaction(double amount, LocalDate date) {
        transactions.add(new Transaction(amount, date));
    }
    
    List<Transaction> getAll() {
        return transactions;
    }
    
    void export(String file) {
        try(PrintWriter fw=new PrintWriter(file)) {
            for(Transaction t: transactions){
                List<Transaction> s=this.getAll();
                fw.println(s);
            }
            fw.close();
        }
        catch(IOException ex){
            System.out.println("Virhe: "+ex.getMessage());
        }
    }    
}
