
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
            String s = getName();
            double d = getAmount();
            fw.println(s + ", alkusaldo " + d);
            
            for(Transaction t: transactions){
                String list = this.getAll().toString();
                fw.println(t);
            }
            fw.close();
        }
        catch(IOException ex){
            System.out.println("Virhe: "+ex.getMessage());
        }
    }    
}
