package com.stefanbanu.pma.controllers;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.stefanbanu.pma.dao.EmployeeRepository;
import com.stefanbanu.pma.dao.ProjectRepository;
import com.stefanbanu.pma.dto.ChartData;
import com.stefanbanu.pma.dto.EmployeeProject;
import com.stefanbanu.pma.entities.Employee;
import com.stefanbanu.pma.entities.Project;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class HomeController {

    private final ProjectRepository projectRepository;
    private final EmployeeRepository employeeRepository;

    @GetMapping("/")
    public String displayHome(Model model) throws JsonProcessingException {
        Map<String, Object> map = new HashMap<>();

        List<Project> projects = projectRepository.findAll();
        model.addAttribute("projects", projects);

        List<ChartData> chartData = projectRepository.projectsStatusCount();
        ObjectMapper objectMapper = new ObjectMapper();
        String jsonString = objectMapper.writeValueAsString(chartData);
        model.addAttribute("projectStatusCount", jsonString);

        List<EmployeeProject> employeeProjects = employeeRepository.employeesProjects();
        model.addAttribute("employeesListProjectCount", employeeProjects);
        return "main/home";
    }
}
