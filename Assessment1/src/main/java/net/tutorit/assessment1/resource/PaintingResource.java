/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package net.tutorit.assessment1.resource;

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
import net.tutorit.assessment1.entities.ErrorInfo;
import net.tutorit.assessment1.entities.Painting;

@Path("paintings")
public class PaintingResource {
    private static ArrayList<Painting> paintings=new ArrayList<>();
    static {
        paintings.add(new Painting(1,"Leonardo Da Vinci","Mona Lisa"));
        paintings.add(new Painting(2,"Vincent Van Gogh","Tähtikirkas yö"));
        paintings.add(new Painting(3,"Salvador Dali","Muiston pysyvyys"));
        paintings.add(new Painting(4,"Claude Monet","Impressio auringonnoususta"));
        paintings.add(new Painting(5,"Pablo Picasso","Vanha kitaristi"));
    }
    
    @GET
    @Produces("application/json")
    public List<Painting> getPaintings(@QueryParam("sort") @DefaultValue("artist") String sort,
            @QueryParam("filter") @DefaultValue("") String filter) {
        Stream<Painting> ps = paintings.stream();
        
        if (sort.equals("artist")) {
            ps = ps.sorted((a,b) -> a.getArtist().compareTo(b.getArtist()));
            
        } else {
            ps = ps.sorted((a,b) -> a.getPainting().compareTo(b.getPainting()));
        } 

        List<Painting> pl = ps.filter(p -> p.getArtist().contains(filter)
                                        || p.getPainting().contains(filter))
                                .collect(Collectors.toList()); 
        
        return pl;
        //return paintings;
    }    
    
    /*
        public List<Person> getPersons(@QueryParam("sort") @DefaultValue("id") String sort,
            @QueryParam("filter") @DefaultValue("") String filter){
        Stream<Person> ps=plist.stream();
        if (sort.equals("id")) ps=ps.sorted((a,b) -> a.getId()-b.getId());
        else ps=ps.sorted((a,b) -> a.getName().compareTo(b.getName()));
        List<Person> pl=ps.filter(p -> p.getName().contains(filter)).collect(Collectors.toList());
        return pl;
    */

    @GET
    @Produces("application/json")
    @Path("{id}")
    public Response getPainting(@PathParam("id") int id){
        Painting pf = paintings.stream()
                            .filter(p -> p.getId()==id)
                            .findFirst()
                            .orElse(null);
        
        if (pf==null) {
            return Response.status(Response.Status.NOT_FOUND)
                           .entity(new ErrorInfo(id,"Not found"))
                           .build();
        }    
        
            return Response.ok(pf).build();
    }

    @POST
    @Produces("application/json")
    @Consumes("application/json")
    public Response createPainting(Painting p){
        if (p.getArtist().equals("")) {
            return Response.status(Response.Status.BAD_REQUEST)
                            .entity(new ErrorInfo(404,"Wrong info"))
                            .build();            
        } 

        Optional<Painting> pf = paintings.stream()
                                            .max((a,b) -> a.getId()-b.getId());
        
        int newId = 1;
        if (pf.isPresent()) {
            newId = pf.get().getId()+1;
        }
        
        p.setId(newId);
        paintings.add(p);
        
        return Response.ok(p).build();
    }
    
    @PUT
    @Produces("application/json")
    @Consumes("application/json")
    @Path("{id}")
    public Response savePainting(@PathParam("id") int id, Painting p){
        if (p.getArtist().equals("")) {
            return Response.status(Response.Status.BAD_REQUEST)
                            .entity(new ErrorInfo(404,"Wrong info"))
                            .build();            
        } 
        
        
        if (p.getId() != id) {
            return Response.status(Response.Status.NOT_FOUND)
                           .entity(new ErrorInfo(id,"Not found"))
                           .build();
        }
        
        Painting pf = paintings.stream()
                                .filter(px -> px.getId() == id)
                                .findFirst()
                                .orElse(null);
        
        pf.setArtist(p.getArtist());
        pf.setPainting(p.getPainting());
        
        return Response.ok(pf).build();
    }        

    @DELETE
    @Path("{id}")
    public Response deletePainting(@PathParam("id") int id){
        Painting pf=paintings.stream()
                            .filter(px -> px.getId() == id)
                            .findFirst()
                            .orElse(null);
        
        if (pf == null) {
            return Response.status(Response.Status.NOT_FOUND)
                            .entity(new ErrorInfo(id,"Not found"))
                            .build();
        }
        
        return Response.ok(new ErrorInfo(0,"Deleted")).build();
        
    }
    
    /*
    Toteuta ohjeiden mukaan tyypillinen rest-palvelukokonaisuus

    */
}
