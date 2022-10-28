/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package net.tutorit.checkpoint2;

/**
 *
 * @author jyrki
 */
public class Checkpoint2 {

    /*
        Implement a common baseclass to NewspaperList and PrinterPool.
        Move as much of the common functionality to base class as possible
    */
    static void generics(){
        NewspaperList npl=new NewspaperList();
        npl.add(new Newspaper("New York Times",1.23));
        npl.add(new Newspaper("Duckburg Gazette",0.92));
        npl.listThem();
        PrinterPool pp=new PrinterPool();
        pp.add(new Printer("Brother 321",3));
        pp.add(new Printer("HP 123",4));
        pp.showPool();
    }
    
    static void abstracts(){
        /*
        Movie m=new Movie("Gone with the Wind",221); // Name and duration in minutes
        Series s=new Series("Dallas",357); // Name and number of episodes
        // Implement TvBase that will be base-class for both of above classes
        // It should hold (at least) the print-method and name field
        // duration string must be queried from the concrete classes
        m.print(); // Gone with the Wind, duration 221 minutes
        s.print(); // Dallas, 357 episodes
        */
    }

    /*
    Implement Priced-interface and Cheese and Juice classes so
    that two methods below begin to work
    */
    /*
    static void testInterfaces(Priced p){
        System.out.println("Price: "+p.getPrice());
        System.out.println("Name: "+p.getName()); 
    }
    */
    
    static void interfaces(){
        /*
        Juice j=new Juice("Appelsiinimehu",12.4); // Name and price
        Cheese c=new Cheese("Emmental",5.34);
        testInterfaces(j);
        testInterfaces(c);
        // Make also the following work:
        testInterfaces(() -> 10.4); // Should print Price: 10.4, Name: Default
        // Also pass an instance of an anonymous class to testInterfaces
        // It should print out Price:54.32, Name: Anonymous
        */
    }
    
    /*
    Implement the two classes needed for following two functions to work as described
    */
    /*
    static void testInheritance(Book b){
        String t=b.getTitle();  // Hobbit or Encyclopedia Britannica
        System.out.println("Printing "+t);
        b.print(); 
        // Either: "In a hole in the ground there lived a hobbit"
        // Or: "Encyclopedia britannica has 32640 pages
    }
    */
    
    static void inheritance(){
        /*
        Book b=new Book("Hobbit");
        Encyclopedia e=new Encyclopedia(32640); 
        System.out.println(b);  // Hobbit
        System.out.println(e); // Huge book
        testInheritance(b);
        testInheritance(e);
        */
    }
    
    public static void main(String[] args) {
        System.out.println("Testataanpas taas");
        System.out.println("Kopioi tulosteet tästä eteenpäin vastaukseksi Canvakseen____________");
        inheritance();
        interfaces();
        abstracts();
        generics();
        System.out.println("Tähän loppuvat tulosteet__________________");
        System.out.println("Muista lopettaa testi Canvaksessa sekä palauttaa tämä tehtävä GitHub:iin");
    }
}
