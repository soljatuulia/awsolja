/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package net.virkkunen.techniques.dates;

import java.text.DateFormat;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.LocalDateTime;
import java.time.Duration;
import java.time.Month;
import java.time.Period;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalAdjusters;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;
        /**
 *
 * @author Solja
 */
public class DateTests {
    
    public static void differentOffices(){
                // Zoneddate -luokat
        show(LocalDateTime.now(),new Locale("en"));
        
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("Where's your office?");
        String city = scanner.nextLine();
        
        if (city.equals("Helsinki")) {
            System.out.println("Enter date (dd.mm.yyyy):");
            String inputDate = scanner.nextLine();
            
            System.out.println("Enter time (");
        }
        
        SimpleDateFormat format = new SimpleDateFormat();
        System.out.println("Enter date:");
        String inputDate = scanner.nextLine();
        

        System.out.println("Enter time:");
        String inputTime = scanner.nextLine();
                
        if (city.equals("Helsinki")) {
            
        }
        // Zoneddate -luokat
    }
    
    private static void show(LocalDateTime dt, Locale loc){
        DateFormat df=DateFormat.getDateInstance(DateFormat.SHORT,loc);
        
        Date date=Date.from(dt.atZone(ZoneId.systemDefault()).toInstant());
        String formatted=df.format(date);
        System.out.println(formatted);
        
        ZonedDateTime dtJp=ZonedDateTime.of(dt, ZoneId.of("Asia/Tokyo"));
        ZonedDateTime dtFi=ZonedDateTime.of(dt,ZoneId.of("Europe/Helsinki"));
        ZonedDateTime dtUs=ZonedDateTime.of(dt, ZoneId.of("America/New_York"));

        DateTimeFormatter pattern = DateTimeFormatter.ofLocalizedDateTime(FormatStyle.SHORT).withLocale(loc);

        System.out.println("Japan "+dtJp.format(pattern));
        System.out.println("Finnish "+dtFi.format(pattern));
        System.out.println("US "+dtUs.format(pattern));
        /*
        NumberFormat nf=NumberFormat.getNumberInstance(loc);
        System.out.println(nf.format(-1234567.891));
        */
    }
          
    public static void localeTests(){
        Locale loc=new Locale("en");
        Locale.setDefault(loc);
        LocalDateTime dt=LocalDateTime.now();
        System.out.println(dt.format(DateTimeFormatter.ISO_DATE));
        System.out.println(dt);

        Date date=new Date();
        DateFormat df=DateFormat.getDateInstance(DateFormat.SHORT,loc);
        String formatted=df.format(date);
        System.out.println(formatted);

        Locale locFi=new Locale("fi");
        Locale locJp=new Locale("jp");
        show(dt,loc);
        show(dt,locFi);
        show(dt,locJp);
    }
        
    public static void localeTests2() {
        LocalDate currentDate = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyy");
        String dateString = formatter.format(currentDate);
        System.out.println(dateString);
        
        Locale lf = new Locale("fr","CH");
        NumberFormat nf = NumberFormat.getNumberInstance(lf);
        System.out.println(nf.format(522.987));
        
        nf = NumberFormat.getCurrencyInstance(lf);
        System.out.println(nf.format(-444.678));
    }
            
    public static void calculateDate() {
        LocalDate currentDate = LocalDate.now();
        LocalTime currentTime = LocalTime.now();
        
        System.out.println("Current date is "+ currentDate + " and current time " + currentTime);
    }
    
    public static void duration() {
        Duration dur = Duration.ofDays(35);
        
        System.out.println(dur);
    }
    
    public static void whatDayIsIt() {
        LocalDate currentDate = LocalDate.now();
        Duration dur = Duration.ofDays(35);

        LocalDateTime futureDate = currentDate.atStartOfDay().withHour(9).plusDays(dur.toDays());
        System.out.println("Date in " + dur + " days is " + futureDate);
    }
    
    public static void daysToChristmas() {
        LocalDate currentDate = LocalDate.now();
        LocalDate christmas = LocalDate.of(2022, Month.DECEMBER, 24);
        // TAI PAREMMIN LocalDate christmas = current.withMonth(12).withDayOfMonth824);
        
        long ndays = currentDate.until(christmas, ChronoUnit.DAYS);
        System.out.println(ndays + " days until Christmas");
    }
    
    public static void daysToFriday() {
        LocalDate currentDate = LocalDate.now();
        LocalDate friday = currentDate.with(TemporalAdjusters.next(DayOfWeek.FRIDAY));
    
        while(friday.getDayOfMonth()!=13) {
            friday = friday.plusDays(7);
        }
        
        System.out.println("Next Friday the 13th is " + friday);
        
    }
    
    public static void tenDays() {
        LocalDate currentDate = LocalDate.now();
        System.out.println(currentDate.minusDays(10));
        System.out.println(currentDate.plusDays(10));
    }
    
    public static void getDayOfWeek() {
        LocalDate localDate = LocalDate.of(2022, 12, 24);
        java.time.DayOfWeek dayOfWeek = localDate.getDayOfWeek();
        dayOfWeek.getValue();
        dayOfWeek.toString();
        System.out.println(dayOfWeek);
    }
    
    public static void daysInBetween() {
        LocalDate d1 = LocalDate.of(2014, Month.JULY, 30);
        LocalDate d2 = LocalDate.of(1984, Month.DECEMBER, 16);
        int years = 0;
        int months = 0;
        
        Period diff = Period.between(d1, d2);
        System.out.println("Difference is " + diff.getYears() + " years and "
                            + diff.getMonths() + " months");
    }
}
