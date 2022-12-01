package net.tutorit.checkpoint6.employees;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.server.ResponseStatusException;

/**
 *
 * @author jyrki
 */
@RestController
@RequestMapping("employees")
public class EmployeeController {
    @Autowired
    EmployeeRepository repo;

    @GetMapping
    public List<Employee> getAll(){
        return repo.findAll();
    }    
   
    @GetMapping("/hierarchy")
    public List<EmployeeHier> getHierarchy(){
        ArrayList<EmployeeHier> ret = new ArrayList<>(); 

        List<EmployeeHier> el = repo.findAll().stream()
                .map(p -> new EmployeeHier(p))
                .collect(Collectors.toList());

        el.stream().forEach(subordinate -> { 
                EmployeeHier employee = el.stream() 
                        .filter(e -> e.getId().equals(subordinate.getSuperiorId())) 
                        .findFirst() //
                        .orElse(null);
                if (employee != null) { 
                    employee.addSubordinate(subordinate);                  
                } else {
                    ret.add(subordinate); 
                }
        });
        
        //iterate(ret,0);
        
        return ret;    
        //return repo.findAll();
    }
       
    @PostMapping
    Employee create(@RequestBody Employee e) {
        repo.saveAndFlush(e);
        if (e.getName().equals("")) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Name can not be empty");
        }
        return e;
    }
    
/*
    @PostMapping(value="/upload", produces="application/json", consumes="text/csv")
    Employee upload(@RequestBody String data) {

        
    }


    static void iterate(EmployeeHier e, int level){
        String prefix=" ".repeat(level);
        System.out.println(prefix+e.getName().toUpperCase());
        prefix+="  ";
        for(Superior s:e.getSuperiors()){
            System.out.println(prefix+s.getName());
        }
        for(EmployeeHier sub:e.getSubordinates()){
            iterate(sub,level+1);
        }        
    } 
    */
    
}
