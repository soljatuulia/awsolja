
package net.virkkunen.report;

import java.time.LocalDate;
import java.util.ArrayList;

/**
 *
 * @author Solja
 */
public class PersonReport extends ScreenReporter {
    
    private ArrayList<Person> persons = new ArrayList<>();
    private ScreenReporter rep = new ScreenReporter();  

    public PersonReport() {
        this.persons = persons;
        this.rep = new ScreenReporter();
        rep.addColumn("Name", 20);
        rep.addColumn("Age", 5);
    }
    
    public void addData(Person person) {
        persons.add(person);
    }
    
    public void doReport() {
        rep.printColumns();
        for (Person p : persons) {
            rep.printData(p.getName());
            rep.printData(p.getAge());
        }
        
    }

}
