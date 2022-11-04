/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package net.tutorit.cpharjoitus3;

import java.util.List;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author Solja
 */
public interface StudentRepository extends CrudRepository<Student,Integer>{
    
    @Query("select s.name from student s where evaldate>'2022-10-15'")
    List<Student> findAfterDate();
    
    @Query("select s.name,s.evaldate,c.classname,c.teacher FROM student s,class c WHERE s.class_id=c.id ORDER BY c.teacher,s.name;")
    List<StudentReport> listForReport();
}
