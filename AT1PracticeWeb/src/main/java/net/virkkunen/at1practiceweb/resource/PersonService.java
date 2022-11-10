/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package net.virkkunen.at1practiceweb.resource;

import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.Response;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import net.virkkunen.at1practiceweb.entities.ErrorInfo;
import net.virkkunen.at1practiceweb.entities.Person;

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
        persons.add(new Person(1,"Kirsi"));
        persons.add(new Person(2,"Kike"));
        persons.add(new Person(3,"Hane"));
        persons.add(new Person(4,"Kikka"));
        persons.add(new Person(5,"Lulu"));
    }
    
    @GET
    @Produces({"application/json","application/xml"})    
    public List<Person> getAll() {
        return persons;
    }
    
    @GET
    @Produces("application/json")
    @Path("{id}")
    public Response getPerson(@PathParam("id") int id) {
        Person pf=persons
                .stream()
                .filter(p -> p.getId()==id) //kysytään kyseisen Personin id, jonka täsmättävä(==) parametrin id:hen
                .findFirst() // antaa listan nykyisestä järjestyksestä ensimmäisen kriteerit täyttävän alkion. jos löytyy, käytetään.
                .orElse(null); 

        if (pf==null) {
            return Response.status(Response.Status.NOT_FOUND)
                    .entity(new ErrorInfo(0,"Ei löydy"))
                    .build();
        }
        
        return Response.ok(pf).build();        
    }
    
    @PUT
    @Produces("application/json")
    public Response addPerson(Person p) {
        if (p.getName().equals("")) {
            return Response.status(Response.Status.BAD_REQUEST)
                    .entity(new ErrorInfo(0,"Nimi ei voi olla tyhjä"))
                    .build();
        }
        
        Optional<Person> person = persons.stream()
                                        .max((a,b) -> a.getId()-b.getId());
        
        
        int newId = 1;
        
        if (person.isPresent()) {
            newId = person.get().getId() + 1;
        }
        
        p.setId(newId);
        persons.add(p);
        
        return Response.ok(p).build();
    }
    
    @POST
    @Produces("application/json")
    @Consumes("application/json")
    @Path("{id}")
    public Response editPerson(@PathParam("id") int id, Person p) {
        if (p.getName().equals("")) {
            return Response.status(Response.Status.BAD_REQUEST)
                    .entity(new ErrorInfo(id,"Nimi ei voi olla tyhjä"))
                    .build();
        }

        if (p.getId() != id) {
            return Response.status(Response.Status.BAD_REQUEST)
                            .entity(new ErrorInfo(id,"Väärä id"))
                            .build();            
        }
        
        Person per = persons.stream()
                            .filter(px -> px.getId() == id)
                            .findFirst()
                            .orElse(null);
        
        if (per == null) {
            return Response.status(Response.Status.NOT_FOUND)
                            .entity(new ErrorInfo(id,"Ei löydy"))
                            .build();
        }
        
        per.setName(p.getName());
        return Response.ok(per).build();
    }
    
    @DELETE
    @Produces("application/json")
    @Path("{id}")
    public Response deletePerson(@PathParam("id") int id) {
        Person per = persons.stream()
                            .filter(px -> px.getId() == id)
                            .findFirst()
                            .orElse(null);
        
        if (per == null) {
            return Response.status(Response.Status.NOT_FOUND)
                            .entity(new ErrorInfo(id,"Ei löydy"))
                            .build();            
        }
        
        return Response.ok(new ErrorInfo(0,"Tuhottu")).build();
    }
}
