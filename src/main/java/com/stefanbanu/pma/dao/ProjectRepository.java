package com.stefanbanu.pma.dao;

import com.stefanbanu.pma.dto.ChartData;
import com.stefanbanu.pma.dto.EmployeeProject;
import com.stefanbanu.pma.entities.Project;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ProjectRepository extends CrudRepository<Project, Long> {

    @Override
    List<Project> findAll();

    @Query(nativeQuery = true, value ="select stage as status, COUNT(*) as count from project group by stage")
    List<ChartData> projectsStatusCount();
}
