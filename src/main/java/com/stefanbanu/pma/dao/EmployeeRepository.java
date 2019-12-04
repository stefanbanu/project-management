package com.stefanbanu.pma.dao;

import com.stefanbanu.pma.dto.EmployeeProject;
import com.stefanbanu.pma.entities.Employee;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface EmployeeRepository  extends CrudRepository<Employee, Long> {

    @Override
    List<Employee> findAll();

    @Query(nativeQuery = true, value ="select e.first_name as firstName, e.last_name as lastName, COUNT(pe.employee_id) as projectCount " +
            " from employee e left join  project_employee pe ON pe.employee_id = e.employee_id" +
            " group by e.first_name, e.last_name" +
            " order by 3 desc")
    List<EmployeeProject> employeesProjects();

}
