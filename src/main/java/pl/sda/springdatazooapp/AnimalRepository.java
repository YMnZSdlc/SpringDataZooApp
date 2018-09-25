package pl.sda.springdatazooapp;

import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface AnimalRepository extends MongoRepository<Animal, String> {

    List<Animal> findAllByAgeAndName(Integer age, String name);

    List<Animal> findAllByAgeBetweenAndWeightBetween(Integer ageMin, Integer ageMax, Integer weightMin, Integer weightMax);

    List<Animal> findAllByWeightAndHeightAndLegsBetween(Integer weight, Integer height, Integer legsMin, Integer legsMax);

    List<Animal> findAllByNameContainingAndCountry (String name, String country);

}
