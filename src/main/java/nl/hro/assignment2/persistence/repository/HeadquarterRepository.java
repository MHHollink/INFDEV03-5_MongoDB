package nl.hro.assignment2.persistence.repository;

import org.springframework.data.mongodb.repository.MongoRepository;


public interface HeadquarterRepository extends MongoRepository<HeadquarterRepository, String> {
}
