/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package net.virkkunen.springweb.repositories;

import java.util.List;
import net.virkkunen.springweb.entities.Car;
import net.virkkunen.springweb.entities.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

/**
 *
 * @author Solja
 */
public interface CarsRepository extends JpaRepository<Car,Integer> {

    @Query("SELECT c FROM Car c")
    List<Car> findFiltered(String filt);
    
}
