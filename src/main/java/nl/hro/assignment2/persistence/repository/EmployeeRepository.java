package nl.hro.assignment2.persistence.repository;

import nl.hro.assignment2.models.Employee;
import org.springframework.data.mongodb.repository.MongoRepository;


public interface EmployeeRepository extends MongoRepository<Employee, Integer> {


}
