package com.stefanbanu.pma.controllers;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.stefanbanu.pma.dto.ChartData;
import com.stefanbanu.pma.dto.EmployeeProject;
import com.stefanbanu.pma.entities.Project;
import com.stefanbanu.pma.services.EmployeeService;
import com.stefanbanu.pma.services.ProjectService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class HomeController {
	
	@Value("${version}")
	private String ver;

	private final ProjectService proService;
	private final EmployeeService empService;

	@GetMapping("/")
	public String displayHome(Model model) throws JsonProcessingException {
		
		model.addAttribute("versionNumber", ver);
		
		// we are querying the database for projects
		List<Project> projects = proService.getAll();
		model.addAttribute("projectsList", projects);
		
		List<ChartData> projectData = proService.getProjectStatus();
		
		// Lets convert projectData object into a json structure for use in javascript
		ObjectMapper objectMapper = new ObjectMapper();
		String jsonString = objectMapper.writeValueAsString(projectData);
		// [["NOTSTARTED", 1], ["INPROGRESS", 2], ["COMPLETED", 1]]
		
		model.addAttribute("projectStatusCnt", jsonString);
		
		// we are querying the database for employees
		List<EmployeeProject> employeesProjectCnt = empService.employeeProjects();
		model.addAttribute("employeesListProjectsCnt", employeesProjectCnt);
		
		
		return "main/home";
		
	}
}
