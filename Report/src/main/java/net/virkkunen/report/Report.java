

package net.virkkunen.report;

import java.io.IOException;

/**
 *
 * @author Solja
 */
public class Report {

    public static void main(String[] args) throws IOException {
    
    TabularFormatter tf=new TabularFormatter();
    ScreenReporter repScreen=new ScreenReporter(tf);
    FileReporter repFile=new FileReporter(tf,"report.txt");
    
    PersonReport pr=new PersonReport(repScreen);
    pr.addData(new Person("John Wayne",82));
    pr.addData(new Person("Ronald Reagan",92));
    pr.doReport();
    
    CompanyReport cr=new CompanyReport(repFile);
    cr.addData(new Company("Coders Unlimited","555-234234","info@coders.net"));
    cr.addData(new Company("Testers united","555-123123","info@testers.com"));
    cr.doReport();
    
    }
}
