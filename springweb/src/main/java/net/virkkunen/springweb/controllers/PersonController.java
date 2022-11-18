/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package net.virkkunen.springweb.controllers;

import java.util.List;
import net.virkkunen.springweb.entities.Person;
import net.virkkunen.springweb.entities.Person;
import net.virkkunen.springweb.entities.RequestInfo;
import net.virkkunen.springweb.repositories.PersonsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.server.ResponseStatusException;


@RestController
@RequestMapping("persons")
public class PersonController {
    
    @Autowired
    PersonsRepository repo;
    
    @GetMapping
    List<Person> getAll(@RequestParam(defaultValue="") String filter) {
        return repo.findFiltered("%" + filter + "%");
    }
        
    @GetMapping("/{id}")
    Person get(@PathVariable int id) {
        Person p = repo.findById(id).orElse(null);
        if (p==null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Foo not found");
        }
        return p;
    }
    
    @GetMapping("/persons")
    public Person[] getPersons(RestTemplate rt) {
        Person[] pa = rt.getForObject("http://localhost:8080/BooksWeb/services/person", Person[].class);
        return pa;
    }    
    
    @PostMapping
    Person create(@RequestBody Person p) {
        repo.saveAndFlush(p);
        if (p.getName().equals("")) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Name can not be empty");
        }
        return p;
    }
    
    @PutMapping("/{id}")
    Person save(@PathVariable int id, @RequestBody Person a) {
        repo.saveAndFlush(a);
        return a;
    }    
    
    @DeleteMapping("/{id}")
    RequestInfo delete(@PathVariable int id) {
        Person a = repo.findById(id).orElse(null);
        if (a == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Foo not found");
        }
        repo.deleteById(id);
        return new RequestInfo("Deleted");
    }
}
