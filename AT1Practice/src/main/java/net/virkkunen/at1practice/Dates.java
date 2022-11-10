/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package net.virkkunen.at1practice;

import java.text.DateFormat;
import java.text.NumberFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.Date;
import java.util.Locale;

/**
 *
 * @author Solja
 */
public class Dates {
    /*
- Näitä kannattaa testailla ihan konsoli-sovelluksella
- Tee merkkijonosta 2022-05-02T15:21:45 LocalDateTime-objekti ja tulosta se
- Ajattele, että kyseinen päiväys on muodostetu Suomessa (”Europe/Helsinki”)
o Mitä kello on samaan aikaan Japanissa ("Asia/Tokyo")
o Mitä kello on samaan aikaan New Yorkissa ("America/New_York")
- Ajattele, että kyseinen päiväys on muodostettu Tokiossa
o Mitä kello on samaan aikaan Helsingissä
o Mitä kello on samaan aikaan New Yorkissa
- Ajattele, että kyseinen päiväys on muodostettu New Yorkissa
o Mitä kello on samaan aikaan Tokiossa
o Mitä kello on samaan aikaan Helsingissä
    */

    public static void dateTimeTests() {
        System.out.println("dateTimeTests");
        String str = "2022-05-02T15:21:45"; 
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss"); 
        LocalDateTime dateTime1 = LocalDateTime.parse(str,formatter);
        System.out.println(dateTime1);
        
        //LocalDateTime fiDateTime = LocalDateTime.parse("2022-05-02T15:21:45");
        ZoneId fiZone = ZoneId.of("Europe/Helsinki");

        ZoneId usZone = ZoneId.of("America/New_York");
        LocalDateTime newDateTime = dateTime1.atZone(fiZone)
                                                .withZoneSameInstant(usZone)
                                                .toLocalDateTime();
        System.out.println("Helsinki to NYC: "+newDateTime.format(DateTimeFormatter.ISO_LOCAL_DATE_TIME));
        
        ZoneId jpZone = ZoneId.of("Asia/Tokyo");
        LocalDateTime newDateTime2 = dateTime1.atZone(fiZone)
                                                .withZoneSameInstant(jpZone)
                                                .toLocalDateTime();
        System.out.println("Helsinki to Tokyo: "+newDateTime2.format(DateTimeFormatter.ISO_LOCAL_DATE_TIME));

        ZoneId localJpZone = ZoneId.of("Asia/Tokyo");

        ZoneId us2Zone = ZoneId.of("America/New_York");
        LocalDateTime newDateTime3 = dateTime1.atZone(localJpZone)
                                                .withZoneSameInstant(us2Zone)
                                                .toLocalDateTime();
        System.out.println("Tokyo to NYC: "+newDateTime3.format(DateTimeFormatter.ISO_LOCAL_DATE_TIME));
        
        ZoneId fi2Zone = ZoneId.of("Europe/Helsinki");
        LocalDateTime newDateTime4 = dateTime1.atZone(localJpZone)
                                                .withZoneSameInstant(fi2Zone)
                                                .toLocalDateTime();
        System.out.println("Tokyo to Helsinki: "+newDateTime4.format(DateTimeFormatter.ISO_LOCAL_DATE_TIME));
        
//        ZonedDateTime helsinki = dateTime1.atZone(ZoneId.of("Europe/Helsinki"));
//        System.out.println("Helsinki: " + helsinki);
//        System.out.println("Helsinki formated: " + helsinki.format(DateTimeFormatter.ofLocalizedTime(FormatStyle.FULL)));
    }

    
    public static void localDateTests() {
        System.out.println("localDateTests");
        String dateString1="2022-05-02";
        DateTimeFormatter formatter1=DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate localDate1 = LocalDate.parse(dateString1, formatter1);
        System.out.println(localDate1);
        System.out.println("2022-05-02 plus 3 days: "+localDate1.plusDays(3));
        
        String dateString2="2.5.2022";
        DateTimeFormatter formatter2=DateTimeFormatter.ofPattern("d.M.yyyy");
        LocalDate localDate2 = LocalDate.parse(dateString2, formatter2);
        System.out.println(localDate2);
        System.out.println("2.5.2022 plus 3 days: "+localDate2.plusDays(3));
        
        String dateString3="5/2/2022";
        DateTimeFormatter formatter3=DateTimeFormatter.ofPattern("M/d/yyyy");
        LocalDate localDate3 = LocalDate.parse(dateString3, formatter3);
        System.out.println(localDate3);
        System.out.println("5/2/2022 plus 3 days: "+localDate3.plusDays(3));
        
        Locale finnish = new Locale("fi", "FI");    
        DateTimeFormatter fiDateFormatter = DateTimeFormatter.ofLocalizedDate(FormatStyle.SHORT).withLocale(finnish);  // 4
        String fiFormattedDate = localDate1.format(fiDateFormatter);  // 5
        System.out.println("Finland: " + fiFormattedDate);
         
        DateTimeFormatter jpDateFormatter = DateTimeFormatter.ofLocalizedDate(FormatStyle.SHORT).withLocale(Locale.JAPAN);  // 4
        String jpFormattedDate = localDate1.format(jpDateFormatter);  // 5
        System.out.println("Japan: " + jpFormattedDate);  
        
        DateTimeFormatter usDateFormatter = DateTimeFormatter.ofLocalizedDate(FormatStyle.SHORT).withLocale(Locale.US);  // 4
        String usFormattedDate = localDate1.format(usDateFormatter);  // 5
        System.out.println("Usa: " + usFormattedDate);         
        
//        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
//        Locale finnish = new Locale("fi", "FI");
//        formatter = formatter.withLocale(finnish); 
//        LocalDate date1 = LocalDate.parse("2022-05-02", formatter);
//        System.out.println(date1);
        
        /*
        private static void formatLocalDateObjToLocalizedDateStr() {
    LocalDate currentDate = LocalDate.now();  // 1

    DateTimeFormatter usDateFormatter = DateTimeFormatter.ofLocalizedDate(FormatStyle.FULL).withLocale(Locale.US);  // 2
    String usFormattedDate = currentDate.format(usDateFormatter);  // 3
    System.out.println("Current date in en-US date format: " + usFormattedDate);

    DateTimeFormatter frDateFormatter = DateTimeFormatter.ofLocalizedDate(FormatStyle.FULL).withLocale(Locale.FRANCE);  // 4
    String frFormattedDate = currentDate.format(frDateFormatter);  // 5
    System.out.println("Current date in fr-FR date format: " + frFormattedDate);
}
        */
    }

}
