/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package net.virkkunen.booksweb.resource;

import jakarta.ws.rs.DefaultValue;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.HeaderParam;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.WebApplicationException;
import jakarta.ws.rs.core.Response;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;

/**
 *
 * @author Solja
 */
@Path("dates")
public class DateResource {
    
    
    @GET
    @Produces("text/plain") // urlin perässä +-merkin jälkeen ?year=2022&month=12
    public String getDate(@QueryParam("year") @DefaultValue("2022") int y,
                          @QueryParam("month") @DefaultValue("1") int m,
                          @QueryParam("day") @DefaultValue("1") int d) {
        if (m>12) throw new WebApplicationException("Muuta kuukausi",Response.Status.BAD_REQUEST);
        // yllä minimaalinen poikkeuskäsittely
        return LocalDate.of(y,m,d).toString();
    }
    
    @GET
    @Produces("text/plain")
    @Path("{year}/{month}/{day}") // oltava kuvattuna (kolme) muuttuvaa osuutta, jotka urliin 
    public Response getDateFromPath(@PathParam("year") int y, // poikkeuskäsittelyä varten Response
                                  @PathParam("month") int m,
                                  @PathParam("day") int d) {
        if (m>12) return Response.status(Response.Status.BAD_REQUEST)
                        .header("x-virhe","paivamaara")
                        .entity("Väärä kuukausi").build();
        return Response.ok(LocalDate.of(y,m,d).toString()).build();
// suositeltavin poikkeuskäsittely        
//return LocalDate.of(y,m,d).toString();
    }
    
    @GET
    @Produces("text/plain")
    @Path("head")
    public String getDateHeader(@HeaderParam("x-year") int y,
                                @HeaderParam("x-month") int m,
                                @HeaderParam("x-day") int d) {
        return LocalDate.of(y,m,d).toString();
    }
    
    @GET
    @Produces("text/plain")
    @Path("datetime")
    public String getDateTime() {
        String str = "2022-05-02T15:21:45"; 
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss"); 
        LocalDateTime dateTime1 = LocalDateTime.parse(str,formatter);
        return dateTime1.toString();        
    }
    
    @GET
    @Produces("text/plain")
    @Path("timezone")
    public String getTimeZone() {
        //System.out.println("dateTimeTests");
        String str = "2022-05-02T15:21:45"; 
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss"); 
        LocalDateTime dateTime1 = LocalDateTime.parse(str,formatter);
        //System.out.println(dateTime1);

        ZoneId fiZone = ZoneId.of("Europe/Helsinki");

        ZoneId usZone = ZoneId.of("America/New_York");
        LocalDateTime newDateTime = dateTime1.atZone(fiZone)
                                                .withZoneSameInstant(usZone)
                                                .toLocalDateTime();
        //System.out.println("Helsinki to NYC: "+newDateTime.format(DateTimeFormatter.ISO_LOCAL_DATE_TIME));
        
        ZoneId jpZone = ZoneId.of("Asia/Tokyo");
        LocalDateTime newDateTime2 = dateTime1.atZone(fiZone)
                                                .withZoneSameInstant(jpZone)
                                                .toLocalDateTime();
        //System.out.println("Helsinki to Tokyo: "+newDateTime2.format(DateTimeFormatter.ISO_LOCAL_DATE_TIME));

        ZoneId localJpZone = ZoneId.of("Asia/Tokyo");

        ZoneId us2Zone = ZoneId.of("America/New_York");
        LocalDateTime newDateTime3 = dateTime1.atZone(localJpZone)
                                                .withZoneSameInstant(us2Zone)
                                                .toLocalDateTime();
        //System.out.println("Tokyo to NYC: "+newDateTime3.format(DateTimeFormatter.ISO_LOCAL_DATE_TIME));
        
        ZoneId fi2Zone = ZoneId.of("Europe/Helsinki");
        LocalDateTime newDateTime4 = dateTime1.atZone(localJpZone)
                                                .withZoneSameInstant(fi2Zone)
                                                .toLocalDateTime();
        //System.out.println("Tokyo to Helsinki: "+newDateTime4.format(DateTimeFormatter.ISO_LOCAL_DATE_TIME)); 
        
        return "Helsinki to NYC: "+newDateTime.format(DateTimeFormatter.ISO_LOCAL_DATE_TIME).toString()+"/n"+
                "Helsinki to Tokyo: "+newDateTime2.format(DateTimeFormatter.ISO_LOCAL_DATE_TIME).toString();
    }
    
}
