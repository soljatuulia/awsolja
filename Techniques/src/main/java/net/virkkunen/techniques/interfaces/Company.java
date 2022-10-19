
package net.virkkunen.techniques.interfaces;

/**
 *
 * @author Solja
 */
public class Company implements Worker {
    
    private String name;
    
    public void pay(double amount) {
        System.out.println(this.getName() + " invoices " + amount + " EUR + VAT " +
                amount * 0.24 + " EUR");
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }
     
}
