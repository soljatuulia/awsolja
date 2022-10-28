/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package net.tutorit.cpharjoitus2;

/**
 *
 * @author jyrki
 */
public class CPHarjoitus2 {

    static void generics(){
        /*
        Toteuta MultList ja SumList -luokille yhteinen kantaluokka,
        johon pyrit viemään mahdollisimman paljon toiminnallisuutta periytetyistä luokista
        */

        SumList sl=new SumList();
        sl.add(new Sum(2,3));
        sl.add(new Sum(3,4));
        sl.print();
        MultList ml=new MultList();
        ml.add(new Mult(5,6));
        ml.add(new Mult(6,7));
        ml.print();

    }
    
    static void abstracts(){

        Sum s=new Sum(1,2);
        Mult m=new Mult(2,3);        
        System.out.println("Summa "+s.result()); //3
        System.out.println("Tulo "+m.result()); // 6
        // Toteuta luokka CalcBase siten että seuraava toimii, kentät siirtyvät kantaluokkaan
        // laskennan pitää tapahtua periytetyssä luokassa
        s.print(); // 1 + 2 = 3
        m.print(); // 2 * 3 = 6
 
    }
    
    
    static void testInterfaces(Named n){
        System.out.println("Nimetty "+n.getName());
        // Step 2, laajenna rajapintaa siten että seuraavatkin toimivat
        // Nyt et saa koskea Person luokkaa, pelkästään rajapintaan ja Product-luokkaan
        System.out.println("Extra:"+n.getExtra()); // Henkilöltä "Extra", tuotteelta "Salt"
    }

    static void interfaces(){

        Person pe=new Person("John");
        testInterfaces(pe);
        Product pr=new Product("Salt");
        testInterfaces(pr);
        
        testInterfaces(() -> "Lambda");
        
        testInterfaces(new Named() {
            public String getName() {
                return "anonyymi";
            }
        });

        // Välitä testInterfaces-metodille lambda, joka tuottaa tulosteen "Nimetty Lambda"
        // Välitä testInterface-metodille anonyymiluokan ilmentymä, joka tuottaa tulosteen "Nimetty anonyymi"
    }
    
    /*Implement classess Some and Other*/

    static void testInheritance(Some s){
        System.out.println(s); // Should display "Some" for both cases
        s.print();   // Should display either "Some thing" or "Some stuff"
    }

    static void inheritance(){
        // Store constructor parameter to a field.

        Some s=new Some("thing");
        Other t=new Other("stuff");
        testInheritance(s);
        testInheritance(t);

    }
    
    public static void main(String[] args) {
        System.out.println("Harjoittelua");
        inheritance();
        interfaces();
        abstracts();
        generics();
    }
}
