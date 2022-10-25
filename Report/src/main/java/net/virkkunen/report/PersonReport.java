
package net.virkkunen.report;

import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;

/**
 *
 * @author Solja
 */
public class PersonReport extends ScreenReporter {
    
    private ArrayList<Person> persons = new ArrayList<>();
    private Reporter reporter;

    public PersonReport(Reporter rep) {
        reporter = rep;
        reporter.addColumn("Name", 20);
        reporter.addColumn("Age", 5);
    }
    
    public void addData(Person person) {
        persons.add(person);
    }
    
    public void doReport() throws IOException {
        reporter.beginReport();
        reporter.printColumns();
        for (Person p : persons) {
            reporter.printData(p.getName());
            reporter.printData(p.getAge());
        }
        reporter.endReport();
    }

}
