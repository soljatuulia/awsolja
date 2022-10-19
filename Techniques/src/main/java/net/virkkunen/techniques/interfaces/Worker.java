
package net.virkkunen.techniques.interfaces;

/**
 *
 * @author Solja
 */
public interface Worker {
    
    void pay(double amount);
    
    
    
//    When testing finances, could you use lambda expression as a
//    parameter?
////        static void finances(Worker w, double amount){
//        System.out.println("Finances is processing worker.....");
//        w.pay(amount);
//        System.out.println("....done with it");
//    }
}
