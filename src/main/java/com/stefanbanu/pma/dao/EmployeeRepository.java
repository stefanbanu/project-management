package com.stefanbanu.pma.dao;

import com.stefanbanu.pma.entities.Employee;
import org.springframework.data.repository.CrudRepository;

public interface EmployeeRepository  extends CrudRepository<Employee, Long> {
}
