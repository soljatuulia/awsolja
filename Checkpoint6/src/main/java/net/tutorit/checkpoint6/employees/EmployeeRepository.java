package net.tutorit.checkpoint6.employees;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author jyrki
 */
public interface EmployeeRepository extends JpaRepository<Employee,Integer>{
    
}
