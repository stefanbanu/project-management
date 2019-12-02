package com.stefanbanu.pma;

import com.stefanbanu.pma.dao.EmployeeRepository;
import com.stefanbanu.pma.dao.ProjectRepository;
import com.stefanbanu.pma.entities.Employee;
import com.stefanbanu.pma.entities.Project;
import lombok.Builder;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Arrays;

@SpringBootApplication
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class ProjectManagementApplication {

    private final EmployeeRepository employeeRepository;
    private final ProjectRepository projectRepository;

    public static void main(String[] args) {
        SpringApplication.run(ProjectManagementApplication.class, args);
    }

    @Bean
    CommandLineRunner runner() {
        return args -> {
            Employee emp1 = Employee.builder().firstName("John").lastName("Warton").email("warton@gmail.com").build();
            Employee emp2 = Employee.builder().firstName("Mike").lastName("Lanister").email("lanister@gmail.com").build();
            Employee emp3 = Employee.builder().firstName("Steve").lastName("Reeves").email("Reeves@gmail.com").build();

            Employee emp4 = Employee.builder().firstName("Ronald").lastName("Connor").email("connor@gmail.com").build();
            Employee emp5 = Employee.builder().firstName("Jim").lastName("Salvator").email("Sal@gmail.com").build();
            Employee emp6 = Employee.builder().firstName("Peter").lastName("Henley").email("henley@gmail.com").build();

            Employee emp7 = Employee.builder().firstName("Richard").lastName("Carson").email("carson@gmail.com").build();
            Employee emp8 = Employee.builder().firstName("Honor").lastName("Miles").email("miles@gmail.com").build();
            Employee emp9 = Employee.builder().firstName("Tony").lastName("Roggers").email("roggers@gmail.com").build();

            Project pro1 = Project.builder()
                    .name("Large Production Deploy")
                    .stage("NOTSTARTED")
                    .description("This requires all hands on deck for the final deployment of the software into production")
                    .build();
            Project pro2 = Project.builder()
                    .name("New Employee Budget")
                    .stage("COMPLETED")
                    .description("Decide on a new employee bonus budget for the year and figureout who will be promoted")
                    .build();
            Project pro3 = Project.builder()
                    .name("Office Reconstruction")
                    .stage("INPROGRESS")
                    .description("The office building in Monroe has been damaged due to hurricane in the region. This needs to be reconstructed")
                    .build();
            Project pro4 = Project.builder()
                    .name("Improve Intranet Security")
                    .stage("INPROGRESS")
                    .description("With the recent data hack, the office security needs to be improved and proper security team needs to be hired for implementation")
                    .build();



            // need to set both sides of the relationship manually

            pro1.addEmployee(emp1);
            pro1.addEmployee(emp2);
            pro2.addEmployee(emp3);
            pro3.addEmployee(emp1);
            pro4.addEmployee(emp1);
            pro4.addEmployee(emp3);


            // need to set both sides of the relationship manually

            emp1.setProjects(Arrays.asList(pro1, pro3, pro4));
            emp2.setProjects(Arrays.asList(pro1));
            emp3.setProjects(Arrays.asList(pro2, pro4));

            // save employees in database

            employeeRepository.save(emp1);
            employeeRepository.save(emp2);
            employeeRepository.save(emp3);
            employeeRepository.save(emp4);
            employeeRepository.save(emp5);
            employeeRepository.save(emp6);
            employeeRepository.save(emp7);
            employeeRepository.save(emp8);
            employeeRepository.save(emp9);


            // save projects in database

            projectRepository.save(pro1);
            projectRepository.save(pro2);
            projectRepository.save(pro3);
            projectRepository.save(pro4);

        };
    }
}
