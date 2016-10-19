package nl.hro.assignment2.persistence.repository;

import nl.hro.assignment2.models.Project;
import org.springframework.data.mongodb.repository.MongoRepository;


public interface ProjectRepository extends MongoRepository<Project, String> {
}
