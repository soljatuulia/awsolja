/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package net.tutorit.cpharjoitus3;

import java.sql.Date;
import java.util.List;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author Solja
 */
public interface StudentRepository extends CrudRepository<Student,Integer> {
    
    @Query("SELECT * FROM student where evaldate > '2022-10-15'")
    public List<Student> evalAfter();
    
    @Query("SELECT s.name,s.evaldate,c.classname,c.teacher FROM student s, class c WHERE c.id=s.class_id ORDER BY c.teacher,s.name")
    public List<StudentReport> listAll();
    
    @Query("SELECT s.name,s.evaldate,c.classname,c.teacher FROM student s, class c WHERE c.id=s.class_id")
    public List<StudentReport> listAll2();
}
