
package net.virkkunen.report;

import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author Solja
 */
public class CompanyReport {
    
    private ArrayList<Company> companies = new ArrayList<>();
    private Reporter reporter;
    
    public CompanyReport(Reporter rep) {
        reporter = rep;
        reporter.addColumn("Company", 20);
        reporter.addColumn("Phone", 20);
        reporter.addColumn("Contact email", 20);
    }
    
    public void addData(Company company) {
        companies.add(company);
    }
    
    public void doReport() throws IOException {
        reporter.beginReport();
        reporter.printColumns();
        for (Company c : companies) {
            reporter.printData(c.getName());
            reporter.printData(c.getPhone());
            reporter.printData(c.getEmail());
        }
        reporter.endReport();
    }
    
}
