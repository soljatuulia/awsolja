/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package net.virkkunen.springweb.repositories;

import net.virkkunen.springweb.entities.Parent;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author Solja
 */
public interface ParentRepository extends JpaRepository<Parent, Integer> {
    
}
