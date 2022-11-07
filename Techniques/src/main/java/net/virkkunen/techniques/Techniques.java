
package net.virkkunen.techniques;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import net.virkkunen.techniques.collections.CollectionsTest;
import static net.virkkunen.techniques.collections.CollectionsTest.mapTests;
import static net.virkkunen.techniques.exceptions.ExceptionTests.testExceptions;
import net.virkkunen.techniques.files.FileTests;

/**
 *
 * @author Solja
 */
public class Techniques {

    public static void main(String[] args) {
        
        LocalDateTime dt=LocalDateTime.now().withHour(8).withMinute(30).withSecond(0).withNano(0);
        LocalDateTime xMinutesLater = dt.plusMinutes(70);
        System.out.println("70 minutes later is:"+xMinutesLater);
        
        LocalDate date = LocalDate.parse("2023-04-01");
        LocalDate date2 = date.plusDays(123);
        System.out.println("Date "+date+" plus 123 days is "+date2);
        
    }
}
