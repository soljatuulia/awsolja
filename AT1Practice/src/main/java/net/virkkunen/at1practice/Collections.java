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
    
    public static void findPerson(int id) {
        Person pf=persons
                .stream()
                .filter(p -> p.getId()==id) 
                .findFirst() 
                .orElse(null); 
        
        System.out.println(pf);
    }

    public static List<Person> nameContains(String str) {
        Stream<Person> ps=persons.stream();

        List<Person> pl=ps //otetaan talteen ps ja kutsutaan sitten filtteriä
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
    
    public static void onlyNames() {
        persons.stream()
                .map(henkilo -> henkilo.getName())
                .distinct()
                .sorted()
                .forEach(nimi -> System.out.println(nimi));
    }
    
    public static void longestName() {
//        Person p=persons.stream()
//            .sorted((s1,s2)->Integer.compare(s2.getName().length(),s1.getName().length()))
//            .findFirst()
//            .get();
//                
//       System.out.println(p.getName());

        String longest = sortedList.stream()
                                max.
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
}
