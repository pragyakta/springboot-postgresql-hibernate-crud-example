package net.javaLesson.Springboot.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import net.javaLesson.Springboot.Model.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee,Long>{

}
