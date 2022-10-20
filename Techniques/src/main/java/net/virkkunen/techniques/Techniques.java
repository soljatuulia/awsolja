
package net.virkkunen.techniques;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import net.virkkunen.techniques.collections.CollectionsTest;
import net.virkkunen.techniques.dates.DateTests;
import net.virkkunen.techniques.files.FileTests;

/**
 *
 * @author Solja
 */
public class Techniques {

    public static void main(String[] args) {
        
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
        LocalDate date = LocalDate.parse("20.10.2022", formatter);
        System.out.println(date);
        
    }
}
