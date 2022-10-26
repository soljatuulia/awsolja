
package net.virkkunen.report;
/**
 *
 * @author Solja
 */
public class PersonReport extends ReportBase<Person> {

    public PersonReport(Reporter reporter){
        super(reporter);
    }
    
    protected void addColumns(Reporter reporter){
        reporter.addColumn("Name",20);
        reporter.addColumn("Age",5);
    }
    
    protected void printData(Reporter reporter, Person p){
        reporter.printData(p.getName());
        reporter.printData(p.getAge());
    }

}
