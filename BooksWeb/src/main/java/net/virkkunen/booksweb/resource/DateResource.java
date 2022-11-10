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
}
