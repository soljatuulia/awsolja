/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package net.tutorit.checkpoint3;

import java.util.List;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author Solja
 */
public interface PassangerRepository extends CrudRepository<Passanger,Integer> {
    
    @Query("SELECT p.name FROM passanger p WHERE psgtype='ihminen' ORDER BY p.name")
    List<Passanger> listByType();
    
    @Query("SELECT c.* FROM passanger p,car c WHERE c.id=p.car_id AND p.id=:passangerId")
    public Car findCar(int passangerId);    
    
    @Query("SELECT c.make,p.name,p.psgtype FROM passanger p,car c WHERE c.id=p.car_id AND c.id=1 OR c.id=p.car_id AND c.id=2 OR c.id=p.car_id AND c.id=3 ORDER BY c.id,p.name")
    public List<PassangersAndCars> listAll();    
}
