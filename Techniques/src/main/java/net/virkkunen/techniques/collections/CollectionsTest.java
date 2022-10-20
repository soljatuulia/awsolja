
package net.virkkunen.techniques.collections;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.TreeSet;
import java.util.stream.Collectors;
import net.virkkunen.techniques.interfaces.Person;

/**
 *
 * @author Solja
 */
public class CollectionsTest {
    
    static ArrayList<Person> persons = new ArrayList<Person>();
    
    static {
        Person p1 = new Person("Lissu", 44);
        Person p2 = new Person("Hissu", 99);
        Person p3 = new Person("Kissu", 2);
        Person p4 = new Person();
        persons.add(p1);
        persons.add(p2);
        persons.add(p3);
        persons.add(p4);
    }
    
    public static void showPersons() {
        System.out.println("Henkilöt:");
        for(Person p : persons) {
            System.out.println(p);
        }        
    }
    
    public static void personArrayTests() {
        showPersons();
        
        persons.sort((p1, p2) -> p1.getName().compareTo(p2.getName()));
        showPersons();
        
        persons.sort((p1, p2) -> p1.getAge()-p2.getAge());
        showPersons();
    }
    
    public static void personStreamTests() {
        ArrayList<Person> sortedList = (ArrayList<Person>) persons
                .stream()
                .sorted(Comparator.comparingInt(Person::getAge))
                .collect(Collectors.toList());
        
        sortedList.forEach(System.out::println);
        
        // Tee sama kuin yllä lambdalla

        ArrayList<Person> greaterThan = persons.stream()
                
                
    }
    
    public static void mapTests() {
        
        HashMap<String, Person> people = new HashMap<String, Person>();
        Person p1 = new Person();
        Person p2 = new Person();
        Person p3 = new Person();
        Person p4 = new Person();
        p1.setName("Lissu");
        p2.setName("Tiina");
        p3.setName("Kaltsu");
        people.put("12345", p1);
        people.put("56789", p2);
        people.put("09876", p3);
        people.put("08641", p4);
        
        for (String key : people.keySet()) {
            System.out.println("Nimi on " + people.get(key).getName() + " ja hetu " + key);
        }
        
        HashMap<Integer, Integer> numbers = new HashMap<Integer, Integer>();
        
        for (int i = 0; i < 1000; i++) {
            int key=(int)(Math.random()*40+1);
            int counter = numbers.getOrDefault(key, 0); // jos ei dataa, tulokseksi 0
            numbers.put(key, counter + 1);
        }
        
        for(int i : numbers.keySet()) {
            System.out.println("Luku " + ??? + " arvottiin " + ?? + " kertaa"); // ks. Jyrkin koodi
        }

    }
    
    public static void setTests() {
        System.out.println("Settien testailua");
        
        TreeSet<String> set = new TreeSet();
            set.add("Monday");
            set.add("Tuesday");
            set.add("Wednesday");
            set.add("Thursday");
            set.add("Friday");
            set.add("Saturday");
            set.add("Sunday");
            set.add("Monday");
            Iterator<String> i = set.iterator();
            
            while (i.hasNext()) {
                System.out.println(i.next());
            }
            
        TreeSet<Person> ps=new TreeSet<>();
        Person person=new Person();
        person.setName("Tuulia");
        ps.add(new Person());
        ps.add(new Person());
        ps.add(person);
        //ps.add(person);
        for(Person p : ps){
            System.out.println(p.getName());            }        
        
    }
    
    
}
