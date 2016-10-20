package nl.hro.assignment2.persistence.repository;

import nl.hro.assignment2.models.Headquarter;
import org.springframework.data.mongodb.repository.MongoRepository;


public interface HeadquarterRepository extends MongoRepository<Headquarter, String> {
}
