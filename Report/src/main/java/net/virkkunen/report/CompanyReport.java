
package net.virkkunen.report;

/**
 *
 * @author Solja
 */
public class CompanyReport extends ReportBase<Company> {
    
    public CompanyReport(Reporter rep){
        super(rep);
    }
    
    protected void addColumns(Reporter reporter){
        reporter.addColumn("Company", 20);
        reporter.addColumn("Phone", 20);
        reporter.addColumn("Contact email", 20);
    }
    
    protected void printData(Reporter reporter, Company c){
        reporter.printData(c.getName());
        reporter.printData(c.getPhone());
        reporter.printData(c.getEmail());
    }
    
}
