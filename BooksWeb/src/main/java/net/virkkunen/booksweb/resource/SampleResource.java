package net.virkkunen.booksweb.resource;

import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import static jakarta.ws.rs.core.MediaType.TEXT_PLAIN;
import java.time.LocalDate;

@Path("sample") // = url, jost tämän luokan metodit löytyvät (localhost:8080/BooksWeb/api/sample)
public class SampleResource{

    static String text="Kokeillaanpa"; // oltava static, jotta tieto säilyy pyyntöjen välillä eli tälle on joka kutsulle vain yksi ilmentymä
    
    @GET
    //@Path("eka") = metodissa voi olla tarkenne
    @Produces("text/plain") // = kertoo, että olen muotoillut vastauksen tällä tavalla
    public String message() {
        LocalDate dt = LocalDate.of(2020, 5, 12);
        return text;
    }
    
    @GET
    @Path("toka")
    @Produces("text/plain")
    public String secondMessage() {
        return "Terve taas";
    }
    
    @PUT
    @Produces("text/plain")
    @Consumes("text/plain")
    public String changeMessage(String msg) {
        text += msg;
        return text;
    }
    
    @POST
    @Produces("text/plain")
    @Consumes("text/plain")
    public String newMessage(String newmsg) {
        text = newmsg;
        return text;
    }
    
    @DELETE
    @Produces("text/plain")
    public String deleteMessage() { // ei parametria, selaimelta ei dataa
        text = "Poistettu";
        return text;
    }

}