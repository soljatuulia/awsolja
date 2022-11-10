/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package net.virkkunen.booksweb.resource;

import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.DefaultValue;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.Response;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import net.virkkunen.booksweb.entities.Band;
import net.virkkunen.booksweb.entities.ErrorInfo;


/**
 *
 * @author Solja
 */
@Path("band")
public class BandService {
    
    static ArrayList<Band> bands = new ArrayList<>();
    
    static {
        bands.add(new Band(1,"Sigur Rós"));
        bands.add(new Band(2,"Dungen"));
        bands.add(new Band(3,"HAIM"));
        bands.add(new Band(4,"Ultra Bra"));
        bands.add(new Band(5,"Fleet Foxes"));
    }
    
    @GET
    @Produces({"application/json","application/xml"})    
    public List<Band> getBands(@QueryParam("sort") @DefaultValue("id") String sort,
            @QueryParam("filter") @DefaultValue("") String filter) {        
        Stream<Band> bs = bands.stream();
        
        if (sort.equals("id")) {
            bs.sorted((a,b) -> a.getId()-b.getId());
        } else {
            bs = bs.sorted((a,b) -> a.getName().compareTo(b.getName()));
        }
        
        List<Band> bl = bs.filter(b -> b.getName()
                            .contains(filter))
                            .collect(Collectors.toList());
        
        return bl;
        // return persons;
    }
    
    @GET
    @Produces("application/json")
    @Path("{id}")
    public Response getBand(@PathParam("id") int id) {
        Band bf=bands
                .stream()
                .filter(p -> p.getId()==id) //kysytään kyseisen Personin id, jonka täsmättävä(==) parametrin id:hen
                .findFirst() // antaa listan nykyisestä järjestyksestä ensimmäisen kriteerit täyttävän alkion. jos löytyy, käytetään.
                .orElse(null); 

        if (bf==null) {
            return Response.status(Response.Status.NOT_FOUND)
                    .entity(new ErrorInfo(0,"Ei löydy"))
                    .build();
        }
        
        return Response.ok(bf).build();        
    }
    
    @PUT
    @Produces("application/json")
    public Response addBand(Band ba) {
        if (ba.getName().equals("")) {
            return Response.status(Response.Status.BAD_REQUEST)
                    .entity(new ErrorInfo(0,"Nimi ei voi olla tyhjä"))
                    .build();
        }
        
        Optional<Band> band = bands.stream()
                                    .max((a,b) -> a.getId()-b.getId());
        
        
        int newId = 1;
        
        if (band.isPresent()) {
            newId = band.get().getId() + 1;
        }
        
        ba.setId(newId);
        bands.add(ba);
        
        return Response.ok(ba).build();
    }
    
    @POST
    @Produces("application/json")
    @Consumes("application/json")
    @Path("{id}")
    public Response editBand(@PathParam("id") int id, Band ba) {
        if (ba.getName().equals("")) {
            return Response.status(Response.Status.BAD_REQUEST)
                    .entity(new ErrorInfo(id,"Nimi ei voi olla tyhjä"))
                    .build();
        }

        if (ba.getId() != id) {
            return Response.status(Response.Status.BAD_REQUEST)
                            .entity(new ErrorInfo(id,"Väärä id"))
                            .build();            
        }
        
        Band band = bands.stream()
                            .filter(px -> px.getId() == id)
                            .findFirst()
                            .orElse(null);
        
        if (band == null) {
            return Response.status(Response.Status.NOT_FOUND)
                            .entity(new ErrorInfo(id,"Ei löydy"))
                            .build();
        }
        
        band.setName(ba.getName());
        return Response.ok(band).build();
    }
    
    @DELETE
    @Produces("application/json")
    @Path("{id}")
    public Response deleteBand(@PathParam("id") int id) {
        Band band = bands.stream()
                            .filter(px -> px.getId() == id)
                            .findFirst()
                            .orElse(null);
        
        if (band == null) {
            return Response.status(Response.Status.NOT_FOUND)
                            .entity(new ErrorInfo(id,"Ei löydy"))
                            .build();            
        }
        
        return Response.ok(new ErrorInfo(0,"Tuhottu")).build();
    }
}
