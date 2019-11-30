package com.stefanbanu.pma.controllers;

import com.stefanbanu.pma.dao.ProjectRepository;
import com.stefanbanu.pma.entities.Project;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/projects")
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class ProjectController {

    private final ProjectRepository projectRepository;

    @GetMapping("/new")
    public String displayProjectForm(Model model) {
        Project project = new Project();
        model.addAttribute("project", project);
        return "projects/new-project";
    }

    @PostMapping("/save")
    public String createProject(Project project, Model model) {
        projectRepository.save(project);
        // use a redirect to prevent duplicate submissions
        return "redirect:/projects/new";
    }
}
