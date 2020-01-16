package com.stefanbanu.pma.services;

import com.stefanbanu.pma.dao.ProjectRepository;
import com.stefanbanu.pma.dto.ChartData;
import com.stefanbanu.pma.entities.Project;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class ProjectService {
	
	private final ProjectRepository proRepo;
	
	public Project save(Project project) {
		return proRepo.save(project);
	}


	public List<Project> getAll() {
		return proRepo.findAll();
	}
	
	public List<ChartData> getProjectStatus(){
		return proRepo.getProjectStatus();
	}
	
}
