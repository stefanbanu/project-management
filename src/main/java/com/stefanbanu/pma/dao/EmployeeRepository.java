package com.stefanbanu.pma.dao;

import com.stefanbanu.pma.entities.Employee;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface EmployeeRepository  extends CrudRepository<Employee, Long> {

    @Override
    List<Employee> findAll();
}
