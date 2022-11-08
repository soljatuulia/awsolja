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
import net.virkkunen.booksweb.entities.Person;

/**
 *
 * @author Solja
 */
@Path("person")
public class PersonService {
    
    //henkilöt tänne staattiseen listaan
    //muihin paitsi ekaan gettiin poikkeuskäsittely
    
    static ArrayList<Person> persons = new ArrayList<>();
    
    static {
        persons.add(new Person(1,"Kirsi","kirsi@kirsi.com"));
        persons.add(new Person(2,"Kike","kike@kike.com"));
        persons.add(new Person(3,"Pete","pete@pete.com"));
        persons.add(new Person(4,"Pertti","pertti@pertti.com"));
        persons.add(new Person(5,"Tyyppi","tyyppi@tyyppi.com"));
    }
     
    @GET
    @Produces({"application/json","application/xml"})
    public List<Person> getPersons(@QueryParam("sort") @DefaultValue("id") String sort,
            @QueryParam("filter") @DefaultValue("") String filter) {
        Stream<Person> ps=persons.stream(); // luodaan streamista uusi lista
        
        if (sort.equals("id")) {
            ps.sorted((a,b) -> a.getId()-b.getId());
        } else {
            ps=ps.sorted((a,b) -> a.getName().compareTo(b.getName()));
        } // kun tiedetään, kumpaa kutsutaan
        
        List<Person> pl=ps //otetaan talteen ps ja kutsutaan sitten filtteriä
                        .filter(p -> p.getName()
                        .contains(filter))
                        .collect(Collectors.toList());
        
        return pl;
// alkujaan vain: return persons;
    }
    
    @GET
    @Produces("application/json")
    @Path("{id}")
    public Response getPerson(@PathParam("id") int id){
        // stream!
        // annettava not found, jos ei löydy        
        Person pf=persons
                .stream()
                .filter(p -> p.getId()==id)
                .findFirst()
                .orElse(null);
        
        if (pf==null) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        
        return Response.ok(pf).build();
    }
    
    @POST
    @Produces("application/json")
    @Consumes("application/json")
    public Response createPerson(Person p){
        //virhe, jos nimi tyhjä
        if (p.getName().equals("")) {
            return Response.status(Response.Status.BAD_REQUEST).build();
        }     
        
        Optional<Person> pf = persons // Optional siltä varalta, että maksimia ei löydy
                                .stream()
                                .max((a,b) -> a.getId()-b.getId());
        
        int newId=1;
        if (pf.isPresent()) {
            newId=pf.get().getId()+1;
        }
        p.setId(newId);
        
        persons.add(p);
        return Response.ok(p).build();
    }
    
    @PUT
    @Produces("application/json")
    @Consumes("application/json") 
    @Path("{id}")
    public Response savePerson(@PathParam("id") int id, Person p) {
        //virhe, jos nimi tyhjä tai jos id!=p.id tai jos ei löydy
        if (p.getName().equals("")) {
            return Response.status(Response.Status.BAD_REQUEST).build();
        }
        if (id!=p.getId()) {
            return Response.status(Response.Status.BAD_REQUEST).build();
        }
        
        Person pf=persons
                .stream()
                .filter(px -> px.getId()==id)
                .findFirst()
                .orElse(null);
        
        if (pf==null) {
            return Response.status(Response.Status.BAD_REQUEST).build();
        }
        
        pf.setName(p.getName());
        return Response.ok(pf).build();
    }
    
    @DELETE
    @Produces("application/json")
    @Path("{id}")
    public void deletePerson(@PathParam("id") int id) {
        
    }
    
    
}
