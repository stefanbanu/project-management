package com.stefanbanu.pma.dao;

import com.stefanbanu.pma.entities.Project;
import org.springframework.data.repository.CrudRepository;

public interface ProjectRepository extends CrudRepository<Project, Long> {
}
