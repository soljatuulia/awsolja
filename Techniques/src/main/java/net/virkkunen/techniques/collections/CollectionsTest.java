
package net.virkkunen.techniques.collections;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
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

        // ArrayList<Person> greaterThan = persons.stream()
                
                
    }
    
    public static void mapTests() {
        
        Map<String, Person> people = new HashMap<String, Person>();
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
        
        for (Entry<String, Person> pe:people.entrySet()) {
            System.out.println(pe.getKey() + " ==> " + pe.getValue().getName());
        }
        
        for (Person p : people.values()) {
            System.out.println(p.getName());
        }

       
        HashMap<Integer, Integer> numbers = new HashMap<Integer, Integer>();
        
        for (int i = 0; i < 1000; i++) {
            int key=(int)(Math.random()*40+1);
            int counter = numbers.getOrDefault(key, 0); // jos ei dataa, tulokseksi 0
            numbers.put(key, counter + 1);
        }
        
//        for(int i : numbers.keySet()) {
//            System.out.println("Luku " + ??? + " arvottiin " + ?? + " kertaa"); // ks. Jyrkin koodi
//        }

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

        /*
        Use map to create stream of strings (the names of Persons)
        And only display those
        */
        /*
        Find the oldest person-worker
        Which stream-function to use???      
        */
        /*
        Find the age of the oldest Person
        Now use map and max
        */
        /*
        You should have a Company-class
        Add field ArrayList<Person>  employees (may be public)

        Create couple Company-objects and place couple Persons on their employees-list
        Place the Company-objects into an ArrayList
        Study Stream’s flatMap-method
        How do you print all the employees of both companies?
        */
        /*
        Study IntStream
        Generate 1000 random integers (1-100) into a List of integers
        And from that stream create a HashMap as we did earlier
        Value (1-100) is the key to the data
        The actual data behind the key is counter, how many times that value is generated
        */