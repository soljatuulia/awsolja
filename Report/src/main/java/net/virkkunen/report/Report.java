

package net.virkkunen.report;

/**
 *
 * @author Solja
 */
public class Report {

    public static void main(String[] args) {
    PersonReport pr=new PersonReport();
    pr.addData(new Person("John Wayne", 82));
    pr.addData(new Person("Ronald Reagan", 92));
    pr.doReport();

    }
}
