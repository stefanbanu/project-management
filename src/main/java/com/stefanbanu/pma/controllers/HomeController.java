package com.stefanbanu.pma.controllers;

import com.stefanbanu.pma.dao.ProjectRepository;
import com.stefanbanu.pma.entities.Project;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class HomeController {

    private final ProjectRepository projectRepository;

    @GetMapping("/")
    public String displayHome(Model model) {
        List<Project> projects = projectRepository.findAll();
        model.addAttribute("projects", projects);
        return "main/home";
    }
}
