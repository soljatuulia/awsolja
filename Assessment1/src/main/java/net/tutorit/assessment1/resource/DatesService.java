/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package net.tutorit.assessment1.resource;

import jakarta.ws.rs.DefaultValue;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
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
import net.tutorit.assessment1.entities.ErrorInfo;

/**
 *
 * @author Solja
 */
@Path("dates")
public class DatesService {
    /*
    Toteuta palvelu osoitteeseen /api/dates/{date}, 
    jossa {date} on muotoa 2020-10-21. Palvelu vastaa get-menetelmällä tulleeseen pyyntöön
    
    Palvelun tulee myös hyväksyä QueryParam "plusdays" ja palauttaa parametrina tullut päiväys, 
    johon on lisätty plusdays-parametrin osoittama määrä päiviä.

    Palauta päivämäärä merkkijonona (text/plain) ,
    joka on muotoiltu kuten alkuperäinen päivämäärä.
    */
    
    @GET
    @Produces("text/plain")
    @Path("{date}")
    public Response getDate(@PathParam("date") String date){
        if (date.isEmpty()) return Response.status(Response.Status.BAD_REQUEST)
                                    .entity(new ErrorInfo(400,"Empty date")).build();
        DateTimeFormatter formatter1=DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate localDate1 = LocalDate.parse(date, formatter1);

        return Response.ok((localDate1).toString()).build();
    }

    @GET
    @Produces("text/plain")
    @Path("{date}/{plusdays}")    
    public String datePlusDays(@QueryParam("date") @DefaultValue("2020-10-21") String date, 
                          @QueryParam("plusdays")@DefaultValue("1") int d){
        if (d<0) throw new WebApplicationException("Liian vähän päiviä",Response.Status.BAD_REQUEST);
        
        DateTimeFormatter formatter1=DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate localDate1 = LocalDate.parse(date, formatter1);  
        
        return localDate1.plusDays(d).toString();
    }
    
    @POST
    @Produces("text/plain")
    @Path("meeting/{loc}/{hours}")       
    public String localDate(@QueryParam("loc") @DefaultValue("Europe/Helsinki") String locale, 
                          @QueryParam("hours")@DefaultValue("1") int h, 
                          String date) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss"); 
        LocalDateTime dateTime1 = LocalDateTime.parse(date,formatter);

        ZoneId localZone = ZoneId.of(locale);  
        
        ZoneId finZone = ZoneId.of("Europe/Helsinki");
        LocalDateTime newDateTime = dateTime1.plusHours(h).atZone(localZone)
                                                .withZoneSameInstant(finZone)
                                                .toLocalDateTime();     
        
        return newDateTime.format(DateTimeFormatter.ISO_LOCAL_DATE_TIME).toString();
    }

    /*
    Toteuta palvelu osoitteeseen /api/dates/meeting, joka vastaa POST-menetelmällä tulleeseen pyyntöön.

Pyynnön body:ssä tulee päivämäärä ja kellonaika muotoiltuna esim: 2020-11-02T13:12:19 (text/plain)

Lisäksi palvelu saa query-parametrit loc ja hours.

hours-parametri kertoo kuinka monella tunnilla päivämäärä/kellonaikaa tulee ensin kasvattaa

Loc parametrilla voi olla yksi seuraavista arvoista: jp,fi,us. 
    Kyseisestä arvosta voit päätellä aikavyöhykkeen Asia/Tokyo,Europe/Helsinki tai America/New_York.

Ajattele, että päiväys on lähetetty kyseiseltä aikavyöhykkeeltä. 
    Sinun tulee palauttaa päiväys/kellonaika siten että se vastaa kellonaikaa Suomessa.

Jos siis saat Japanista kellonajan 12:00, niin palautat Suomen kellonajan, 
    joka on 7h vähemmän mutta lisättynä hour-parametrin määrällä. 
    Vastaavasti jos saat kellonajan USA:sta, palautat kellonajan, joka on selkeästi enemmän. 
    Käytä laskennassa ZonedDateTime-luokkaa.

Palauta päiväystä ja kellonaikaa kuvaava merkkijono samalla tapaa muotoiltuna, 
    kuin alkuperäinen päiväys/kellonaika (text/plain).
    */
    
}
