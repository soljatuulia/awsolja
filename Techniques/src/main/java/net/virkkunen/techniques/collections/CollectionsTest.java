
package net.virkkunen.techniques.collections;

import java.util.HashSet;
import java.util.Iterator;
import java.util.TreeSet;
import net.virkkunen.techniques.interfaces.Person;

/**
 *
 * @author Solja
 */
public class CollectionsTest {
    
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
