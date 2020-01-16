package com.stefanbanu.pma.services;

import com.stefanbanu.pma.dao.EmployeeRepository;
import com.stefanbanu.pma.dto.EmployeeProject;
import com.stefanbanu.pma.entities.Employee;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class EmployeeService {

	private final EmployeeRepository empRepo;

	public Employee save(Employee employee) {
		return empRepo.save(employee);
	}


	public List<Employee> getAll() {
		return empRepo.findAll();
	}


	public List<EmployeeProject> employeeProjects() {
		return empRepo.employeeProjects();
	}
	
}