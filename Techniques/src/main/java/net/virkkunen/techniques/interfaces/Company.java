
package net.virkkunen.techniques.interfaces;

/**
 *
 * @author Solja
 */
public class Company implements Worker {
    
    private String name;
    
    public Company(String name) {
        this.name = name;
    }
    
    public void pay(double amount) {
        System.out.println(this.getName() + " invoices " + amount + " EUR + VAT " +
                amount * 0.24 + " EUR");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
     
}
