package nl.hro.assignment2.rest;

import nl.hro.assignment2.models.Employee;
import nl.hro.assignment2.models.Position;
import nl.hro.assignment2.models.Project;
import nl.hro.assignment2.persistence.repository.EmployeeRepository;
import nl.hro.assignment2.persistence.repository.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;


@SuppressWarnings({"unused", "WeakerAccess"})
@RestController
public class RestMappings {

    @Autowired
    public EmployeeRepository employeeRepository;

    @Autowired
    public ProjectRepository projectRepository;

    @RequestMapping(value = "employees/{id}", method = RequestMethod.GET)
    public ResponseEntity<Employee> getEmployeeByBSN(@PathVariable("id") Integer bsn) {

        Employee employee = employeeRepository.findOne(bsn);

        if (employee == null) {
            return ResponseEntity.badRequest().body(null);
        }

        return ResponseEntity.ok(employee);
    }

    @RequestMapping(value = "projects/{id}", method = RequestMethod.GET)
    public ResponseEntity<Project> getProjectByID(@PathVariable("id") String id) {

        Project project = projectRepository.findOne(id);

        if (project == null) {
            return ResponseEntity.badRequest().body(null);
        }

        return ResponseEntity.ok(project);
    }

    /// 1
    @RequestMapping(value = "projects/workingStates", method = RequestMethod.GET)
    public ResponseEntity<Map<String,Integer>> getWorkingState() {
        Map<String, Integer> map = new HashMap<>(); // project id , amount of overworkers


        employeeRepository.findAll().forEach(
                employee -> {
                    int hours = employee.getPositions()
                            .stream()
                            .map(Position::getHours)
                            .reduce(Integer::sum)
                            .orElse(0);

                    employee.getPositions().forEach(
                            position -> {
                                Integer i = map.get(position.getProjectID());
                                map.put(
                                        position.getProjectID(),
                                        (hours > 20 ? (i != null ? ++i : 1) : (i != null ? i : 0))
                                );
                            }
                    );
                }
        );

        return ResponseEntity.ok(map);
    }


    private class WorkingHours {
        int bsn;
        int total;
        double average;
    }

    /// 2
    @RequestMapping(value = "employees/working_hours", method = RequestMethod.GET)
    public ResponseEntity<List<WorkingHours>> getTotalWorkHour() {
        List<WorkingHours> workingHoursList = employeeRepository.findAll().stream().map(
                employee -> {
                    WorkingHours wh = new WorkingHours();
                    wh.bsn = employee.getBsn();
                    wh.total = employee.getPositions().stream().map(
                            Position::getHours
                    ).reduce(Integer::sum).orElse(0);
                    wh.average = wh.total / employee.getPositions().size();

                    return wh;
                }
        ).collect(Collectors.toList());
        return ResponseEntity.ok(workingHoursList);
    }


    /// 3
    @RequestMapping(value = "employees/{id}/total_fee", method = RequestMethod.GET)
    public ResponseEntity<Double> getTotalWorkingFee(@PathVariable("id") Integer bsn) {
        Employee employee = employeeRepository.findOne(bsn);
        if (employee == null) return ResponseEntity.badRequest().body(null);

        Double fee = employee.getPositions()
                .stream()
                .map(p -> p.getHours()*p.getFeePerHour())
                .reduce(Double::sum)
                .orElse(.00);

        return ResponseEntity.ok(fee);
    }

}
