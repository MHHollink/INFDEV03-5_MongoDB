package nl.hro.assignment2.rest;

import nl.hro.assignment2.models.Employee;
import nl.hro.assignment2.models.Headquarter;
import nl.hro.assignment2.models.Project;
import nl.hro.assignment2.persistence.repository.EmployeeRepository;
import nl.hro.assignment2.persistence.repository.HeadquarterRepository;
import nl.hro.assignment2.persistence.repository.ProjectRepository;
import nl.hro.assignment2.utils.RandomGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;


@RestController
public class TestController {

    @Autowired
    EmployeeRepository employeeRepository;

    @Autowired
    HeadquarterRepository headquarterRepository;

    @Autowired
    ProjectRepository projectRepository;

    @RequestMapping(value = "insert", method = RequestMethod.GET)
    public ResponseEntity insertRandomizedData() {
        employeeRepository.deleteAll();

        RandomGenerator generator = new RandomGenerator();

        List<Project> projects = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            projects.add(generator.project());
        }
        projectRepository.save(projects);

        List<Employee> employees = new ArrayList<>();
        for (int i = 0; i < 10000; i++) {
            Employee e = generator.employee();

            for (int j = 0; j < 3; j++)
                e.setPosition(generator.position(projects.get(new Random().nextInt(projects.size()))));

            employees.add(e);
        }
        employeeRepository.save(employees);

        List<Headquarter> headquarters = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            headquarters.add(generator.headquarter());
        }
        headquarterRepository.save(headquarters);

        return ResponseEntity.ok(
                String.format(
                        "Inserted %s projects, %s users and %s headquarters",
                        projects.size(),
                        employees.size(),
                        headquarters.size()
                )
        );
    }

}
