/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package net.virkkunen.at1practice;

import java.util.ArrayList;
import java.util.Comparator;
import static java.util.Comparator.comparing;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 *
 * @author Solja
 */
public class Collections {
    
    public static ArrayList<Person> persons = new ArrayList<>();
    
    static {
    persons.add(new Person(1,"Kikeke"));
    persons.add(new Person(2,"Kake"));
    persons.add(new Person(3,"Kek"));
    persons.add(new Person(4,"Pate"));
    persons.add(new Person(5,"Ritu"));
    }
 
    // MAP-toteutus!    
    public static void onlyNames() {
        persons.stream()
                .map(p -> p.getName())
                .distinct()
                .sorted()
                .forEach(name -> System.out.println(name));
    }
    
    
    public static void maxId() {
//        int maxId=persons.stream()
//                        .sorted((a,b) -> b.getId()-a.getId())
//                        .findFirst().orElse(new Person())
//                        .getId();
//        System.out.println("Largest "+maxId);        
        int maxId=persons.stream()
                    .mapToInt(p -> p.getId())
                    .max()
                    .getAsInt();
        System.out.println("Largest Id 2 "+maxId);   
        //return maxId;
    }
   
    
    public static void findPerson(int id) {
        Person pf=persons
                .stream()
                .filter(p -> p.getId()==id) 
                .findFirst() 
                .orElse(null); 
        
        System.out.println(pf);
    }

    public static List<Person> nameContains(String str) {
        //Stream<Person> ps=persons.stream();

        List<Person> pl=persons.stream() //otetaan talteen ps ja kutsutaan sitten filtteriä
                        .filter(p -> p.getName() // palauttaa streamin, jolle tehdään tämä toiminto
                        .contains(str)) // palauttaa jälleen uuden streamin, jolle tehdään toimint0
                        .collect(Collectors.toList()); // jne.
        
        return pl;

//        List<Person> ps = persons.stream()
//                .filter(p -> p.getName()
//                .contains(str))
//                .sorted()
//                .forEach(name -> System.out.println(name));
    }

    public static List<Person> sortBy() {
        Stream<Person> ps=persons.stream();

        List<Person> pl=ps //otetaan talteen ps ja kutsutaan sitten filtteriä
                        .sorted((a,b) -> a.getName().compareTo(b.getName()))
                        .collect(Collectors.toList()); // jne.
        
        return pl;
    }    

    
    public static Person longestName() {
        Person p=persons.stream()
            .sorted((s1,s2)->Integer.compare(s2.getName().length(),s1.getName().length()))
            .findFirst()
            .get();
        
        return p;
    }

    public static Person findLongest() {
        
        Person ps = persons.stream()
                            .max(Comparator.comparingInt(p -> p.getName().length())).get();
                            
        return ps;
    }
    
    public static void biggestId() {
        Person p=persons.stream()
            .sorted((s1,s2)->Integer.compare(s2.getId(),s1.getId()))
            .findFirst()
            .get();
                
       System.out.println(p);
        
    }  
    
    public static String findBiggestId() {
//        Person ps = persons.stream()
//                        .max(Comparator.comparingInt(p -> p.getId())).get();
//        
//        return ps;

//        List<String> names=persons.stream()
//                                    .map(p -> p.getName())
//                                    .collect(Collectors.toList());
//        names.stream().sorted((a,b) -> b.getId()-a.getId()).findFirst().orElse(new Person()).getId();
//        //System.out.println("Biggest id: "+bId);       
//        return names;
    }
    /*
    JYRKILTÄ! MAP OLEELLINEN:
    List<String> names = persons.stream().map(p -> getName().collect(Collectors.toList())) //tähän jotain?//
    names.stream().forEach(System.out::println);
    String nl=names.stream().collect(Collectors.joining(","));
    System.out.println(nl);
    
    String longest=persons.stream().map(p -> p.getName()).max((a,b) -> a.length()-b.length()).orElse("");
    System.out.println("Longest:"+longest);    
    
*/
}
