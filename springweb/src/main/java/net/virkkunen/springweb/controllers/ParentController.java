/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package net.virkkunen.springweb.controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import net.virkkunen.springweb.entities.Parent;
import net.virkkunen.springweb.entities.ParentHier;
import net.virkkunen.springweb.repositories.ParentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Solja
 */
@RestController
@RequestMapping("parents")
public class ParentController {
    
    @Autowired
    ParentRepository repo;
    
    @GetMapping
    List<ParentHier> getAll() {
        ArrayList<ParentHier> ret = new ArrayList<>(); //palautettava ArrayList, alunperin tyhjä. Kerätään objektit, joilla ei ole isää. Päätason objektit.

// ei vielä hierarkinen rakenne. mäpättiin Parent-lista(repo) siten, että saatiin ParentHier-objekteja:        
        List<ParentHier> pl = repo.findAll().stream()
                .map(p -> new ParentHier(p))
                .collect(Collectors.toList());

// striimataan alkuperäinen lista läpi, kaikki alkiot. filtteröidään alkiot. 
        pl.stream().forEach(child -> { 
                ParentHier parent = pl.stream() //toinen striimaus, jotta tutkitaan, löytyykö isä
                        .filter(p -> p.getId().equals(child.getParentId())) //Katsotaan, onko id sama kuin lapsen parentId.
                        .findFirst() //
                        .orElse(null);
                if (parent != null) { //Katsotaan jokaisen alkion osalta, löytyykö sille isä.
                    parent.addChild(child); //jos löytyy isä, lisätään isän kokoelmaan                   
                } else {
                    ret.add(child); // menee takaisin arraylistiin, jos ei löydy isää
                }
        });
        
        return ret; //palautetaan objektit, joilla ei isää
    }

    //{"name":"Some Corp","products":[
    //{"name":"Cheese","price":16},{"name":"Juice","price":15}
    //]}
    @PostMapping
    public String mostExpensive(@RequestBody Map<String,Object> data){
        ArrayList<Map<String,Object>> products=(ArrayList)data.get("products");
        String mostExpensive="Not found";
        int maxPrice=-1;
        for(Map<String,Object> product:products){
            Integer price=(Integer)product.get("price");
            if (price>maxPrice){
                maxPrice=price;
                mostExpensive=product.get("name").toString();
            }
        }
        return mostExpensive;
    }
}
    /*
    static void iterate(Organization o,int level){
        String prefix=" ".repeat(level);
        System.out.println(prefix+o.getName().toUpperCase());
        prefix+="  ";
        for(Person p:o.getPersons()){
            System.out.println(prefix+p.getName());
        }
        for(Organization sub:o.getChildren()){
            iterate(sub,level+1);
        }
    }

        Organization root=new Organization("Root");
        ol.stream().forEach(o -> {
            Organization parent=ol.stream().filter(op -> op.getId()==o.getParentId()).findFirst().orElse(null);
            if (parent!=null) parent.addChild(o);
            else root.addChild(o);
        });
        return root;
    */
    

