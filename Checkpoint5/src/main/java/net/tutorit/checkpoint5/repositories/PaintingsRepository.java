/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package net.tutorit.checkpoint5.repositories;

import java.util.List;
import net.tutorit.checkpoint5.entities.Painting;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

/**
 *
 * @author Solja
 */
public interface PaintingsRepository extends JpaRepository<Painting,Integer> {

    public List<Painting> findByNameContains(String name);
    
}
