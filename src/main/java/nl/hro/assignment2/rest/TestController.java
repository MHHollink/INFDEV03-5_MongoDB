package nl.hro.assignment2.rest;

import nl.hro.assignment2.models.Employee;
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
import java.util.stream.Collectors;


@RestController
public class TestController {

    @Autowired
    EmployeeRepository employeeRepository;

    @Autowired
    HeadquarterRepository headquarterRepository;

    @Autowired
    ProjectRepository projectRepository;

    @RequestMapping(value = "insert", method = RequestMethod.GET)
    public ResponseEntity<Employee> insertRandomizedData() {
        employeeRepository.deleteAll();

        RandomGenerator generator = new RandomGenerator();


        List<Employee> employees = new ArrayList<>();

        for (int i = 0; i < 10000; i++) {
            employees.add(generator.employee());
        }

        employeeRepository.save(employees);

        return ResponseEntity.ok(employeeRepository.findAll().get(0));
    }


}
